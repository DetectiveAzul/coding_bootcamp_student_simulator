package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.Card;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Difficult;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.ProjectWeekCard;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CardTest {
    private Card card00;
    private ProjectWeekCard card01;

    @Before
    public void setup() {
        card00 = new Card(CardCollection.TEST );
        card01 = new ProjectWeekCard(CardCollection.TEST);

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
        assertEquals(10, card00.getDifficult());
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
        assertTrue(card00.getPrimaryEffect().get(Stat.ANXIETY));
    }

    @Test
    public void hasSecondaryEffect() {
        assertFalse(card00.getSecondaryEffect().get(Stat.ANXIETY));
    }

    @Test
    public void isNotProjectWeek() {
        assertFalse(card00.isProjectWeek());
    }

    @Test
    public void isProjectWeek() {
        assertTrue(card01.isProjectWeek());
    }
}
