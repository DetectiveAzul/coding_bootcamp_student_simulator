package com.detectiveazul.codeclanstudentsimulator.activities;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;
import com.detectiveazul.codeclanstudentsimulator.database.GamelogDatabase;
import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.google.gson.Gson;

public class GameActivity extends AppCompatActivity {
    //Game variables
    private Game game;
    private Player player;
    //Player view
    private TextView playerNameTextView;
    private ProgressBar anxietyBar;
    private ProgressBar sleepBar;
    private ProgressBar socialLifeBar;
    private ProgressBar moneyBar;
    //Card text
    private TextView cardNameTextView;
    private TextView cardProjectCardTextView;
    private TextView cardDescriptionTextView;
    private TextView cardFirstOptionTextView;
    private TextView cardSecondOptionTextView;
    //Card image
    private TextView npcNameTextView;
    private ImageView npcFaceImageView;
    //Database
    private GamelogDatabase db;
    //Vibration
    Vibrator vibrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialize player views
        playerNameTextView = findViewById(R.id.PlayerNameTextViewId);
        anxietyBar = findViewById(R.id.anxietyBarId);
        sleepBar = findViewById(R.id.sleepBarId);
        socialLifeBar = findViewById(R.id.socialLifeBarId);
        moneyBar = findViewById(R.id.moneyBarId);

        //Initialize card views
        cardNameTextView = findViewById(R.id.cardTitleTextViewId);
        cardProjectCardTextView = findViewById(R.id.cardProjectTextViewId);
        cardDescriptionTextView = findViewById(R.id.cardDescriptionTextViewId);
        cardFirstOptionTextView = findViewById(R.id.cardFirstOptionTextViewId);
        cardSecondOptionTextView = findViewById(R.id.cardSecondOptionTextViewId);

        //Initialize card image
        npcNameTextView = findViewById(R.id.npcNameTextViewId);
        npcFaceImageView = findViewById(R.id.npcFaceImageViewId);

        //Creating the vibrator
        vibrator = (Vibrator) GameActivity.this.getSystemService(Context.VIBRATOR_SERVICE);


        //Load game
        game = loadGame();
        player = game.getPlayer();

        //Refresh the screen
        refreshView();

    }

    //VIEW REFRESHERS
    private void refreshView() {
        refreshStatsView();
        refreshTimeView();
        refreshCardView();
        refreshCardImage();
    }

    private void refreshStatsView() {
        playerNameTextView.setText(player.getName());
        anxietyBar.setProgress(player.getStat(Stat.ANXIETY));
        sleepBar.setProgress(player.getStat(Stat.SLEEP));
        moneyBar.setProgress(player.getStat(Stat.MONEY));
        socialLifeBar.setProgress(player.getStat(Stat.SOCIAL_LIFE));
    }

    private void refreshTimeView() {
        String week = getString(R.string.title_bar_week);
        String day = getString(R.string.title_bar_day);
        int weekNumber = game.getWeek();
        int dayNumber = game.getDay();
        changeTitleOfActivity(week + weekNumber + day + dayNumber);

    }

    private void refreshCardView() {
        Card card = game.getCurrentCard();
        cardNameTextView.setText(card.getName());
        if (!card.isProjectWeek()) { cardProjectCardTextView.setVisibility(View.INVISIBLE);
        } else {
            cardProjectCardTextView.setVisibility(View.VISIBLE); }
        cardDescriptionTextView.setText(card.getDescription());
        cardFirstOptionTextView.setText(card.getPrimaryOption());
        cardSecondOptionTextView.setText(card.getSecondaryOption());
    }

    private void refreshCardImage() {
        npcNameTextView.setText(game.getCurrentCard().getPersonName());
        String string = game.getCurrentCard().getFaceFileName();
        int drawableFace = getDrawable(string);
        npcFaceImageView.setImageResource(drawableFace);
    }

    private int getDrawable(String drawableName) {
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        return resID;
    }

    private void changeTitleOfActivity(String string) {
        getSupportActionBar().setTitle(string);

    }

    //Player Options to Select
    public void onFirstOptionSelected(View view) {
        vibrator.vibrate(50);
        game.playerTakeFirstOption(game.getCurrentCard());
        gameLoop();
    }

    public void onSecondOptionSelected(View view) {
        vibrator.vibrate(50);
        game.playerTakeSecondOption(game.getCurrentCard());
        gameLoop();
    }

    //Game Loop
    private void gameLoop() {
        game.turnEnds();
        if (game.checkGameCondition() != GameStatus.IN_PROGRESS) {
            finishGame();
        } else {
            newTurn();
        }
    }

    private void finishGame() {
        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
        savingLog();
        deleteGame();
        finish();
    }

    private void newTurn() {
        game.turnBegins();
        saveGame(game);
        Log.d("Game saved: ", game.getPlayer().getName());
        refreshView();
    }

    //Loading and Saving game
    private Game loadGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        String gameSaved = sharedPref.getString("saved game", "{}");
        Gson gson = new Gson();
        Game myGame = gson.fromJson(gameSaved, Game.class);
        return myGame;
    }

    private void saveGame(Game game) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString("saved game", gson.toJson(game));
        editor.apply();
    }

    private void deleteGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("saved game", "{}");
        editor.apply();
    }


    //Menu handling
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_game_menu, menu);
        return true;
    }

    //Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.action_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Saving the ranking at ending the game
    private void savingLog() {
        db = Room.databaseBuilder(getApplicationContext(), GamelogDatabase.class,
                "gamelog-database").build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gamelog gamelog =new Gamelog();
                gamelog.setStudentName(player.getName());
                gamelog.setWeek(game.getWeek());
                gamelog.setDay(game.getDay());
                gamelog.setScore(player.getScore());
                gamelog.setResult(game.checkGameCondition().toString());
                db.gamelogDao().insertAll(gamelog);
                Log.d("Entry saved", "Entry saved for player " + player.getName());
            }
        }).start();
    }

}
