package com.detectiveazul.codeclanstudentsimulator.model.cards;

import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.constants.StatEffect;

import java.io.Serializable;
import java.util.HashMap;

public class Card implements Serializable {
    private CardCollection card;
    private boolean prize;
    private boolean projectWeek;
    private HashMap<Stat, Boolean> primaryEffect;
    private HashMap<Stat, Boolean> secondaryEffect;

    public Card(CardCollection card) {
        this.card = card;
        this.prize = false;
        this.projectWeek = false;
        this.primaryEffect = new HashMap<>();
        this.secondaryEffect = new HashMap<>();
        setEffects();
    }

    //Basic Getters will get the information from the Enum CardCollection

    public CardCollection card() {
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

    public int getDifficult() {
        return card().getDifficult().getLevel();
    }

    public boolean isPrize() {
        return prize;
    }

    public boolean isProjectWeek() {
        return projectWeek;
    }

    public void setProjectWeek(boolean projectWeek) {
        this.projectWeek = projectWeek;
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

    //Run once during the creation of the card, it will take the array of StatEffect[] from the
    //CardCollection Enum and create a hashmap with a Stat and a boolean to know if the effect
    //is positive or not

    private void setEffects() {
        setPrimaryEffect();
        setSecondaryEffect();
    }

    private void setPrimaryEffect() {
        for (StatEffect combination: card.getPrimaryEffect()) {
            this.primaryEffect.put(combination.getStat(), combination.isPositiveEffect());
        }
    }

    private void setSecondaryEffect() {
        for (StatEffect combination: card.getSecondaryEffect()) {
            this.secondaryEffect.put(combination.getStat(), combination.isPositiveEffect());
        }
    }





}
