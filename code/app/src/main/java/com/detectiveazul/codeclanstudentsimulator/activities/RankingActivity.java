package com.detectiveazul.codeclanstudentsimulator.activities;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.adapter.RankingAdapter;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;
import com.detectiveazul.codeclanstudentsimulator.database.GamelogDatabase;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    private GamelogDatabase db;
    private ArrayList<Gamelog> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        //Save the database onto the list variable
        setListOfGameLog();

        //Change it to an array for the adapter

        //Pass it to our custom adapter
        RankingAdapter rankingAdapter = new RankingAdapter(this, list);

        //Initialize the listview
        ListView listView = (ListView) findViewById(R.id.rankingListViewId);
        listView.setAdapter(rankingAdapter);
    }

    //Load the database and put it into a list
    private void setListOfGameLog() {
            db = Room.databaseBuilder(getApplicationContext(), GamelogDatabase.class,
                    "gamelog-database").build();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.addAll(db.gamelogDao().getAll());
                    Log.d("List has", "number of entries: " + list.size());
                }
            }).start();
        }
    }

