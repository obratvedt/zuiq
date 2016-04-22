package com.example.oyvin.zuiq.models;

public class Player {

    public static int NUMBER_OF_PLAYERS = 0;

    private int id;
    private String name;
    private int score;

    public Player(String name) {
        this.id = ++NUMBER_OF_PLAYERS;
        this.name = name;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
