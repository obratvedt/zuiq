package com.example.oyvin.zuiq.controllers;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.models.Question;
import com.example.oyvin.zuiq.sprites.AnswerBtn;
import com.example.oyvin.zuiq.states.GameState;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sheep.graphics.Image;

public class GameController {

    GameState game;
    Canvas canvas;
    ArrayList<AnswerBtn> ansButtons = new ArrayList<>();
    public Question thisQuestion;

    private Timer timer;
    private int delay = 0;
    private int totalTicks = 6 * 10;
    private int ticksLeft = totalTicks;
    public int secondsLeft = 6;

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
            if (secondsLeft > 0){
                System.out.println(secondsLeft);
            }

            else
                timesUp();
        }
    }

    private void timesUp() {
        timer.cancel();
        if (game.state.equals("q")) {
            game.state = "p";
            currentPlayer += 1;
            play();
        }
        else if (game.state.equals("p")) {
            game.state = "q";
            play();
        }
        else if (game.state.equals("s")) {
            game.state = "q";
            play();
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
    public int currentQuestion = 1;

    public GameController(GameState game) {
        this.game = game;
    }

    public void init() {
        canvas = game.thisCanvas;
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < ZiuqGame.getMaxPlayers(); i++) {
            Player player = new Player("Player" + (i + 1));
            players.add(player);
        }
        ansButtons.add(game.ans1);
        ansButtons.add(game.ans2);
        ansButtons.add(game.ans3);
        ansButtons.add(game.ans4);
        ZiuqGame.setPlayers(players);


        game.state = "q";
        thisQuestion = ZiuqGame.nextQuestion();
        play();

    }


    public void play() {

        /*
        System.out.println("QUESTION " + thisQuestion.getText());
        System.out.println("ANSWERS " + thisQuestion.getAnswers().toString());
        System.out.println("RIGHT " + thisQuestion.getRightAnswer().toString());
        */

        if (ZiuqGame.isQuestionnaire()) {
            //QUESTIONNAIRE GAMEMODE
            if (currentPlayer >= ZiuqGame.getPlayers().size() && currentQuestion >= ZiuqGame.getMaxQuestions()) {
                game.state = "hs";
            }
            else if (currentPlayer >= ZiuqGame.getPlayers().size()) {
                currentPlayer = 0;
                currentQuestion += 1;
                thisQuestion = ZiuqGame.nextQuestion();
                game.state = "s";
                secondsLeft = 15;
                startCountdown();
            }
            else {
                if (game.state.equals("p")) {

                }

                else if (game.state.equals("q")) {
                    if (ZiuqGame.getTimeLimit() == 0) {
                        for (int i = 0; i < thisQuestion.getAnswers().size(); i++) {
                            ansButtons.get(i).setText(thisQuestion.getAnswers().get(i).toString());
                            if (thisQuestion.getAnswers().get(i).equals(thisQuestion.getRightAnswer())) {
                                ansButtons.get(i).setCorrect("correct");
                            }
                            else {
                                ansButtons.get(i).setCorrect("incorrect");
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < thisQuestion.getAnswers().size(); i++) {
                            ansButtons.get(i).setText(thisQuestion.getAnswers().get(i).toString());
                            if (thisQuestion.getAnswers().get(i).equals(thisQuestion.getRightAnswer())) {
                                ansButtons.get(i).setCorrect("correct");
                            }
                            else {
                                ansButtons.get(i).setCorrect("incorrect");
                            }
                        }
                        secondsLeft = ZiuqGame.getTimeLimit();
                        startCountdown();
                    }

                }

                else {
                }
            }
        }

        else {
            //SCORE RACE GAMEMODE
            if (currentPlayer >= ZiuqGame.getPlayers().size()) {
                System.out.println("NEW SCORE RACE Q");
                currentPlayer = 0;
                currentQuestion += 1;
                thisQuestion = ZiuqGame.nextQuestion();
                game.state = "s";
                secondsLeft = 15;
                startCountdown();
                System.out.println(ZiuqGame.getQuestions());
                System.out.println(ZiuqGame.nextQuestion().toString());
            }
            else {
                if (game.state.equals("p")) {

                }

                else if (game.state.equals("q")) {
                    if (ZiuqGame.getTimeLimit() == 0) {
                        for (int i = 0; i < thisQuestion.getAnswers().size(); i++) {
                            ansButtons.get(i).setText(thisQuestion.getAnswers().get(i).toString());
                            if (thisQuestion.getAnswers().get(i).equals(thisQuestion.getRightAnswer())) {
                                ansButtons.get(i).setCorrect("correct");
                            }
                            else {
                                ansButtons.get(i).setCorrect("incorrect");
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < thisQuestion.getAnswers().size(); i++) {
                            ansButtons.get(i).setText(thisQuestion.getAnswers().get(i).toString());
                            if (thisQuestion.getAnswers().get(i).equals(thisQuestion.getRightAnswer())) {
                                ansButtons.get(i).setCorrect("correct");
                            }
                            else {
                                ansButtons.get(i).setCorrect("incorrect");
                            }
                        }
                        secondsLeft = ZiuqGame.getTimeLimit();
                        startCountdown();
                    }

                }

                else {
                }
            }

        }


    }



    public void isCorrect(String str) {
        if (str.equals("correct")) {
            System.out.println("Correct answer");
            ZiuqGame.getPlayers().get(currentPlayer).setScore(ZiuqGame.getPlayers().get(currentPlayer).getScore() + 1);
            if (ZiuqGame.getPlayers().get(currentPlayer).getScore() >= ZiuqGame.getMaxPoints() && !ZiuqGame.isQuestionnaire()) {
                game.state = "hs";
            }
            else {
                currentPlayer += 1;
                game.state = "p";
                if (ZiuqGame.getTimeLimit() != 0) timer.cancel();
                play();
            }


        } else if (str.equals("incorrect")) {
            System.out.println("Incorrect answer");
            currentPlayer += 1;
            game.state = "p";
            if (ZiuqGame.getTimeLimit() != 0) timer.cancel();
            play();
        }
    }










}
