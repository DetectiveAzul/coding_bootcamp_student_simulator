package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.cards.NeutralCard;
import com.detectiveazul.codeclanstudentsimulator.model.cards.PrizeCard;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Person;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.cards.ProjectWeekCard;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class CardTest {
    private Card card00;
    private ProjectWeekCard card01;
    private PrizeCard card02;
    private NeutralCard card03;

    @Before
    public void setup() {
        card00 = new Card(CardCollection.TEST );
        card01 = new ProjectWeekCard(CardCollection.TEST);
        card02 = new PrizeCard(CardCollection.TEST);
        card03 = new NeutralCard(CardCollection.TEST);

    }

    @Test
    public void hasName() {
        assertEquals("A beer", card00.getName());
    }
    @Test
    public void hasModule() {
        assertEquals(-1, card00.getModule());
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

    @Test
    public void prizeCardCanResetStats() {
        assertFalse(card02.getPrimaryEffect().get(Stat.ANXIETY));
        assertTrue(card02.getPrimaryEffect().get(Stat.MONEY ));
        assertFalse(card02.getSecondaryEffect().get(Stat.SLEEP));
        assertTrue(card02.getSecondaryEffect().get(Stat.SOCIAL_LIFE));
    }

    @Test
    public void neutralCardNoDifficult() {
        assertEquals(0, card03.getDifficult());
    }

    @Test
    public void cardHasPerson() {
        assertEquals(Person.STUDENT, card00.getPerson());
    }

    @Test
    public void personHasName() {
        assertEquals("One of your classmates", card00.getPersonName());
    }

    @Test
    public void hasFace() {
        assertNotNull("", card00.getFaceFileName());
    }
}
