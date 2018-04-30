package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum CardCollection {

    //Test cards
    TEST(-1, "A beer" , "A friend want a beer", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST2(-1, "A wine" , "A friend want a wine", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST3(-2, "A coke" , "A friend want a coke", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    PRIZE_TEST(-3, "A cookie" , "You finished Module1, have a cookie!", "Yes, please", "Omg", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),

    //Module 1 cards
    M1_1(1, "Beer Night" , "One of your classmates approaches: Hey, Do you want to hang out with us tonight?",
            "Oh, sure! A beer sounds fine", "I need to save money, sorry",
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    M1_2(1, "Study Group" , "The classroom is planning on spend the night studying nested for loops",
            "Join them", "Rest at home",
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.SLEEP_POSITIVE, StatEffect.ANXIETY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.SLEEP_NEGATIVE, StatEffect.ANXIETY_POSITIVE}),
    //Module 2 cards

    //Module 3 cards
    ;
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
