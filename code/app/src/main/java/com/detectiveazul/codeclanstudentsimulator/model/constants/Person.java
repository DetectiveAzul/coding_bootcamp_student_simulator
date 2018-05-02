package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum Person {
    STUDENT("One of your classmates"),
    TEACHER("Today's instructor"),
    FLATMATE("Your fellow flatmate");

    private final String personDescription;

    Person(String personDescription) {
        this.personDescription = personDescription;
    }

    public String getPersonDescription() {
        return personDescription;
    }
}
