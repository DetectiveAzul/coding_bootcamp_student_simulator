package com.detectiveazul.codeclanstudentsimulator.model.constants;

import com.detectiveazul.codeclanstudentsimulator.R;

public enum Stat {
    MONEY(R.string.money, R.string.money_over, R.string.money_below),
    SOCIAL_LIFE(R.string.social_life, R.string.social_life_over, R.string.social_life_below),
    ANXIETY(R.string.anxiety, R.string.anxiety_over, R.string.anxiety_below),
    SLEEP(R.string.sleep,R.string.anxiety_over,R.string.anxiety_below);

    private final int prettyName;
    private final int deadOver;
    private final int deadBelow;

    Stat(int prettyName, int deadOver, int deadBelow) {
        this.prettyName = prettyName;
        this.deadOver = deadOver;
        this.deadBelow = deadBelow;
    }

    public int getPrettyName() {
        return prettyName;
    }

    public int getDeadOver() {
        return deadOver;
    }

    public int getDeadBelow() {
        return deadBelow;
    }
}
