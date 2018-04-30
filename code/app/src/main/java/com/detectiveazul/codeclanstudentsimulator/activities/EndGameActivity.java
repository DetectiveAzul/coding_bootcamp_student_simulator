package com.detectiveazul.codeclanstudentsimulator.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

public class EndGameActivity extends AppCompatActivity {
    private TextView playerNameTextView;
    private TextView gameResultTextView;
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
        Game game = (Game) intent.getSerializableExtra("game");
        Player player = game.getPlayer();
        //Printing
        playerNameTextView.setText(player.getName());
        gameResultTextView.setText(game.checkGameCondition().toString());
        }


}
