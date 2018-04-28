package com.detectiveazul.codeclanstudentsimulator.model.cards;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;

public class NeutralCard extends Card {
    public NeutralCard(CardCollection card) {
        super(card);
    }

    public int getDifficult() {
        return 0;
    }
}
