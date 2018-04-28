package com.detectiveazul.codeclanstudentsimulator.model.decks;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck {
    private int module;
    private ArrayList<Card> cards;
    private int size;

    public Deck(int module, int size) {
        this.module = module;
        this.size = size;
        cards = new ArrayList<>();
    }

    public int getModule() {
        return module;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getSize() {
        return size;
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void populateDeck() {
        for (CardCollection card: CardCollection.values() ) {
            if (card.getModule() == this.module && cards.size() < this.size ) {
              cards.add(createCard(card));
            }
        }
    }

    private Card createCard(CardCollection card) {
        return new Card(card);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        Card card = null;
        if (getNumberOfCards() > 0)  {
            card = cards.get(0);
            cards.remove(0);
        }

        return card;
    }

}
