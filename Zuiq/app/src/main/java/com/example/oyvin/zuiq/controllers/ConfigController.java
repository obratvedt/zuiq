package com.example.oyvin.zuiq.controllers;

public class ConfigController{

    private static ConfigController instance = null;
    private int numberOfQuestions;

    private ConfigController() {

    }

    public static ConfigController getInstance() {
        if (instance == null)
            instance = new ConfigController();
        return instance;
    }

}
