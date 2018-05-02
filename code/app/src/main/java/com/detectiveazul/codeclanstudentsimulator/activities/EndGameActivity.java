package com.detectiveazul.codeclanstudentsimulator.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;
import com.detectiveazul.codeclanstudentsimulator.database.GamelogDatabase;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.PlayerStatus;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

public class EndGameActivity extends AppCompatActivity {
    //Views objects
    private TextView endPlayerNameTextView;
    private TextView endSceneTitleTextView;
    private TextView winLoseDescriptionTextView;

    //Game and Player Objects
    private Game game;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        //Initializing views
        endPlayerNameTextView = findViewById(R.id.endPlayerNameTextViewId);
        endSceneTitleTextView = findViewById(R.id.endSceneTitleTextViewId);
        winLoseDescriptionTextView = findViewById(R.id.winLoseDescriptionTextViewId);

        //Getting the intent
        Intent intent = getIntent();
        //Getting the extras
        game = (Game) intent.getSerializableExtra("game");
        player = game.getPlayer();

        //Printing
        endPlayerNameTextView.setText(player.getName());
        endSceneTitleTextView.setText(game.getEndTitleString());
        if (player.checkStatus() == PlayerStatus.DEAD)
            winLoseDescriptionTextView.setText(game.getDeadString());

        //changing the action bar title
        refreshTimeView();

    }

    //To put the last day on the title Screen
    private void refreshTimeView() {
        String week = getString(R.string.title_bar_week);
        String day = getString(R.string.title_bar_day);
        int weekNumber = game.getWeek();
        int dayNumber = game.getDay();
        getSupportActionBar().setTitle(week + weekNumber + day + dayNumber);
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
