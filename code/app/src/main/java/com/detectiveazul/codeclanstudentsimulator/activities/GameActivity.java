package com.detectiveazul.codeclanstudentsimulator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.decks.Deck;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.google.gson.Gson;

public class GameActivity extends AppCompatActivity {
    //Game variables
    private Game game;
    private Player player;
    private Deck deck;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialize player views
        playerNameTextView = findViewById(R.id.playerNameId);
        anxietyBar = findViewById(R.id.anxietyBarId);
        sleepBar = findViewById(R.id.sleepBarId);
        socialLifeBar = findViewById(R.id.socialLifeBarId);
        moneyBar = findViewById(R.id.moneyBarId);

        //Initialize card views
        cardNameTextView = findViewById(R.id.cardNameTextViewId);
        cardProjectCardTextView = findViewById(R.id.cardProjectTextViewId);
        cardDescriptionTextView = findViewById(R.id.cardDescriptionTextViewId);
        cardFirstOptionTextView = findViewById(R.id.cardFirstOptionTextViewId);
        cardSecondOptionTextView = findViewById(R.id.cardSecondOptionTextViewId);

        //Load game
        game = loadGame();
        player = game.getPlayer();
        deck = game.getDeck();

        //Refresh the screen
        refreshView();

    }

    private void refreshView() {
        refreshStatsView();
        refreshTimeView();
        refreshCardView();
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

    private void changeTitleOfActivity(String string) {
        getSupportActionBar().setTitle(string);

    }

    public void onFirstOptionSelected(View view) {
        game.playerTakeFirstOption(game.getCurrentCard());
        gameLoop();
    }

    public void onSecondOptionSelected(View view) {
        game.playerTakeSecondOption(game.getCurrentCard());
        gameLoop();
    }

    private void gameLoop() {
        game.turnEnds();
        if (game.checkGameCondition() != GameStatus.IN_PROGRESS) {
            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("player", player);
            startActivity(intent);
            deleteGame();
            finish();
        } else {
            game.turnBegins();
            saveGame(game);
            Log.d("Game saved: ", game.getPlayer().getName());
            refreshView();
        }
    }

    private void saveGame(Game game) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        editor.putString("saved game", gson.toJson(game));
        editor.apply();
    }

    private Game loadGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        String gameSaved = sharedPref.getString("saved game", "{}");
        Gson gson = new Gson();
        Game myGame = gson.fromJson(gameSaved, Game.class);
        return myGame;
    }

    private void deleteGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("saved game", "{}");
        editor.apply();
    }

//    //Menu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.activity_start_menu, menu);
//        return true;
//    }
//
//    //Menu
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.action_menu) {
//            Toast.makeText(GameActivity.this, R.string.toast_menu_start,
//                    Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (item.getItemId() == R.id.action_log) {
//            Toast.makeText(GameActivity.this, R.string.toast_menu_log,
//                    Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (item.getItemId() == R.id.action_about) {
//            Toast.makeText(GameActivity.this, R.string.toast_menu_about,
//                    Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        if (item.getItemId() == R.id.action_exit) {
//            Toast.makeText(GameActivity.this, R.string.toast_menu_exit,
//                    Toast.LENGTH_SHORT).show();
//            finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
