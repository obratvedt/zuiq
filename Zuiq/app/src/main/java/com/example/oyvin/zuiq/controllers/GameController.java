package com.example.oyvin.zuiq.controllers;

import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.sprites.AnswerBtn;
import com.example.oyvin.zuiq.states.GameState;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import sheep.graphics.Image;

public class GameController {

    GameState game;
    Canvas canvas;



    private Timer timer;
    private int delay = 0;
    private int totalTicks = 6 * 10;
    private int ticksLeft = totalTicks;
    private int secondsLeft = 6;

    private Map<Integer, Player> players = new HashMap<>();

    private void startCountdown () {
        int period = 100;
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count();
            }
        }, delay, period);
    }

    private void count() {
        ticksLeft--;
        if (ticksLeft % 10 == 0) {
            secondsLeft--;
            if (secondsLeft > 0)
                System.out.println(secondsLeft);
            else
                timesUp();
        }
    }

    private void timesUp() {
        timer.cancel();
        if (game.state.equals("q")) {
            game.state = "p";
            currentPlayer += 1;
            play(currentPlayer, currentQuestion);
        }
        else if (game.state.equals("p")) {
            game.state = "q";
            play(currentPlayer, currentQuestion);
        }
        else if (game.state.equals("s")) {
            game.state = "q";
            play(currentPlayer, currentQuestion);
        }
        System.out.println("Time's up!");

    }

    public void main (String[] args) {
        startCountdown();
    }

    public void calculatePointsBasedOnTick() {
        int score = 50 * (ticksLeft / totalTicks);

    }

    public boolean inst = false;

    public int currentPlayer = 0;
    public int currentQuestion = 0;

    public GameController(GameState game) {
        this.game = game;
        System.out.println("CONTROLLER MADE");
    }

    public void init() {
        canvas = game.thisCanvas;
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < ZiuqGame.getMaxPlayers(); i++) {
            Player player = new Player("Player" + (i + 1));
            players.add(player);
        }

        ZiuqGame.setPlayers(players);

        System.out.println("Players " + ZiuqGame.getPlayers().toString());
        game.state = "q";
        play(currentPlayer, currentQuestion);

    }

    public void play(int p, int q) {

        if (currentPlayer >= ZiuqGame.getPlayers().size()) {
            currentPlayer = 0;
            currentQuestion += 1;
            game.state = "s";
            secondsLeft = 15;
            startCountdown();
        }
        else {
            System.out.println("PLAYER " + currentPlayer);
            if (game.state.equals("p")) {
                secondsLeft = 5;
                startCountdown();
                }

            else if (game.state.equals("q")) {
                if (ZiuqGame.getTimeLimit() == 0) {

                }
                else {
                    secondsLeft = ZiuqGame.getTimeLimit();
                    startCountdown();
                }

            }
        }
    }
    


    public void isCorrect(String str) {
        if (str.equals("correct")) {
            System.out.println("Correct answer");
            ZiuqGame.getPlayers().get(currentPlayer).setScore(ZiuqGame.getPlayers().get(currentPlayer).getScore() + 1);
            currentPlayer += 1;
            game.state = "p";
            timer.cancel();
            play(currentPlayer, currentQuestion);

        } else if (str.equals("incorrect")) {
            System.out.println("Incorrect answer");
            currentPlayer += 1;
            game.state = "p";
            timer.cancel();
            play(currentPlayer, currentQuestion);
        }
    }










}
