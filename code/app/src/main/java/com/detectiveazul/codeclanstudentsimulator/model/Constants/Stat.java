package com.detectiveazul.codeclanstudentsimulator.model.constants;

public enum Stat {
    MONEY("Money",
            "You quit the course after saving so much money that you feel you could live of it the rest of your life ",
            "You quit the course after discovering your bank account is below zero. You need to find a job real quick"),
    SOCIAL_LIFE("Social life",
            "Too much social life distract you from your studies, making you fail the final exams. Next time maybe.",
            "You have lost all your friends because you only focused on your studies. You're so sad that you quit the course"),
    ANXIETY("Anxiety",
            "You awaken after two years of being comatose due to an Anxiety attack. Chill out next time",
            "You have achieved such a relaxed way of life that you have ascended to the Nirvana. Shame there aren't computers there"),
    SLEEP("Sleep",
            "What? Uh? What year it is? You have spend your whole 16 weeks sleeping!",
            "You fell asleep on your finals. You should take a break from time to time");

    private final String prettyName;
    private final String deadOver;
    private final String deadBelow;

    Stat(String prettyName, String deadOver, String deadBelow) {
        this.prettyName = prettyName;
        this.deadOver = deadOver;
        this.deadBelow = deadBelow;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public String getDeadOver() {
        return deadOver;
    }

    public String getDeadBelow() {
        return deadBelow;
    }
}
