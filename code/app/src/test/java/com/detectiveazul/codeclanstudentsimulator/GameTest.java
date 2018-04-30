package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.constants.GameStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {
    private Game game;
    private Card card00;

    @Before
    public void setup() {
        game = new Game(new Player("Cian"));
        card00 = new Card(CardCollection.TEST );

    }

    @Test
    public void hasPlayer() {
        assertEquals("Cian", game.getPlayer().getName());
    }

    @Test
    public void hasDeck() {
        assertEquals(0, game.getDeck().getCards().size());
    }

    @Test
    public void hasTime() {
        assertEquals(1, game.getCurrentTime()[0]);
        assertEquals(1, game.getCurrentTime()[1]);
    }

    @Test
    public void canPassTime() {
        game.timePass();
        game.timePass();
        game.timePass();
        game.timePass();
        game.timePass();
        assertEquals(1, game.getCurrentTime()[0]);
        assertEquals(2, game.getCurrentTime()[1]);
    }

    @Test
    public void canGetIfGameIsFinished() {
        assertFalse(game.isGameFinished());
    }

    @Test
    public void canFinishGame() {
        game.finishGame();
        assertTrue(game.isGameFinished());
    }

    @Test
    public void canCheckIfWon() {
        game.getDeck().getCards().clear();
        assertEquals(GameStatus.WIN, game.checkGameCondition());
    }

    @Test
    public void canCheckIfLost() {
        game.getPlayer().increaseStat(Stat.ANXIETY, 100);
        assertEquals(GameStatus.LOSE, game.checkGameCondition());
    }

    @Test
    public void neitherWinOrLose() {
        game.getDeck().getCards().add(new Card(CardCollection.TEST));
        assertNull(game.checkGameCondition());
    }

    @Test
    public void gameCanHandlePlayerTakingPrimaryAction() {
        game.playerTakeFirstOption(card00);
        assertEquals( 60,game.getPlayer().getStat(Stat.ANXIETY));
        assertEquals( 40,game.getPlayer().getStat(Stat.MONEY));
        assertEquals( 60,game.getPlayer().getStat(Stat.SOCIAL_LIFE));

    }

    @Test
    public void gameCanHandlePlayerTakingSecondaryAction() {
        game.playerTakeSecondOption(card00);
        assertEquals( 40 ,game.getPlayer().getStat(Stat.ANXIETY));
        assertEquals( 60,game.getPlayer().getStat(Stat.MONEY));
        assertEquals( 40,game.getPlayer().getStat(Stat.SOCIAL_LIFE));

    }

    //These were tested with testCards from modules -1, -2
//    @Test
//    public void canCheckFirstDeckIsEmpty() {
//        assertFalse(game.checkFirstDeckEmpty());
//    }
//
//    @Test
//    public void canCheckFirstDeckIsEmptyTrue() {
//        game.getDecks().get(0).drawCard();
//        game.getDecks().get(0).drawCard();
//        assertTrue(game.checkFirstDeckEmpty());
//    }

    @Test
    public void canIncreaseScore() {
        game.increasePlayerScore(100);
        assertEquals(100, game.getPlayer().getScore());
    }

    @Test
    public void canDrawCard() {
        Card card = game.drawCard();
        assertNull(card);
    }

    @Test
    public void canBeginTurn() {
        game.getDeck().getCards().add(new Card(CardCollection.TEST));
        game.turnBegins();
        assertEquals(CardCollection.TEST, game.getCurrentCard().card());
    }
    @Test
    public void canEndTurn() {
        game.getDeck().getCards().add(new Card(CardCollection.TEST));
        game.turnBegins();
        game.turnEnds();
        assertNull(game.getCurrentCard());
    }
}
