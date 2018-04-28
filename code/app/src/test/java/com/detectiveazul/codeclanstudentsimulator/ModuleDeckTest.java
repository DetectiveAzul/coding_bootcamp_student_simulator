package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.decks.ModuleDeck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ModuleDeckTest {
    private ModuleDeck deck00;
    private ModuleDeck deck01;

    @Before
    public void setup() {
        deck00 = new ModuleDeck(-1);
        deck01 = new ModuleDeck(-2);
    }

    @Test
    public void hasModule() {
    assertEquals(-1, deck00.getModule());
    }

    @Test
    public void hasCards() {
        assertEquals(2, deck00.getNumberOfCards());
        assertEquals(1, deck01.getCards().size());
    }

    @Test
    public void hasSize() {
        assertEquals(20, deck00.getSize());
        assertEquals(20, deck01.getSize());
    }

    @Test
    public void drawCardEnoughCards() {
        Card card = deck00.drawCard();
        assertEquals(1, deck00.getNumberOfCards());
    }

    @Test
    public void drawCardNotEnoughCards() {
        deck01.drawCard();
        Card card = deck01.drawCard();
        assertEquals(0, deck01.getNumberOfCards());
        assertNull(card);
    }



    @Test
    public void canReplaceWithProjectWeekCard() {
        assertFalse(deck00.getCards().get(0).isProjectWeek());
        deck00.replaceWithProjectWeekCards(0, CardCollection.TEST);
        assertTrue(deck00.getCards().get(0).isProjectWeek());
    }

    @Test
    public void canCreateProjectWeek() {
        deck00.createProjectWeek();
        assertTrue(deck00.getCards().get(0).isProjectWeek());
        assertTrue(deck00.getCards().get(1).isProjectWeek());
    }


//    @Test
//    public void canShuffleDeck() {
//        deck00.shuffleDeck();
//        assertNotEquals(CardCollection.TEST, deck00.drawCard().card());
//    }
}
