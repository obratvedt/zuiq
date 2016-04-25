package com.example.oyvin.zuiq.controllers;

import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.Game;
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



    private static Timer timer;
    private static int delay = 0;
    private static int totalTicks = 6 * 10;
    private static int ticksLeft = totalTicks;
    private static int secondsLeft = 6;

    private Map<Integer, Player> players = new HashMap<>();

    private static void startCountdown () {
        int period = 100;
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count();
            }
        }, delay, period);
    }

    private static void count() {
        ticksLeft--;
        if (ticksLeft % 10 == 0) {
            secondsLeft--;
            if (secondsLeft > 0)
                System.out.println(secondsLeft);
            else
                timesUp();
        }
    }

    private static void timesUp() {
        timer.cancel();
        System.out.println("Time's up!");

    }

    public static void main (String[] args) {
        startCountdown();
    }

    public void calculatePointsBasedOnTick() {
        int score = 50 * (ticksLeft / totalTicks);

    }

    public void changeState() {

    }


    public boolean inst = false;

    private int currentPlayer = 0;
    private int currentQuestion = 0;

    public GameController(GameState game) {
        this.game = game;
        System.out.println("CONTROLLER MADE");
    }

    public void init() {
        canvas = game.thisCanvas;

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));
        players.add(new Player("P3"));

        Game.setPlayers(players);

        System.out.println("Players " + Game.getPlayers().toString());
        System.out.println("Size " + Game.getPlayers().size());
        play(currentPlayer, currentQuestion);
    }

    public void play(int p, int q) {


        startCountdown();


        if (currentPlayer >= Game.getPlayers().size()) {
            currentPlayer = 0;
            currentQuestion += 1;
            game.state = "s";
            System.out.println("P1 score: " + Game.getPlayers().get(0).getScore());
            System.out.println("P2 score: " + Game.getPlayers().get(1).getScore());
            System.out.println("P3 score: " + Game.getPlayers().get(2).getScore());
        }
        System.out.println("PLAYER " + currentPlayer);


    }

    public void isCorrect(String str) {
        if (str.equals("correct")) {
            System.out.println("Correct answer");
            Game.getPlayers().get(currentPlayer).setScore(Game.getPlayers().get(currentPlayer).getScore() + 1);
            currentPlayer += 1;
            play(currentPlayer, currentQuestion);
        } else if (str.equals("incorrect")) {
            System.out.println("Incorrect answer");
            currentPlayer += 1;
            play(currentPlayer, currentQuestion);
        }
    }










}
