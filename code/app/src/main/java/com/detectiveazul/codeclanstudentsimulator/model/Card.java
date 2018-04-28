package com.detectiveazul.codeclanstudentsimulator.model;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;

import java.util.HashMap;

public class Card {

    private String name;
    private int module;
    private String description;
    private String primaryOption;
    private String secondaryOption;
    private Difficult difficult;
    private boolean prize;
    private HashMap<Stat, Boolean> primaryEffect;
    private HashMap<Stat, Boolean> secondaryEffect;

    public Card(String name, int module, String description, String primaryOption, String secondaryOption,
                Difficult difficult, boolean prize, HashMap<Stat, Boolean> primaryEffect,
                HashMap<Stat, Boolean> secondaryEffect) {
        this.name = name;
        this.module = module;
        this.description = description;
        this.primaryOption = primaryOption;
        this.secondaryOption = secondaryOption;
        this.difficult = difficult;
        this.prize = prize;
        this.primaryEffect = primaryEffect;
        this.secondaryEffect = secondaryEffect;
    }

    public String getName() {
        return name;
    }

    public int getModule() {
        return module;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimaryOption() {
        return primaryOption;
    }

    public String getSecondaryOption() {
        return secondaryOption;
    }

    public Difficult getDifficult() {
        return difficult;
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }
}
