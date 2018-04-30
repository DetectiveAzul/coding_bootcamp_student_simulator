package com.detectiveazul.codeclanstudentsimulator.model.decks;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.cards.ProjectWeekCard;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable {
    private int module;
    private ArrayList<Card> cards;
    private int size;

    public Deck(int module, int size) {
        this.module = module;
        this.size = size;
        cards = new ArrayList<>();
    }

    //Basic getter/setter

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


    //Return the whole set of cards on the CollectionCard enum, but shuffled
    private ArrayList<CardCollection> getCardCollection() {
        ArrayList<CardCollection> cardCollection = new ArrayList<>();
        for (CardCollection card:CardCollection.values()) {
            cardCollection.add(card);
        }
        Collections.shuffle(cardCollection);
        return cardCollection;
    }

    //Populate the deck with cards of the Deck's Module, and stop the process when the size is met
    protected void populateDeck() {
        for (CardCollection card: getCardCollection() ) {
            if (card.getModule() == this.module && cards.size() < this.size ) {
              cards.add(createCard(card));
            }
        }
    }

    //Replace last 5 cards of the deck with a copy of them being ProjectWeekCards
    public void createProjectWeek() {
        for (int i = calculateBeginOfProjectWeek(); i < calculateEndOfProjectWeek() ; i++) {
            replaceWithProjectWeekCards(i, cards.get(i).card());
        }
    }

    //Calculate begin and end of Project Week boundaries
    private int calculateBeginOfProjectWeek() {
        if (cards.size() <= 5) return 0;
        return cards.size() - 6;
    }

    private int calculateEndOfProjectWeek() {
        return cards.size();
    }

    //Replace the card with a copy of a ProjectWeekCard
    public void replaceWithProjectWeekCards(int index, CardCollection card) {
        cards.set(index, new ProjectWeekCard(card));
    }

    //Create a card
    private Card createCard(CardCollection card) {
        return new Card(card);
    }

    //Shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    //Return a card and remove it from the deck
    public Card drawCard() {
        Card card = null;
        if (getNumberOfCards() > 0)  {
            card = cards.get(0);
            cards.remove(0);
        }

        return card;
    }

}
