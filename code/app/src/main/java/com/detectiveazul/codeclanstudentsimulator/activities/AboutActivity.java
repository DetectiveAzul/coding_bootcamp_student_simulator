package com.detectiveazul.codeclanstudentsimulator.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.detectiveazul.codeclanstudentsimulator.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Changing the action bar title
        getSupportActionBar().setTitle(R.string.menu_about);
    }
}
