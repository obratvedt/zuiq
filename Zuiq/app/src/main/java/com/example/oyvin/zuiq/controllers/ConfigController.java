package com.example.oyvin.zuiq.controllers;

import com.example.oyvin.zuiq.Game;

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
        Game.setMaxPlayers(Game.getMaxPlayers() + add);
    }

    public void addNumberOfSeconds(int add) {
        Game.setTimeLimit(Game.getTimeLimit() + add);
    }

    public void addNumberOfQuestions(int add) {
        numberOfQuestions += add;
    }

    public void addScoreLimit(int add) {
        Game.setMaxPoints(add);
    }

}
