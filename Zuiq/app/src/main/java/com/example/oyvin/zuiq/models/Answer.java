package com.example.oyvin.zuiq.models;

public class Answer {

    public static int NUMBER_OF_ANSWERS = 0;

    private int id;
    private String text;

    public Answer(String text) {
        this.text = text;
        this.id = ++NUMBER_OF_ANSWERS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
