package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum Stat {
    MONEY("Money"),
    SOCIAL_LIFE("Social life"),
    ANXIETY("Anxiety"),
    SLEEP("Sleep");

    private final String prettyName;

    Stat(String prettyName) {
        this.prettyName = prettyName;
    }

    public String getPrettyName() {
        return prettyName;
    }
}
