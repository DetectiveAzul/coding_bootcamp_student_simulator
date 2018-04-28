package com.detectiveazul.codeclanstudentsimulator.model.game;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.decks.Deck;
import com.detectiveazul.codeclanstudentsimulator.model.decks.ModuleDeck;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Deck> decks;
    private int[] currentTime;
    private boolean gameFinished;

    public Game(Player player) {
        this.player = player;
        this.decks = new ArrayList<>();
        this.currentTime = new int[] {1,1};
        this.gameFinished = false;
        buildGameDeck();
    }

    private void buildGameDeck() {
        this.decks.add(new ModuleDeck(1));
        //Space for adding a Prize card
        this.decks.add(new ModuleDeck(2));
        //Space for adding a Prize card
        this.decks.add(new ModuleDeck(3));
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
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
        if (decks.size() == 0) {
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

    }

    public void turnEnds() {

    }

    //Player actions
    public void playerTakeFirstOption() {

    }

    public void playerTakeSecondOption() {

    }

    //Affect Player
    public void affectPlayer() {

    }

    //Increase&Decrease Player Score
    public void increasePlayerScore() {

    }

    public void decreasePlayerScore() {
        
    }
}
