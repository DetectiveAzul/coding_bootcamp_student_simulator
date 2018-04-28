package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.Card;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.Player;
import com.detectiveazul.codeclanstudentsimulator.model.ProjectWeekCard;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    private Card card;
    private ProjectWeekCard projectWeek;

    @Before
    public void setup() {
        player = new Player("Cian");
        card = new Card(CardCollection.TEST);
        projectWeek = new ProjectWeekCard(CardCollection.TEST);
    }

    @Test
    public void hasName() {
        assertEquals("Cian", player.getName());
    }

    @Test
    public void hasScore() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void canIncreaseScore() {
        player.increaseScore(100);
        assertEquals(100, player.getScore());

    }

    @Test
    public void hasStat() {
        assertEquals(50, player.getStat(Stat.ANXIETY));
    }

    @Test
    public void canIncreaseStat() {
        player.increaseStat(Stat.ANXIETY, 20);
        assertEquals(70, player.getStat(Stat.ANXIETY));

    }

    @Test
    public void canDecreaseStat() {
        player.decreaseStat(Stat.ANXIETY, 20);
        assertEquals(30, player.getStat(Stat.ANXIETY));
    }

    @Test
    public void canTakePrimaryAction() {
        player.takePrimaryAction(card);
        assertEquals( 60,player.getStat(Stat.ANXIETY));
        assertEquals( 40,player.getStat(Stat.MONEY));
        assertEquals( 60,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakeSecondaryAction() {
        player.takeSecondaryAction(card);
        assertEquals( 40 ,player.getStat(Stat.ANXIETY));
        assertEquals( 60,player.getStat(Stat.MONEY));
        assertEquals( 40,player.getStat(Stat.SOCIAL_LIFE));
    }

    public void canTakePrimaryActionProjectWeek() {
        player.takePrimaryAction(projectWeek);
        assertEquals( 70,player.getStat(Stat.ANXIETY));
        assertEquals( 40,player.getStat(Stat.MONEY));
        assertEquals( 60,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakeSecondaryActionProjectWeek() {
        player.takeSecondaryAction(projectWeek);
        assertEquals( 50 ,player.getStat(Stat.ANXIETY));
        assertEquals( 60,player.getStat(Stat.MONEY));
        assertEquals( 40,player.getStat(Stat.SOCIAL_LIFE));
    }
}
