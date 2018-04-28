package com.detectiveazul.codeclanstudentsimulator.model;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;

import java.util.HashMap;

public class Card {
    private CardCollection card;
    private boolean prize;
    private HashMap<Stat, Boolean> primaryEffect;
    private HashMap<Stat, Boolean> secondaryEffect;

    public Card(CardCollection card, HashMap<Stat, Boolean> primaryEffect, HashMap<Stat, Boolean> secondaryEffect) {
        this.card = card;
        this.prize = false;
        this.primaryEffect = primaryEffect;
        this.secondaryEffect = secondaryEffect;
    }

    private CardCollection card() {
        return card;
    }
    public String getName() {
        return card().getName();
    }

    public int getModule() {
        return card().getModule();
    }

    public String getDescription() {
        return card().getDescription();
    }

    public String getPrimaryOption() {
        return card().getPrimaryOption();
    }

    public String getSecondaryOption() {
        return card().getSecondaryOption();
    }

    public Difficult getDifficult() {
        return card().getDifficult();
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    public HashMap<Stat, Boolean> getPrimaryEffect() {
        return primaryEffect;
    }

    public HashMap<Stat, Boolean> getSecondaryEffect() {
        return secondaryEffect;
    }
}
