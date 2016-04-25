package com.example.oyvin.zuiq.controllers;

public class ConfigController {

    private static ConfigController instance = null;
    private int numberOfQuestions;

    private ConfigController() {

    }

    public static ConfigController getInstance() {
        if (instance == null)
            instance = new ConfigController();
        return instance;
    }

    public void addNumberOfPlayers(int add) {
        getGame().setMaxPlayers(getGame().getMaxPlayers() + add);
    }

    public void addNumberOfSeconds(int add) {
        getGame().setTimeLimit(getGame().getTimeLimit() + add);
    }

    public void addNumberOfQuestions(int add) {
        numberOfQuestions += add;
    }

    public void addScoreLimit(int add) {
        getGame().setMaxPoints(add);
    }

}
