package com.t3h.bt_buoi5;

import android.support.annotation.DrawableRes;

public class Face {

    private String name;
    private String msv;
    private String classroom;
    private Float score;

    public Face(String name, String msv, String classroom, Float score) {
        this.name = name;
        this.msv = msv;
        this.classroom = classroom;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getMsv() {
        return msv;
    }

    public String getClassroom() {
        return classroom;
    }

    public Float getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
