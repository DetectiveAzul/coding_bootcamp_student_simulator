package com.detectiveazul.codeclanstudentsimulator.activities;

import android.content.Intent;
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
        Player player = new Player("Test Player");
        Game game = new Game(player);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("game", game);

        startActivity(intent);

    }


}
