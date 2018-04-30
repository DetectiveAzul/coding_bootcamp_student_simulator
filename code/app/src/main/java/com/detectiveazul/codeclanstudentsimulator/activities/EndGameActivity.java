package com.detectiveazul.codeclanstudentsimulator.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;
import com.detectiveazul.codeclanstudentsimulator.database.GamelogDatabase;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

public class EndGameActivity extends AppCompatActivity {
    //Views objects
    private TextView playerNameTextView;
    private TextView gameResultTextView;

    //Game and Player Objects
    private Game game;
    private Player player;

    //Database object
    private GamelogDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        //Initializing views
        playerNameTextView = findViewById(R.id.playerNameTextViewID);
        gameResultTextView = findViewById(R.id.resultTextViewId);

        //Getting the intent
        Intent intent = getIntent();
        //Getting the extras
        game = (Game) intent.getSerializableExtra("game");
        player = game.getPlayer();

        //Printing
        playerNameTextView.setText(player.getName());
        gameResultTextView.setText(game.checkGameCondition().toString());

        //Saving the log
        savingLog();
        }

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
