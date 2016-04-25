package com.example.oyvin.zuiq.controllers;

import com.example.oyvin.zuiq.Game;

public abstract class Controller {

    private Game game;

    public Game getGame() {
        return game;
    }

    public void initialize(Game game) {
        this.game = game;
    }

}
