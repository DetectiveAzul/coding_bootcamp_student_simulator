package com.detectiveazul.codeclanstudentsimulator.model.constants;

import com.detectiveazul.codeclanstudentsimulator.R;

public enum CardCollection {

    //Test cards
    TEST(-1, Person.STUDENT, R.string.m1c01_name , R.string.m1c01_description,
            R.string.m1c01_first_option, R.string.m1c01_second_option, Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST2(-1, Person.STUDENT, R.string.m1c01_name , R.string.m1c01_description,
            R.string.m1c01_first_option, R.string.m1c01_second_option, Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    TEST3(-2, Person.STUDENT, R.string.m1c01_name , R.string.m1c01_description,
            R.string.m1c01_first_option, R.string.m1c01_second_option, Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),
    PRIZE_TEST(-3, Person.STUDENT, R.string.m1c01_name , R.string.m1c01_description,
            R.string.m1c01_first_option, R.string.m1c01_second_option, Difficult.EASY,
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),

    //Module 1 cards
    M1_1(1,Person.STUDENT, R.string.m1c01_name , R.string.m1c01_description,
            R.string.m1c01_first_option, R.string.m1c01_second_option,
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.MONEY_POSITIVE}),

    //Module 2 cards

    //Module 3 cards
    ;
    private final int module;
    private final Person person;
    private final int name;
    private final int description;
    private final int primaryOption;
    private final int secondaryOption;
    private final Difficult difficult;
    private final StatEffect[] primaryEffect;
    private final StatEffect[] secondaryEffect;

    CardCollection(int module, Person person, int name, int description, int primaryOption,
                   int secondaryOption, Difficult difficult, StatEffect[] primaryEffect,
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

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getPrimaryOption() {
        return primaryOption;
    }

    public int getSecondaryOption() {
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
