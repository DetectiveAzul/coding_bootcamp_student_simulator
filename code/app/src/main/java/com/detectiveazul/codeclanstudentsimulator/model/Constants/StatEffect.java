package com.detectiveazul.codeclanstudentsimulator.model.Constants;

public enum  StatEffect {
    MONEY_POSITIVE(Stat.MONEY, true),
    MONEY_NEGATIVE(Stat.MONEY, false),
    ANXIETY_POSITIVE(Stat.ANXIETY, true),
    ANXIETY_NEGATIVE(Stat.ANXIETY, false),
    SOCIAL_POSITIVE(Stat.SOCIAL_LIFE, true),
    SOCIAL_NEGATIVE(Stat.SOCIAL_LIFE, false),
    SLEEP_POSITIVE(Stat.SLEEP, true),
    SLEEP_NEGATIVE(Stat.SLEEP, false);

    private final Stat stat;
    private final boolean positiveEffect;

    StatEffect(Stat stat, boolean positiveEffect) {
        this.stat = stat;
        this.positiveEffect = positiveEffect;
    }

    public Stat getStat() {
        return stat;
    }

    public boolean isPositiveEffect() {
        return positiveEffect;
    }
}
