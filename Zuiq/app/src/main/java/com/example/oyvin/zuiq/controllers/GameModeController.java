package com.example.oyvin.zuiq.controllers;

import java.util.ArrayList;

public class GameModeController {
    private ArrayList<String> gameModes;

    private static GameModeController gameModeController = null;

    //CONSTRUCTOR
    //
    //This controller will add the different gamemodes
    //
    //---------------------------->>
    private GameModeController(){
        super();
        gameModes = new ArrayList<String>();
        gameModes.add("Questionnaire");
        gameModes.add("Score Race");
    }
    //<<----------------------------

    public static GameModeController getInstance(){
        if (gameModeController == null){
            gameModeController = new GameModeController();
        }
        return gameModeController;
    }

    public ArrayList<String> getGameModes(){
        return gameModes;
    }
}
