package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.Constants.Stat;
import com.detectiveazul.codeclanstudentsimulator.model.Constants.StatEffect;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StatEffectTest {
    @Test
    public void hasStat() {
        assertEquals(Stat.SLEEP, StatEffect.SLEEP_POSITIVE.getStat());
    }

    @Test
    public void hasPositiveEffect() {
        assertFalse(StatEffect.SLEEP_NEGATIVE.isPositiveEffect());
    }
}
