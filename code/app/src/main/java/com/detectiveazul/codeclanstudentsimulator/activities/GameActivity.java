package com.detectiveazul.codeclanstudentsimulator.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.decks.Deck;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    //Game variables
    private Game game;
    private Player player;
    private Deck deck;
    //Stats bars
    private ProgressBar anxietyBar;
    private ProgressBar sleepBar;
    private ProgressBar socialLifeBar;
    private ProgressBar moneyBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialize views
        anxietyBar = findViewById(R.id.anxietyBarId);
        sleepBar = findViewById(R.id.sleepBarId);
        socialLifeBar = findViewById(R.id.socialLifeBarId);
        moneyBar = findViewById(R.id.moneyBarId);

        //Get game variables from intent
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");
        player = game.getPlayer();
        deck = game.getDeck();

        //Change title to player's name
        String title = getString(R.string.game_title_bar);
        changeTitleOfActivity(player.getName() + title);

        //Refresh the screen with the beginning of the game
        refresh();

    }

    private void refresh() {
        refreshStats();
    }

    private void refreshStats() {
        anxietyBar.setProgress(player.getStat(Stat.ANXIETY));
        sleepBar.setProgress(player.getStat(Stat.SLEEP));
        moneyBar.setProgress(player.getStat(Stat.MONEY));
        socialLifeBar.setProgress(player.getStat(Stat.SOCIAL_LIFE));

    }

    private void changeTitleOfActivity(String string) {
        getSupportActionBar().setTitle(string);

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
