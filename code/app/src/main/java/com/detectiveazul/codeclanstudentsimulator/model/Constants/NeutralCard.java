package com.detectiveazul.codeclanstudentsimulator.model.Constants;

import com.detectiveazul.codeclanstudentsimulator.model.Card;

public class NeutralCard extends Card {
    public NeutralCard(CardCollection card) {
        super(card);
    }

    public int getDifficult() {
        return 0;
    }
}
