package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.decks.ModuleDeck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ModuleDeckTest {
    private ModuleDeck deck00;
    private ModuleDeck deck01;
    private ModuleDeck deck02;

    @Before
    public void setup() {
        deck00 = new ModuleDeck(1);
        deck01 = new ModuleDeck(2);
    }

    @Test
    public void hasModule() {
    assertEquals(1, deck00.getModule());
    }

    @Test
    public void hasCards() {
        assertEquals(1, deck00.getNumberOfCards());
        assertEquals(0, deck01.getCards().size());
    }

    @Test
    public void hasSize() {
        assertEquals(20, deck00.getSize());
        assertEquals(20, deck01.getSize());
    }

    @Test
    public void drawCardEnoughCards() {
        Card card = deck00.drawCard();
        assertEquals(0, deck00.getNumberOfCards());
        assertEquals("A beer", card.getName());
    }

    @Test
    public void drawCardNotEnoughCards() {
        Card card = deck01.drawCard();
        assertEquals(0, deck01.getNumberOfCards());
        assertNull(card);
    }
}
