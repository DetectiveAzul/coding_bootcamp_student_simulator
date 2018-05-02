package com.detectiveazul.codeclanstudentsimulator.model.cards;

import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Face;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Person;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.constants.StatEffect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class Card implements Serializable {
    private CardCollection card;
    private String faceFileName;
    private boolean prize;
    private boolean projectWeek;
    private HashMap<Stat, Boolean> primaryEffect;
    private HashMap<Stat, Boolean> secondaryEffect;

    public Card(CardCollection card) {
        this.card = card;
        this.prize = false;
        this.projectWeek = false;
        this.primaryEffect = new HashMap<>();
        this.secondaryEffect = new HashMap<>();
        setFaceFileName();
        setEffects();
    }

    //Basic Getters will get the information from the Enum CardCollection

    public CardCollection card() {
        return card;
    }

    public int getName() {
        return card().getName();
    }

    public String getFaceFileName() {
        return faceFileName;
    }

    public void setFaceFileName() {
        Random rand = new Random();
        int maxRandom;
        switch (getPerson()) {
            case STUDENT:
                maxRandom = Face.STUDENT_FACE.getFilenameArray().length;
                this.faceFileName = Face.STUDENT_FACE.getFilenameArray()[rand.nextInt(maxRandom)];
                break;
            case TEACHER:
                maxRandom = Face.TEACHER_FACE.getFilenameArray().length;
                this.faceFileName = Face.TEACHER_FACE.getFilenameArray()[rand.nextInt(maxRandom)];
                break;
            default:
                maxRandom = Face.FLATMATE_FACE.getFilenameArray().length;
                this.faceFileName = Face.FLATMATE_FACE.getFilenameArray()[rand.nextInt(maxRandom)];
        }
    }

    public int getModule() {
        return card().getModule();
    }

    public int getDescription() {
        return card().getDescription();
    }

    public int getPrimaryOption() {
        return card().getPrimaryOption();
    }

    public int getSecondaryOption() {
        return card().getSecondaryOption();
    }

    public int getDifficult() {
        return card().getDifficult().getLevel();
    }

    public boolean isPrize() {
        return prize;
    }

    public boolean isProjectWeek() {
        return projectWeek;
    }

    public Person getPerson() {
        return card.getPerson();
    }

    public int getPersonName() {
        return card.getPerson().getPersonDescription();
    }

    //Setters

    public void setProjectWeek(boolean projectWeek) {
        this.projectWeek = projectWeek;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    //Getting the primaryEffects hashmaps

    public HashMap<Stat, Boolean> getPrimaryEffect() {
        return primaryEffect;
    }

    public HashMap<Stat, Boolean> getSecondaryEffect() {
        return secondaryEffect;
    }

    //Run once during the creation of the card, it will take the array of StatEffect[] from the
    //CardCollection Enum and create a hashmap with a Stat and a boolean to know if the effect
    //is positive or not

    private void setEffects() {
        setPrimaryEffect();
        setSecondaryEffect();
    }

    private void setPrimaryEffect() {
        for (StatEffect combination: card.getPrimaryEffect()) {
            this.primaryEffect.put(combination.getStat(), combination.isPositiveEffect());
        }
    }

    private void setSecondaryEffect() {
        for (StatEffect combination: card.getSecondaryEffect()) {
            this.secondaryEffect.put(combination.getStat(), combination.isPositiveEffect());
        }
    }





}
