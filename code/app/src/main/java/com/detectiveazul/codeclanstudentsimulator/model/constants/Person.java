package com.detectiveazul.codeclanstudentsimulator.model.constants;

import com.detectiveazul.codeclanstudentsimulator.R;

public enum Person {
    STUDENT(R.string.student),
    TEACHER(R.string.teacher),
    FLATMATE(R.string.flatmate);

    private final int personDescription;

    Person(int personDescription) {
        this.personDescription = personDescription;
    }

    public int getPersonDescription() {
        return personDescription;
    }
}
