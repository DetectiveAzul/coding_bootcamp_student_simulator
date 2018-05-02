package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum CardCollection {

    //Test cards
    TEST(-1, Person.STUDENT, "A beer" , "A friend want a beer", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST2(-1, Person.STUDENT, "A wine" , "A friend want a wine", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST3(-2, Person.STUDENT, "A coke" , "A friend want a coke", "Yes, please", "I should study...", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    PRIZE_TEST(-3, Person.STUDENT, "A cookie" , "You finished Module1, have a cookie!", "Yes, please", "Omg", Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),

    //Module 1 cards
    M1_1(1,Person.STUDENT, "Beer Afternoon" , "One of your classmates approaches: Hey, Do you want to hang out with us?",
            "Oh, sure! A beer sounds fine", "I need to save money, sorry",
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    M1_2(1,Person.STUDENT, "Study Group" , "The classroom is planning on spending the night studying nested forloops",
            "I'm joining them", "Rest at home",
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.SLEEP_NEGATIVE, StatEffect.ANXIETY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.SLEEP_POSITIVE, StatEffect.ANXIETY_POSITIVE}),
    M1_3(1,Person.TEACHER, "S.O.L.I.D" , "Today's homework is to see a series of videos about Object Oriented Principles, but you don't understand yesterday's homework yet",
            "Watch the videos only. Time is valuable", "Study first, then videos, sleep tomorrow",
            Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SLEEP_NEGATIVE}),
    M1_4(1,Person.TEACHER, "Stolen Charger" , "Your laptop's charger has disappeared during boardgame night",
            "Blame your classmates and try to recover it", "Buy a new one",
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE},
            new StatEffect[] {StatEffect.MONEY_NEGATIVE}),
    M1_5(1, Person.TEACHER, "BoardGame Night" , "The school is throwing a boardgame night full of free beer and pizzas",
            "YAY!", "No homework, time to study!!",
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_POSITIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE}),
    M1_6(1, Person.FLATMATE, "Broken fridge" , "Your fridge is broken, damn!",
            "Buy new fridge", "Get food from the corner everyday",
            Difficult.HARD,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.MONEY_NEGATIVE}),
    //Module 2 cards

    //Module 3 cards
    ;
    private final int module;
    private final Person person;
    private final String name;
    private final String description;
    private final String primaryOption;
    private final String secondaryOption;
    private final Difficult difficult;
    private final StatEffect[] primaryEffect;
    private final StatEffect[] secondaryEffect;

    CardCollection(int module, Person person, String name, String description, String primaryOption,
                   String secondaryOption, Difficult difficult, StatEffect[] primaryEffect,
                   StatEffect[] secondaryEffect) {

        this.module = module;
        this.person = person;
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

    public Person getPerson() {
        return person;
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
