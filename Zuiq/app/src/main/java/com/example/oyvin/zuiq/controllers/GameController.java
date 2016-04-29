package com.example.oyvin.zuiq.controllers;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.models.Question;
import com.example.oyvin.zuiq.sprites.AnswerBtn;
import com.example.oyvin.zuiq.states.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sheep.graphics.Image;

public class GameController {


    //------------- GAME CONTROLLER --------------
    //



    //DECLARATIONS AND FIELDS
    //
    //This section is for declaration of the important fields and
    //data to be used in the controller. We need to recieve the
    //Gamestate and canvas in order to the do changes and operations
    //we want. Most of the fields are private and can only be accessed
    //within the controller. Some of them are also public because
    //they are supposed to be read and changed from outside this
    //controller class. eg. inst, currentPlayer, currentQuestion.
    //
    //---------------------------->>
    GameState game;
    Canvas canvas;
    ArrayList<AnswerBtn> ansButtons = new ArrayList<>();
    private Question thisQuestion;
    private Question prevQuestion;

    private Timer timer;
    private int delay = 0;
    private int totalTicks = 6 * 10;
    private int ticksLeft = totalTicks;
    private int secondsLeft = 6;

    private Map<Integer, Player> players = new HashMap<>();

    public boolean inst = false;
    public int currentPlayer = 0;
    public int currentQuestion = 1;

    //<<----------------------------


    //TIMER / COUNTDOWN
    //
    //This next part of the code contains the countdown for different
    //parts of the game like time limit to answer and time limit between
    //rounds. It is pretty self explanatory, but we have chosen to make
    //timesUp public because it needs to be called from different parts
    //of the application. This changes and handles the "state" field
    //for the game state. This field decides the flow and control of
    // the game.
    //
    //---------------------------->>
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

    public void timesUp() {
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
        else {

        }
        System.out.println("Time's up!");

    }

    public void main (String[] args) {
        startCountdown();
    }

    //<<----------------------------

    //CONSTRUCTOR
    //
    //This is the constructor for the controller which recieves the instance
    //of the gamestate from the gamestate itself. It is stored for further use
    //
    //---------------------------->>
    public GameController(GameState game) {
        this.game = game;
    }
    //<<----------------------------


    //INITIALIZATION OF THE GAME
    //
    //This init method is only called once, when the game is started. It sets
    //the players for the current game given from the ZiuqGame static model.
    //It also sets the canvas for further use, and stores the games buttons for
    //handling of correct answers (see "ANSWER BUTTONS section later"). It then
    //starts the game by setting the state to q (Question) and calling the play method.
    //
    //---------------------------->>
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
    //<<----------------------------



    //PLAY / THE GAME LOGIC
    //
    //This is where the game logic happens. The game has different set rules
    //for the two game modes. The first issue to be checked is this; which gamemode is currently active.
    //When the game mode is checked, it proceeds to verify some of the rules
    //for the gamemode eg. if all players have answered a question in the round, if all questions have been answered.
    //
    //---------------------------->>
    public void play() {

        //Have all players answered, and is it the last question?
        //This is the winning / game finished criteria for the Questionnaire game mode
        //
        //For the winning criteria for Score Race please see WINNING CRITERIA SCORE RACE below.
        if (currentPlayer >= ZiuqGame.getPlayers().size() && ZiuqGame.isQuestionnaire() && currentQuestion >= ZiuqGame.getMaxQuestions()) {
            game.state = "hs";
        }

        //Have all players answered - this means that the current round is over,
        //and we need a new question.
        else if (currentPlayer >= ZiuqGame.getPlayers().size()) {
            currentPlayer = 0;
            currentQuestion += 1;
            prevQuestion = thisQuestion;
            thisQuestion = ZiuqGame.nextQuestion();
            game.state = "s";
            secondsLeft = 15;
            startCountdown();
        }
        else {

            //Do nothing if in pause state
            if (game.state.equals("p")) {

            }

            //If the game is in question state
            else if (game.state.equals("q")) {

                //ANSWER BUTTONS
                //
                //---------------------------->>

                //And there is no time limit
                if (ZiuqGame.getTimeLimit() == 0) {

                    //Set text for the answers to the current question. This includes
                    //giving the button the right "correct" field. "correct" for the right answer
                    //and "incorrect" for the wrong answer. The text field is the corresponding answer
                    //as a String.
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

                //And there is a time limit
                else {
                    //Set text for the answers to the current question. This includes
                    //giving the button the right "correct" field. "correct" for the right answer
                    //and "incorrect" for the wrong answer. The text field is the corresponding answer
                    //as a String.
                    for (int i = 0; i < thisQuestion.getAnswers().size(); i++) {
                        ansButtons.get(i).setText(thisQuestion.getAnswers().get(i).toString());
                        if (thisQuestion.getAnswers().get(i).equals(thisQuestion.getRightAnswer())) {
                            ansButtons.get(i).setCorrect("correct");
                        }
                        else {
                            ansButtons.get(i).setCorrect("incorrect");
                        }
                    }
                    //Set the seconds for the time limit and start the timer.
                    secondsLeft = ZiuqGame.getTimeLimit();
                    startCountdown();
                }
                //<<----------------------------
            }


            //Do nothing
            else {
            }
        }
    }
    //<<----------------------------




    //IS THE ANSWER CORRECT
    //
    //This part of the program checks if a given answer is the correct one.
    //This is also where the players are given points. The points given
    //are calculated from the time they spent answering the question. If
    //there is no time limit, there is a fixed number of points given.
    //
    //---------------------------->>
    public void isCorrect(String str) {

        //If the player answered correctly
        if (str.equals("correct")) {
            System.out.println("Correct answer");

            //If there is a time limit
            if (ZiuqGame.getTimeLimit() != 0) {
                double scoreBase = (double)secondsLeft / (double)ZiuqGame.getTimeLimit();

                //Calculation of points
                ZiuqGame.getPlayers().get(currentPlayer).setScore(ZiuqGame.getPlayers().get(currentPlayer).getScore() +
                        (int) (Math.floor((scoreBase * 50))));
            }

            //If there is no time limit
            else {
                //Give 50 points
                ZiuqGame.getPlayers().get(currentPlayer).setScore(ZiuqGame.getPlayers().get(currentPlayer).getScore() + 50);
            }

            //WINNING CRITERIA SCORE RACE
            //If the current player answered correctly and is at or above the score race points limit, the game
            //ends and a winner is crowned.
            if (ZiuqGame.getPlayers().get(currentPlayer).getScore() >= ZiuqGame.getMaxPoints() && !ZiuqGame.isQuestionnaire()) {
                System.out.println(ZiuqGame.getMaxPoints());
                game.state = "hs";
            }

            //If there is no winner crowned, carry on as usual (increase player index)
            else {
                currentPlayer += 1;
                game.state = "p";
                if (ZiuqGame.getTimeLimit() != 0) timer.cancel();
                play();
            }


        }

        //If the answer is incorrect, give no points and increase player index.
        else if (str.equals("incorrect")) {
            System.out.println("Incorrect answer");
            currentPlayer += 1;
            game.state = "p";
            if (ZiuqGame.getTimeLimit() != 0) timer.cancel();
            play();
        }
    }
    //<<----------------------------



    //GETTERS
    //
    //This section contains getters for some of the fields where it is
    //necessary.
    //
    //---------------------------->>
    public Question getThisQuestion() {
        return thisQuestion;
    }

    public Question getPrevQuestion() {
        return prevQuestion;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }
    //<<----------------------------

}
