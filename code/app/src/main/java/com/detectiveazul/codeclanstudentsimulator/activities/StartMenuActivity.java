package com.detectiveazul.codeclanstudentsimulator.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.google.gson.Gson;

public class StartMenuActivity extends AppCompatActivity {
    private Button newGameButton;
    private Button loadGameButton;
    private Button rankingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        newGameButton = findViewById(R.id.newGameButtonId);
        loadGameButton = findViewById(R.id.loadButtonId);
        rankingButton = findViewById(R.id.rankingButtonId);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_start_menu, menu);
        return true;
    }

    //Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_menu) {
            Toast.makeText(StartMenuActivity.this, R.string.toast_menu_start,
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.action_log) {
            Toast.makeText(StartMenuActivity.this, R.string.toast_menu_log,
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.action_about) {
            Toast.makeText(StartMenuActivity.this, R.string.toast_menu_about,
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.action_exit) {
            Toast.makeText(StartMenuActivity.this, R.string.toast_menu_exit,
                    Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Clicking buttons
    public void onNewGameButtonClicked(View button) {
        //Delete previous game
        deleteGame();
        //Then create the game
        Player player = new Player("Test Player");
        Game game = new Game(player);
        //Instantiate the first turn
        game.turnBegins();
        //Save the game
        saveGame(game);
        //And go to the game Activity
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

    public void onLoadGameClicked(View button) {
        ////Testing load after deleting the game
        //deleteGame();

        //Check if there is any saved game
        Game game = loadGame();
        if (game.getPlayer() == null) {
            //If there is not, send a TOAST
            Toast.makeText(StartMenuActivity.this, R.string.toast_menu_cannot_load,
                    Toast.LENGTH_SHORT).show();

        } else {
            //If there is, load the game activity
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }

    public void onRankingClicked(View button) {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
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

    private Game loadGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        String gameSaved = sharedPref.getString("saved game", "{}");
        Gson gson = new Gson();
        Game myGame = gson.fromJson(gameSaved, Game.class);
        return myGame;
    }


}
