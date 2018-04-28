package com.detectiveazul.codeclanstudentsimulator.model.Constants;

import com.detectiveazul.codeclanstudentsimulator.model.Card;

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
