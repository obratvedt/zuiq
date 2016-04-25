package com.example.oyvin.zuiq.controllers;

import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.models.Game;
import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.sprites.AnswerBtn;
import com.example.oyvin.zuiq.states.GameState;

import java.util.ArrayList;

import sheep.graphics.Image;

public class GameController {

    GameState game;
    Game config;
    Canvas canvas;

    public boolean inst = false;

    private int currentPlayer = 0;
    private int currentQuestion = 0;

    public GameController (GameState game, Game config) {
        this.game = game;
        this.config = config;
        System.out.println("CONTROLLER MADE");
    }

    public void init () {
        canvas = game.thisCanvas;

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));
        players.add(new Player("P3"));

        config.setPlayers(players);

        System.out.println("Players " + config.getPlayers().toString());
        System.out.println("Size " + config.getPlayers().size());
        play(currentPlayer, currentQuestion);
    }

    public void play (int p, int q) {
        if (currentPlayer >= config.getPlayers().size()) {
            currentPlayer = 0;
            currentQuestion += 1;
            game.state = "s";
            System.out.println("P1 score: " + config.getPlayers().get(0).getScore());
            System.out.println("P2 score: " +config.getPlayers().get(1).getScore());
            System.out.println("P3 score: " +config.getPlayers().get(2).getScore());
        }
        System.out.println("PLAYER " + currentPlayer);


    }

    public void isCorrect(String str) {
        if (str.equals("correct")) {
            System.out.println("Correct answer");
            config.getPlayers().get(currentPlayer).setScore(config.getPlayers().get(currentPlayer).getScore() + 1);
            currentPlayer += 1;
            play(currentPlayer, currentQuestion);
        }
        else if (str.equals("incorrect")) {
            System.out.println("Incorrect answer");
            currentPlayer += 1;
            play(currentPlayer, currentQuestion);
        }
    }



}
