package com.detectiveazul.codeclanstudentsimulator.model.Constants;

import android.graphics.Bitmap;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;

public enum CardCollection {
    TEST(1, "A beer", "A friend want a beer",
            "Yes, please", "I should study...", Difficult.EASY);

    private final int module;
    private final String name;
    private final String description;
    private final String primaryOption;
    private final String secondaryOption;
    private final Difficult difficult;

    CardCollection(int module, String name, String description, String primaryOption,
                   String secondaryOption, Difficult difficult) {
        this.module = module;
        this.name = name;
        this.description = description;
        this.primaryOption = primaryOption;
        this.secondaryOption = secondaryOption;
        this.difficult = difficult;
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
}
