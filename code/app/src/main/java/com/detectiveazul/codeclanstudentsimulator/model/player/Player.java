package com.detectiveazul.codeclanstudentsimulator.model.player;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.PlayerStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {
    private String name;
    private HashMap<Stat, Integer> stats;
    private int score;
    private int initialValue;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.initialValue = 50;
        initializeStats();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    //Populate the User Hashmap of Stats
    private void initializeStats() {
        for (Stat stat:Stat.values()) {
            stats.put(stat, initialValue);
        }
    }

    //Get the value of a Stat
    public int getStat(Stat stat) {
        return stats.get(stat);
    }

    //Increase and decrease Stats
    public void increaseStat(Stat stat, int amount) {
        int actualValue = getStat(stat);
        stats.put(stat, actualValue + amount);
    }

    public void decreaseStat(Stat stat, int amount) {
        int actualValue = getStat(stat);
        stats.put(stat, actualValue - amount);
    }

    //Check Player Status
    public PlayerStatus checkStatus() {
        for (Stat stat:
             stats.keySet()) {
            if (checkMaxStat(stat)) return PlayerStatus.DEAD;
            if (checkMinStat(stat)) return PlayerStatus.DEAD;
        }
        return PlayerStatus.ALIVE;
    }




    private boolean checkMaxStat(Stat stat) {
        if (stats.get(stat) >= 100) return true;
        return false;
    }

    private boolean checkMinStat(Stat stat) {
        if (stats.get(stat) <= 0) return true;
        return false;

    }

    public int endSceneString() {
        int resString = 0;
        for (Stat stat: stats.keySet()) {
            if (checkMaxStat(stat))
                resString = stat.getDeadOver();
            if (checkMinStat(stat))
                resString = stat.getDeadBelow();
        }
        return resString;
    }

    //Get and set score
    public int getScore() {
        return score;
    }

    public void increaseScore(int quantity) {
        score += quantity;
    }

    //Taking actions from cards
    public void takePrimaryAction(Card card) {
        HashMap<Stat, Boolean> cardEffect = card.getPrimaryEffect();
        int difficult = card.getDifficult();
        applyCardEffect(cardEffect, difficult);

        if (card.isProjectWeek()) projectWeekAnxiety();

    }

    public void takeSecondaryAction(Card card) {
        HashMap<Stat, Boolean> cardEffect = card.getSecondaryEffect();
        int difficult = card.getDifficult();
        applyCardEffect(cardEffect, difficult);

        if (card.isProjectWeek()) projectWeekAnxiety();
    }

    //Apply cardEffect
    private void applyCardEffect(HashMap<Stat, Boolean> cardEffect, int difficult) {
        for (Stat stat: cardEffect.keySet()) {
            if (cardEffect.get(stat)) increaseStat(stat, difficult);
            if (!cardEffect.get(stat)) decreaseStat(stat, difficult);
        }
    }

    //Increase Anxiety during Project Week Cards
    private void projectWeekAnxiety() {
        increaseStat(Stat.ANXIETY, 10);
    }

}
