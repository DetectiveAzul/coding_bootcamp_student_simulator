package com.detectiveazul.codeclanstudentsimulator.model.game;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.decks.Deck;
import com.detectiveazul.codeclanstudentsimulator.model.decks.ModuleDeck;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Card> deck;
    private Card currentCard;
    private int[] currentTime;
    private boolean gameFinished;

    public Game(Player player) {
        this.player = player;
        this.deck = new ArrayList<>();
        this.currentTime = new int[] {1,1};
        this.gameFinished = false;
        buildGameDeck();
    }

    private void buildGameDeck() {
        for (int i = 1; i <= 3 ; i++) {
         this.deck.addAll(buildDeck(i).getCards());
        }
    }

    private ModuleDeck buildDeck(int module) {
        ModuleDeck deck = new ModuleDeck(module);
        deck.shuffleDeck();
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public int[] getCurrentTime() {
        return currentTime;
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
        return null;
    }

    private boolean gameWon() {
        if (deck.size() == 0) {
            finishGame();
            return true;
        }
        return false;
    }

    private boolean gameLost() {
        if (player.checkStatus()) {
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
    }

    //Methods to handle deck
    public Card drawCard() {
       if (!checkDeckEmpty()) this.currentCard = deck.remove(0);
       return currentCard;
    }

    public boolean checkDeckEmpty() {
        return deck.isEmpty();
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
