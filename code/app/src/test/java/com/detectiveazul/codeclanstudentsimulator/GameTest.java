package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.game.Game;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {
    private Game game;

    @Before
    public void setup() {
        game = new Game(new Player("Cian"));
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
}
