package com.example.oyvin.zuiq.controllers;

public class ConfigController extends Controller {

    private static ConfigController instance = null;

    private ConfigController() {

    }

    public static ConfigController getInstance() {
        if (instance == null)
            instance = new ConfigController();
        return instance;
    }

}
