package com.detectiveazul.codeclanstudentsimulator.model.Constants;

import android.graphics.Bitmap;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;

import java.lang.reflect.Array;

public enum CardCollection {
    TEST(1, "A beer", "A friend want a beer",
            "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE});

    private final int module;
    private final String name;
    private final String description;
    private final String primaryOption;
    private final String secondaryOption;
    private final Difficult difficult;
    private final StatEffect[] primaryEffect;
    private final StatEffect[] secondaryEffect;

    CardCollection(int module, String name, String description, String primaryOption,
                   String secondaryOption, Difficult difficult, StatEffect[] primaryEffect,
                   StatEffect[] secondaryEffect) {

        this.module = module;
        this.name = name;
        this.description = description;
        this.primaryOption = primaryOption;
        this.secondaryOption = secondaryOption;
        this.difficult = difficult;
        this.primaryEffect = primaryEffect;
        this.secondaryEffect = secondaryEffect;
    }

    public int getModule() {
        return module;
    }

    public String getName() {
        return name;
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

    public StatEffect[] getPrimaryEffect() {
        return primaryEffect;
    }

    public StatEffect[] getSecondaryEffect() {
        return secondaryEffect;
    }
}
