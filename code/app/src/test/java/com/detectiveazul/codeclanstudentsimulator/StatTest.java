package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.constants.Stat;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StatTest {

    @Test
    public void hasPrettyName() {
        assertEquals("Money", Stat.MONEY.getPrettyName());
        assertEquals("Anxiety", Stat.ANXIETY.getPrettyName());
    }
}
