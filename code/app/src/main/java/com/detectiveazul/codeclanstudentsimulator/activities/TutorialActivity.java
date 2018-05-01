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
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.activities.StartMenuActivity;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.google.gson.Gson;

public class TutorialActivity extends AppCompatActivity {
    private TextView playerNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        //Get views
        playerNameEditText = findViewById(R.id.newPlayerNameEditTextId);

        //Change actionbar title
        getSupportActionBar().setTitle(R.string.tutorial);
    }

    private String getNewPlayerName() {
        String name = playerNameEditText.getText().toString();
        if (name.length() < 1) return "Generic Student";
        playerNameEditText.setText("");
        return name;
    }

    public void onUnderstoodButtonClicked(View view) {
        //Delete previous game
        deleteGame();
        //Then create the game
        Player player = new Player(getNewPlayerName());
        Game game = new Game(player);
        //Instantiate the first turn
        game.turnBegins();
        //Save the game
        saveGame(game);
        //And go to the game Activity
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
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

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_start_menu, menu);
        return true;
    }

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

}
