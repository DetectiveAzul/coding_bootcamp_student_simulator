package com.detectiveazul.codeclanstudentsimulator.model.cards;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;

public class ProjectWeekCard extends Card {
    public ProjectWeekCard(CardCollection card) {
        super(card);
        setProjectWeek(true);
    }

    //Project Week card are perceived by the player as more stressfull, so it auto-increases his
    //anxiety


}
