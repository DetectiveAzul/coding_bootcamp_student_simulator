package com.detectiveazul.codeclanstudentsimulator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.detectiveazul.codeclanstudentsimulator.R;
import com.detectiveazul.codeclanstudentsimulator.database.Gamelog;

import java.util.ArrayList;

public class RankingAdapter extends ArrayAdapter<Gamelog> {
    public RankingAdapter(Context context, ArrayList<Gamelog> gamelogs) {
        super(context, 0, gamelogs);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        // UPDATED Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.ranking_item, parent, false);
        }

        Gamelog currentGamelog = getItem(position);

        TextView playerName = (TextView) listItemView.findViewById(R.id.rankingItemPlayerNameTextViewId);
        TextView playerScore = (TextView) listItemView.findViewById(R.id.rankingItemPlayerScoreTextViewId);
        TextView playerWeek = (TextView) listItemView.findViewById(R.id.rankingItemWeekTextViewId);
        TextView playerDay = (TextView) listItemView.findViewById(R.id.rankingItemDayTextViewId);
        TextView gameResult = (TextView) listItemView.findViewById(R.id.rankingItemGameResultViewId);
        TextView id = (TextView) listItemView.findViewById(R.id.rankingItemGamelogIdTextViewId);

        String gameLogPosition = "" + (position + 1);
        playerName.setText(currentGamelog.getStudentName());
        playerScore.setText(currentGamelog.getScore().toString());
        playerWeek.setText(currentGamelog.getWeek().toString());
        playerDay.setText(currentGamelog.getDay().toString());
        gameResult.setText(currentGamelog.getResult());
        id.setText(gameLogPosition);
        return listItemView;
    }
}
