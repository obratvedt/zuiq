package com.example.oyvin.zuiq.controllers;

import com.example.oyvin.zuiq.models.Game;

public abstract class Controller {

    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
