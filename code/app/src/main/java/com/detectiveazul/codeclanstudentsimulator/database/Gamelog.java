package com.detectiveazul.codeclanstudentsimulator.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Gamelog {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "student_name")
    private String studentName;
    private String week;
    private String day;
    private String score;
    private String result;

    public Gamelog(int id, String studentName, String week, String day, String score, String result) {
        this.id = id;
        this.studentName = studentName;
        this.week = week;
        this.day = day;
        this.score = score;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
