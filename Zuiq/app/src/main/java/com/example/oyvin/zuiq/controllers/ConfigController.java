package com.example.oyvin.zuiq.controllers;

import com.example.oyvin.zuiq.ZiuqGame;

import java.util.Random;

import sheep.game.Game;

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

    //SETTING GAME RULES
    //
    //This section of the config controller will set the different settings for the game
    //
    //---------------------------->>
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
        ZiuqGame.addMaxPoints(add);
    }
    //<<----------------------------

}
