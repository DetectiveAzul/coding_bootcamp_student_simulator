package com.detectiveazul.codeclanstudentsimulator.model.constants;

import com.detectiveazul.codeclanstudentsimulator.R;

public enum Difficult {
    NEUTRAL(R.string.neutral, 0),
    EASY(R.string.easy, 10),
    MEDIUM(R.string.medium, 15),
    HARD(R.string.hard, 25),
    EXTRA_HARD(R.string.extra_hard, 35);

    private final int prettyName;
    private final int level;

    Difficult(int prettyName, int level) {
        this.prettyName = prettyName;
        this.level = level;
    }

    public int getPrettyName() {
        return prettyName;
    }

    public int getLevel() {
        return level;
    }
}
