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
    M1_2(1,Person.FLATMATE, R.string.m1c02_name , R.string.m1c02_description,
            R.string.m1c02_first_option, R.string.m1c02_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.SLEEP_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.SLEEP_POSITIVE}),
    M1_3(1,Person.TEACHER, R.string.m1c03_name , R.string.m1c03_description,
            R.string.m1c03_first_option, R.string.m1c03_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SLEEP_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SLEEP_POSITIVE}),
    M1_4(1,Person.FLATMATE, R.string.m1c04_name , R.string.m1c04_description,
            R.string.m1c04_first_option, R.string.m1c04_second_option,
            Difficult.HARD,
            new StatEffect[] {StatEffect.MONEY_POSITIVE, StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SLEEP_NEGATIVE}),
    M1_5(1,Person.STUDENT, R.string.m1c05_name , R.string.m1c05_description,
            R.string.m1c05_first_option, R.string.m1c05_second_option,
            Difficult.HARD,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE}),
    M1_6(1,Person.STUDENT, R.string.m1c06_name , R.string.m1c06_description,
            R.string.m1c06_first_option, R.string.m1c06_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE}),
    M1_7(1,Person.STUDENT, R.string.m1c07_name , R.string.m1c07_description,
            R.string.m1c07_first_option, R.string.m1c07_second_option,
            Difficult.EASY,
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE, StatEffect.ANXIETY_POSITIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE}),
    M1_8(1,Person.TEACHER, R.string.m1c08_name , R.string.m1c08_description,
            R.string.m1c08_first_option, R.string.m1c08_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE},
            new StatEffect[] {StatEffect.SOCIAL_POSITIVE}),
    M1_9(1,Person.STUDENT, R.string.m1c09_name , R.string.m1c09_description,
            R.string.m1c09_first_option, R.string.m1c09_second_option,
            Difficult.EASY,
            new StatEffect[] {StatEffect.MONEY_POSITIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE, StatEffect.ANXIETY_NEGATIVE}),
    M1_10(1,Person.FLATMATE, R.string.m1c10_name , R.string.m1c10_description,
            R.string.m1c10_first_option, R.string.m1c10_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE, StatEffect.SOCIAL_POSITIVE, StatEffect.ANXIETY_POSITIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE}),
    //TODO
    M1_11(1,Person.FLATMATE, R.string.m1c11_name , R.string.m1c11_description,
            R.string.m1c11_first_option, R.string.m1c11_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE, StatEffect.SOCIAL_NEGATIVE, StatEffect.ANXIETY_POSITIVE},
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE}),
    M1_12(1,Person.FLATMATE, R.string.m1c12_name , R.string.m1c12_description,
            R.string.m1c12_first_option, R.string.m1c12_second_option,
            Difficult.HARD,
            new StatEffect[] {StatEffect.MONEY_POSITIVE, StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SLEEP_NEGATIVE}),
    M1_13(1,Person.STUDENT, R.string.m1c13_name , R.string.m1c13_description,
            R.string.m1c13_first_option, R.string.m1c13_second_option,
            Difficult.HARD,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE}),
    M1_14(1,Person.STUDENT, R.string.m1c14_name , R.string.m1c14_description,
            R.string.m1c14_first_option, R.string.m1c14_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE}),
    M1_15(1,Person.TEACHER, R.string.m1c15_name , R.string.m1c15_description,
            R.string.m1c15_first_option, R.string.m1c15_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.ANXIETY_NEGATIVE, StatEffect.SLEEP_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE, StatEffect.SLEEP_POSITIVE}),
    M1_16(1,Person.FLATMATE, R.string.m1c16_name , R.string.m1c16_description,
            R.string.m1c16_first_option, R.string.m1c16_second_option,
            Difficult.EASY,
            new StatEffect[] {StatEffect.MONEY_POSITIVE, StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SLEEP_NEGATIVE}),
    M1_17(1,Person.STUDENT, R.string.m1c17_name , R.string.m1c17_description,
            R.string.m1c17_first_option, R.string.m1c17_second_option,
            Difficult.EASY,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE}),
    M1_18(1,Person.STUDENT, R.string.m1c18_name , R.string.m1c18_description,
            R.string.m1c18_first_option, R.string.m1c18_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE}),
    M1_19(1,Person.STUDENT, R.string.m1c19_name , R.string.m1c19_description,
            R.string.m1c19_first_option, R.string.m1c19_second_option,
            Difficult.MEDIUM,
            new StatEffect[] {StatEffect.MONEY_NEGATIVE},
            new StatEffect[] {StatEffect.ANXIETY_POSITIVE}),
    M1_20(1,Person.STUDENT, R.string.m1c20_name , R.string.m1c20_description,
            R.string.m1c20_first_option, R.string.m1c20_second_option,
            Difficult.HARD,
            new StatEffect[] {StatEffect.SLEEP_POSITIVE},
            new StatEffect[] {StatEffect.SOCIAL_NEGATIVE}),

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
