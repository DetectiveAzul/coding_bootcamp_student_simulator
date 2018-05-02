package com.detectiveazul.codeclanstudentsimulator.model.constants;

import java.lang.reflect.Array;

public enum Face {
    TEACHER_FACE(new String[] {"teacher_1", "teacher_2", "teacher_3"}),
    STUDENT_FACE(new String[] {"student_1", "student_2", "student_3", "student_4", "student_5", "student_6"}),
    FLATMATE_FACE(new String[] {"flatmate_1", "flatmate_2"}),;

    private final String[] filenameArray;

    Face(String[] filenameArray) {
        this.filenameArray = filenameArray;
    }

    public String[] getFilenameArray() {
        return filenameArray;
    }
}
