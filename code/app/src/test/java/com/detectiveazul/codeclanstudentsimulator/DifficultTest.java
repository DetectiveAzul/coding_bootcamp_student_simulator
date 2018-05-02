package com.detectiveazul.codeclanstudentsimulator;

import com.detectiveazul.codeclanstudentsimulator.model.constants.Difficult;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DifficultTest {

    @Test
    public void hasPrettyName() {
        assertEquals(R.string.easy, Difficult.EASY.getPrettyName());
    }

    @Test
    public void hasLevel() {
        assertEquals(15, Difficult.MEDIUM.getLevel());
    }
}
