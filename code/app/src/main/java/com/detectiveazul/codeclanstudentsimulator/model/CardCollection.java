package com.detectiveazul.codeclanstudentsimulator.model;

import android.graphics.Bitmap;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;

public enum CardCollection {
    TEST("A beer", 1, "A friend want a beer",
            "Yes, please", "I should study...", Difficult.EASY);

    private final String name;
    private final int module;
    private final String description;
    private final String primaryOption;
    private final String secondaryOption;
    private final Difficult difficult;

    CardCollection(String name, int module, String description, String primaryOption,
                   String secondaryOption, Difficult difficult) {
        this.name = name;
        this.module = module;
        this.description = description;
        this.primaryOption = primaryOption;
        this.secondaryOption = secondaryOption;
        this.difficult = difficult;
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
}
