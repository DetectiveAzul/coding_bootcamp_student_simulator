package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum Difficult {
    NEUTRAL("Neutral", 0),
    EASY("Easy", 10),
    MEDIUM("Medium", 15),
    HARD("Hard", 20),
    EXTRA_HARD("Extra Hard", 30);

    private final String prettyName;
    private final int level;

    Difficult(String prettyName, int level) {
        this.prettyName = prettyName;
        this.level = level;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getLevel() {
        return level;
    }
}
