package com.detectiveazul.codeclanstudentsimulator.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.detectiveazul.codeclanstudentsimulator.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Changing the action bar title
        getSupportActionBar().setTitle(R.string.menu_about);
    }

    public void onGitHubClick(View view) {
        openWebURL("https://github.com/DetectiveAzul/codeclan_student_simulator");
    }

    public void onFlatIconClick(View view) {
        openWebURL("https://www.flaticon.com/authors/ddara");
    }

    private void openWebURL(String url) {
        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse(url) );
        startActivity( browse );
    }
}
