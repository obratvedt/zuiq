package com.example.oyvin.zuiq.controllers;

import com.example.oyvin.zuiq.ZiuqGame;

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
        ZiuqGame.setMaxPlayers(ZiuqGame.getMaxPlayers() + add);
    }

    public void addNumberOfSeconds(int add) {
        ZiuqGame.setTimeLimit(ZiuqGame.getTimeLimit() + add);
    }

    public void addNumberOfQuestions(int add) {
        ZiuqGame.setMaxQuestions(ZiuqGame.getMaxQuestions() + add);
    }

    public void addScoreLimit(int add) {
        ZiuqGame.setMaxPoints(add);
    }

}
