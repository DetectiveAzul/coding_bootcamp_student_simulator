package com.detectiveazul.codeclanstudentsimulator.model.cards;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Difficult;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;

import java.util.HashMap;

public class PrizeCard extends Card {
    public PrizeCard(CardCollection card) {
        super(card);
        setPrize(true);
        resetEffects();
    }

    public int getDifficult() {
        return Difficult.EASY.getLevel();
    }

    private void resetEffects() {
        resetPrimaryEffect();
        resetSecondaryEffect();
    }

    //It reset the card effect so it balances the player, like a prize, after finishing a module
    private void resetPrimaryEffect() {
        resetEffect(getPrimaryEffect());
    }

    private void resetSecondaryEffect() {
        resetEffect(getSecondaryEffect());
    }

    private void resetEffect(HashMap<Stat, Boolean> effect) {
        effect.put(Stat.MONEY, true);
        effect.put(Stat.SOCIAL_LIFE, true);
        effect.put(Stat.ANXIETY, false);
        effect.put(Stat.SLEEP, false);
    }

}
