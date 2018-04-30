package com.detectiveazul.codeclanstudentsimulator.activities;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;
import com.detectiveazul.codeclanstudentsimulator.database.GamelogDatabase;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    private GamelogDatabase db;
    private List<Gamelog> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getListOfGameLog();

    }

    private void getListOfGameLog() {
            db = Room.databaseBuilder(getApplicationContext(), GamelogDatabase.class,
                    "gamelog-database").build();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    list = db.gamelogDao().getAll();
                    Log.d("List has", "number of entries: " + list.size());
                }
            }).start();
        }
    }

