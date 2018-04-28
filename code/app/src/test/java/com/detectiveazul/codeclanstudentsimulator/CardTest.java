package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.Card;
import com.detectiveazul.codeclanstudentsimulator.model.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CardTest {
    private Card card00;

    @Before
    public void setup() {
        HashMap<Stat, Boolean> card00priEffect = new HashMap<>();
        card00priEffect.put(Stat.SOCIAL_LIFE, true);
        card00priEffect.put(Stat.MONEY, false);
        card00priEffect.put(Stat.ANXIETY, false);

        HashMap<Stat, Boolean> card00secEffect = new HashMap<>();
        card00secEffect.put(Stat.SOCIAL_LIFE, false);
        card00secEffect.put(Stat.MONEY, true);
        card00secEffect.put(Stat.ANXIETY, true);

        card00 = new Card(CardCollection.TEST, card00priEffect, card00secEffect );

    }

    @Test
    public void hasName() {
        assertEquals("A beer", card00.getName());
    }
    @Test
    public void hasModule() {
        assertEquals(1, card00.getModule());
    }
    @Test
    public void hasDescription() {
        assertEquals("A friend want a beer", card00.getDescription());
    }
    @Test
    public void hasPrimaryOption() {
        assertEquals("Yes, please", card00.getPrimaryOption());
    }

    @Test
    public void hasSecondaryOption() {
        assertEquals("I should study...", card00.getSecondaryOption());
    }

    @Test
    public void hasDifficult() {
        assertEquals(Difficult.EASY, card00.getDifficult());
    }
    @Test
    public void isPrizeCard() {
        assertFalse(card00.isPrize());
    }
    @Test
    public void canSetPrize() {
        card00.setPrize(true);
        assertTrue(card00.isPrize());
    }

    @Test
    public void hasPrimaryEffect() {
        assertFalse(card00.getPrimaryEffect().get(Stat.ANXIETY));
    }

    @Test
    public void hasSecondaryEffect() {
        assertTrue(card00.getSecondaryEffect().get(Stat.ANXIETY));
    }
}
