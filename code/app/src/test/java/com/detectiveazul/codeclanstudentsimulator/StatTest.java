package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StatTest {

    @Test
    public void hasPrettyName() {
        assertEquals(R.string.money, Stat.MONEY.getPrettyName());
        assertEquals(R.string.anxiety, Stat.ANXIETY.getPrettyName());
    }
}
