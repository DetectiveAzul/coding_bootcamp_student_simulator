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

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;
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
    public void hasDecks() {
        assertEquals(3, game.getDecks().size());
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
        game.getDecks().clear();
        assertEquals(GameStatus.WIN, game.checkGameCondition());
    }

    @Test
    public void canCheckIfLost() {
        game.getPlayer().increaseStat(Stat.ANXIETY, 100);
        assertEquals(GameStatus.LOSE, game.checkGameCondition());
    }

    @Test
    public void neitherWinOrLose() {
        assertNull(game.checkGameCondition());
    }

    @Test
    public void gameCanHandlePlayerTakingPrimaryAction() {
        game.playerTakeFirstOption(card00);
        Assert.assertEquals( 60,game.getPlayer().getStat(Stat.ANXIETY));
        Assert.assertEquals( 40,game.getPlayer().getStat(Stat.MONEY));
        Assert.assertEquals( 60,game.getPlayer().getStat(Stat.SOCIAL_LIFE));

    }

    @Test
    public void gameCanHandlePlayerTakingSecondaryAction() {
        game.playerTakeSecondOption(card00);
        Assert.assertEquals( 40 ,game.getPlayer().getStat(Stat.ANXIETY));
        Assert.assertEquals( 60,game.getPlayer().getStat(Stat.MONEY));
        Assert.assertEquals( 40,game.getPlayer().getStat(Stat.SOCIAL_LIFE));

    }
}
