package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.Player;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {
    private Player player;

    @Before
    public void setup() {
        player = new Player("Cian");
    }

    @Test
    public void hasName() {
        assertEquals("Cian", player.getName());
    }

    @Test
    public void hasScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void canIncreaseScore() {
        player.increaseScore(100);
        assertEquals(100, player.getScore());

    }

    @Test
    public void hasStat() {
        assertEquals(50, player.getStat(Stat.ANXIETY));
    }

    @Test
    public void canIncreaseStat() {
        player.increaseStat(Stat.ANXIETY, 20);
        assertEquals(70, player.getStat(Stat.ANXIETY));

    }

    @Test
    public void canDecreaseStat() {
        player.decreaseStat(Stat.ANXIETY, 20);
        assertEquals(30, player.getStat(Stat.ANXIETY));

    }
}
