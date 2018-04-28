package com.detectiveazul.codeclanstudentsimulator.model;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;

import java.util.HashMap;

public class Player {
    private String name;
    private HashMap<Stat, Integer> stats;
    private int score;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initializeStats();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    private void initializeStats() {
        stats.put(Stat.SLEEP, 50);
        stats.put(Stat.ANXIETY, 50);
        stats.put(Stat.SOCIAL_LIFE, 50);
        stats.put(Stat.MONEY, 50);
    }

    public int getStat(Stat stat) {
        return stats.get(stat);
    }

    public void increaseStat(Stat stat, int amount) {
        int actualValue = getStat(stat);
        stats.put(stat, actualValue + amount);
    }

    public void decreaseStat(Stat stat, int amount) {
        int actualValue = getStat(stat);
        stats.put(stat, actualValue - amount);
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int quantity) {
        score += quantity;
    }

    public void takePrimaryAction(Card card) {
        HashMap<Stat, Boolean> cardEffect = card.getPrimaryEffect();
        int difficult = card.getDifficult();
        applyCardEfect(cardEffect, difficult);
    }

    public void takeSecondaryAction(Card card) {
        HashMap<Stat, Boolean> cardEffect = card.getSecondaryEffect();
        int difficult = card.getDifficult();
        applyCardEfect(cardEffect, difficult);

        if (card.isProjectWeek()) projectWeekAnxiety();
    }

    private void applyCardEfect(HashMap<Stat, Boolean> cardEffect, int difficult) {
        for (Stat stat: cardEffect.keySet()) {
            if (cardEffect.get(stat)) increaseStat(stat, difficult);
            if (!cardEffect.get(stat)) decreaseStat(stat, difficult);
        }
    }

    private void projectWeekAnxiety() {
        increaseStat(Stat.ANXIETY, 10);
    }

}
