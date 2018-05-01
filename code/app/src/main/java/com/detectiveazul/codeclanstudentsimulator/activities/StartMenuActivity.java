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
import android.widget.EditText;
import android.widget.Toast;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class StartMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

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

    //Clicking buttons
    public void onNewGameButtonClicked(View button) {
        Intent tutorialIntent = new Intent(this, TutorialActivity.class);
        startActivity(tutorialIntent);

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

    private Game loadGame() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.saved_game), Context.MODE_PRIVATE);
        String gameSaved = sharedPref.getString("saved game", "{}");
        Gson gson = new Gson();
        Game myGame = gson.fromJson(gameSaved, Game.class);
        return myGame;
    }


}
