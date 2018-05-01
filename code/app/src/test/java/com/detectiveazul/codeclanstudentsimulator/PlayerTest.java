package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.cards.Card;
import com.detectiveazul.codeclanstudentsimulator.model.constants.CardCollection;
import com.detectiveazul.codeclanstudentsimulator.model.cards.NeutralCard;
import com.detectiveazul.codeclanstudentsimulator.model.cards.PrizeCard;
import com.detectiveazul.codeclanstudentsimulator.model.constants.PlayerStatus;
import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.player.Player;
import com.detectiveazul.codeclanstudentsimulator.model.cards.ProjectWeekCard;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private Player player;
    private Card card00;
    private ProjectWeekCard card01;
    private PrizeCard card02;
    private NeutralCard card03;


    @Before
    public void setup() {
        player = new Player("Cian");
        card00 = new Card(CardCollection.TEST);
        card01 = new ProjectWeekCard(CardCollection.TEST);
        card02 = new PrizeCard(CardCollection.TEST);
        card03 = new NeutralCard(CardCollection.TEST);

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
        player.takePrimaryAction(card00);
        assertEquals( 60,player.getStat(Stat.ANXIETY));
        assertEquals( 40,player.getStat(Stat.MONEY));
        assertEquals( 60,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakeSecondaryAction() {
        player.takeSecondaryAction(card00);
        assertEquals( 40 ,player.getStat(Stat.ANXIETY));
        assertEquals( 60,player.getStat(Stat.MONEY));
        assertEquals( 40,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakePrimaryActionProjectWeek() {
        player.takePrimaryAction(card01);
        assertEquals( 70,player.getStat(Stat.ANXIETY));
        assertEquals( 40,player.getStat(Stat.MONEY));
        assertEquals( 60,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakeSecondaryActionProjectWeek() {
        player.takeSecondaryAction(card01);
        assertEquals( 50 ,player.getStat(Stat.ANXIETY));
        assertEquals( 60,player.getStat(Stat.MONEY));
        assertEquals( 40,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakeNeutralCard() {
        player.takeSecondaryAction(card03);
        assertEquals( 50 ,player.getStat(Stat.ANXIETY));
        assertEquals( 50,player.getStat(Stat.MONEY));
        assertEquals( 50,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void canTakePrizeCard() {
        player.takeSecondaryAction(card03);
        assertEquals( 50 ,player.getStat(Stat.ANXIETY));
        assertEquals( 50,player.getStat(Stat.MONEY));
        assertEquals( 50,player.getStat(Stat.SOCIAL_LIFE));
    }

    @Test
    public void playerCanReturnIfLosesOver100() {
        player.increaseStat(Stat.ANXIETY, 51);
        assertEquals(PlayerStatus.DEAD, player.checkStatus());
    }

    @Test
    public void playerCanReturnIfLosesBelow0() {
        player.decreaseStat(Stat.ANXIETY, 51);
        assertEquals(PlayerStatus.DEAD, player.checkStatus());
    }

    @Test
    public void playerCanReturnIfNotLoses() {
        player.decreaseStat(Stat.ANXIETY, 10);
        assertEquals(PlayerStatus.ALIVE, player.checkStatus());
    }

    @Test
    public void canGetEndString() {
        player.decreaseStat(Stat.ANXIETY, 100);
        assertEquals(
                "You have achieved such a relaxed way of life that you have ascended to the Nirvana. Shame there aren't computers there",
                player.endSceneString());
    }
}
