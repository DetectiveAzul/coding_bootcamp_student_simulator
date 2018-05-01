package com.detectiveazul.codeclanstudentsimulator.model.game;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.PlayerStatus;
import com.detectiveazul.codeclanstudentsimulator.model.decks.Deck;
import com.detectiveazul.codeclanstudentsimulator.model.decks.ModuleDeck;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private Player player;
    private Deck deck;
    private Card currentCard;
    private int[] currentTime;
    private boolean gameFinished;
    private ArrayList<String> studentJournal;

    public Game(Player player) {
        this.player = player;
        this.deck = new Deck(0, 82);
        this.currentTime = new int[] {1,1};
        this.gameFinished = false;
        this.studentJournal = new ArrayList<String>();
        buildGameDeck();
    }
    //Getter for the student journal
    public ArrayList<String> getStudentJournal() {
        return studentJournal;
    }

    //Adding an entry on the student journal
    public void addEntryToStudentJournal(String string) {
        studentJournal.add(string);
    }


    //It builds the gameDeck by creating three moduleDecks

    private void buildGameDeck() {
        for (int i = 1; i <= 3 ; i++) {
         this.deck.getCards().addAll(buildDeck(i).getCards());
        }
    }

    //Build a deck and shuffle it before putting it into the GameDeck
    private ModuleDeck buildDeck(int module) {
        ModuleDeck deck = new ModuleDeck(module);
        return deck;
    }

    //Getters/setters
    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public int[] getCurrentTime() {
        return currentTime;
    }

    public int getDay() {
        return currentTime[0];
    }

    public int getWeek() {
        return currentTime[1];
    }

    public void timePass() {
        if (currentTime[0] == 5) {
            increaseWeek();
        } else {
            increaseDay();
        }

    }

    private void increaseDay() {
        this.currentTime[0] ++;
    }

    private void increaseWeek() {
        this.currentTime[0] = 1;
        this.currentTime[1] ++;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void finishGame() {
        gameFinished = true;
    }

    //This is the test to check if game has been won or has been lost
    public GameStatus checkGameCondition() {
        if (gameLost()) return GameStatus.LOSE;
        if (gameWon()) return GameStatus.WIN;
        return GameStatus.IN_PROGRESS;
    }

    private boolean gameWon() {
        if (deck.getNumberOfCards() == 0) {
            finishGame();
            return true;
        }
        return false;
    }

    private boolean gameLost() {
        if (player.checkStatus() == PlayerStatus.DEAD) {
            finishGame();
            return true;
        }

        return false;
    }

    //Methods to handle turns
    public void turnBegins() {
        drawCard();
    }

    public void turnEnds() {
        this.currentCard = null;
        timePass();
    }

    //Methods to handle deck
    public Card drawCard() {
       if (!checkDeckEmpty()) this.currentCard = deck.drawCard();
       return currentCard;
    }

    public boolean checkDeckEmpty() {
        return deck.getCards().isEmpty();
    }


    //Player actions
    public void playerTakeFirstOption(Card card) {
        player.takePrimaryAction(card);
    }

    public void playerTakeSecondOption(Card card) {
        player.takeSecondaryAction(card);
    }


    //Increase&Decrease Player Score
    public void increasePlayerScore(int quantity) {
        player.increaseScore(quantity);
    }

}
