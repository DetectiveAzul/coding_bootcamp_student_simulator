package com.detectiveazul.codeclanstudentsimulator.model.decks;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.cards.ProjectWeekCard;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck implements Serializable {
    private int module;
    private ArrayList<Card> cards;
    private int size;

    public Deck(int module, int size) {
        this.module = module;
        this.size = size;
        cards = new ArrayList<>();
        populateDeck();
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

    protected ArrayList<CardCollection> getCardCollection() {
        ArrayList<CardCollection> cardCollection = new ArrayList<>();
        for (CardCollection card:CardCollection.values()) {
            cardCollection.add(card);
        }
        Collections.shuffle(cardCollection);
        return cardCollection;
    }

    public void populateDeck() {
        for (CardCollection card: getCardCollection() ) {
            if (card.getModule() == this.module && cards.size() < this.size ) {
              cards.add(createCard(card));
            }
        }
    }

    public void createProjectWeek() {
        for (int i = calculateBeginOfProjectWeek(); i < calculateEndOfProjectWeek() ; i++) {
            replaceWithProjectWeekCards(i, cards.get(i).card());
        }
    }

    private int calculateBeginOfProjectWeek() {
        if (cards.size() <= 5) return 0;
        return cards.size() - 6;
    }

    private int calculateEndOfProjectWeek() {
        return cards.size();
    }

    public void replaceWithProjectWeekCards(int index, CardCollection card) {
        cards.set(index, new ProjectWeekCard(card));
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
