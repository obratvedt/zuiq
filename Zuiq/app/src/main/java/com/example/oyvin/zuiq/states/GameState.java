package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.controllers.GameController;
import com.example.oyvin.zuiq.helpers.Highscore;
import com.example.oyvin.zuiq.models.Question;
import com.example.oyvin.zuiq.sprites.AnswerBtn;
import com.example.oyvin.zuiq.sprites.CancelBtn;
import com.example.oyvin.zuiq.sprites.ReadyBtn;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

import sheep.graphics.Image;

public class GameState extends BackgroundState {


    //FIELDS AND DECLARATIONS
    //
    //Here are the different fields, sprites, objects, paints to be used within
    //the game state. Some of them are public so they can be accessed and changed
    //from other sections of the program.
    //
    //---------------------------->>
    private static GameState gameState = null;
    public Canvas thisCanvas;
    public AnswerBtn ans1, ans2, ans3, ans4;
    public ReadyBtn rdy;
    public GameController controller;
    public String state;
    public CancelBtn cancelBtn;
    Paint playerPaint;
    Paint ans1Paint, ans2Paint, ans3Paint, ans4Paint;
    Paint QuestionPaint;
    Paint TimerPaint;
    public ArrayList<AnswerBtn> ansbtns = new ArrayList<>();
    public ArrayList<Paint> anspaints = new ArrayList<>();

    private boolean answerListeners = false;
    private boolean pauseListener = false;
    //<<----------------------------


    //STATE
    public static GameState getInstance() {
        if(gameState == null){
            gameState = new GameState();
        }
        return gameState;
    }


    //CONSTRUCTOR
    //
    //Here the constructor gives values and properties to the different buttons,
    //sprites, paints and text fields. This is also where the controller is made
    //and set.
    //
    //---------------------------->>
    private GameState() {
        super();

        ans1 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        ans2 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        ans3 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        ans4 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        rdy = new ReadyBtn(new Image(R.drawable.startbtn));
        cancelBtn = new CancelBtn(new Image(R.drawable.btn_cancel));

        ansbtns.add(ans1);
        ansbtns.add(ans2);
        ansbtns.add(ans3);
        ansbtns.add(ans4);


        playerPaint = new Paint();
        playerPaint.setColor(Color.WHITE);
        playerPaint.setTextSize(100);

        ans1Paint = new Paint();
        ans2Paint = new Paint();
        ans3Paint = new Paint();
        ans4Paint = new Paint();
        QuestionPaint = new Paint();
        TimerPaint = new Paint();

        ans1Paint.setColor(Color.BLACK);
        ans2Paint.setColor(Color.BLACK);
        ans3Paint.setColor(Color.BLACK);
        ans4Paint.setColor(Color.BLACK);
        QuestionPaint.setColor(Color.WHITE);
        TimerPaint.setColor(Color.WHITE);
        TimerPaint.setTextSize(150);

        anspaints.add(ans1Paint);
        anspaints.add(ans2Paint);
        anspaints.add(ans3Paint);
        anspaints.add(ans4Paint);

        this.addTouchListener(cancelBtn);

        //Tells the static model ZiuqGame to generate questions based on the game rules.
        ZiuqGame.selectQuestions(new Random());

        //Controller
        controller = new GameController(this);
    }
    //<<----------------------------


    //DRAW
    //
    //This is where the view graphics are drawn. The draw function will check if
    //the controller has been initialized through the inst boolean. If not, it will
    //init the controller once. Further on it will draw the different parts of the game
    //based on the current state.
    //
    //<<----------------------------
    public void draw(Canvas canvas){
        super.draw(canvas);
        thisCanvas = canvas;

        ans1.setPosition(canvas.getWidth() / 2 - 300, canvas.getHeight() / 3);
        ans2.setPosition(canvas.getWidth() / 2 + 300, canvas.getHeight() / 3);
        ans3.setPosition(canvas.getWidth() / 2 - 300, canvas.getHeight() / 1.5f);
        ans4.setPosition(canvas.getWidth() / 2 + 300, canvas.getHeight() / 1.5f);
        rdy.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.5f);
        cancelBtn.setPosition(canvas.getWidth()/9, canvas.getHeight() / 9);
        cancelBtn.draw(canvas);


        //Init controller
        if (controller.inst == false) {
            controller.init();
            controller.inst = true;
        }

        //If already init'ed
        else {

            //Check which state the game is in and draw buttons / text, and remove/add listeners accordingly.
            if (state.equals("q")) {
                if (!answerListeners) {
                    this.addTouchListener(ans1);
                    this.addTouchListener(ans2);
                    this.addTouchListener(ans3);
                    this.addTouchListener(ans4);
                    answerListeners = true;
                }

                if (pauseListener){
                    this.removeTouchListener(rdy);
                    pauseListener = false;
                }


                drawQuestion();
            }
            else if (state.equals("p")) {
                if(answerListeners) {
                    this.removeTouchListener(ans1);
                    this.removeTouchListener(ans2);
                    this.removeTouchListener(ans3);
                    this.removeTouchListener(ans4);

                    answerListeners = false;
                }
                if (!pauseListener) {
                    this.addTouchListener(rdy);
                    pauseListener = true;
                }
                drawPause();

            }

            else if (state.equals("s")) {

                if (answerListeners){
                    this.removeTouchListener(ans1);
                    this.removeTouchListener(ans2);
                    this.removeTouchListener(ans3);
                    this.removeTouchListener(ans4);
                    answerListeners = false;
                }
                if (pauseListener) {
                    this.removeTouchListener(rdy);
                    pauseListener = false;
                }


                drawScore();
            }
            else if (state.equals("hs")) {
                if (answerListeners){
                    this.removeTouchListener(ans1);
                    this.removeTouchListener(ans2);
                    this.removeTouchListener(ans3);
                    this.removeTouchListener(ans4);
                    answerListeners = false;
                }
                if (pauseListener) {
                    this.removeTouchListener(rdy);
                    pauseListener = false;
                }

                drawHighScore();
            }
        }
    }
    //<<----------------------------


    //OTHER DRAW FUNCTIONS
    //
    //These functions are used by the main draw function to individually draw
    //different parts of the game.
    //
    //---------------------------->>
    public void drawPause() {
        thisCanvas.drawText("Pass the device to player " + (controller.currentPlayer + 1), thisCanvas.getWidth() / 5 - 100, thisCanvas.getHeight() / 1.2f, playerPaint);
        rdy.draw(thisCanvas);
    }

    public void drawHighScore () {

        //Draw the scores when the game is finished.
        thisCanvas.drawText("GAME FINISHED", thisCanvas.getWidth() / 4, thisCanvas.getHeight() / 5, playerPaint);

        //Get a sorted list wit hthe players score and draw it to the canvas sorted.
        Highscore hi = new Highscore(new ArrayList<>(ZiuqGame.getPlayers()));
        for (int i = 0; i < hi.getHighscore().size(); i++) {
            thisCanvas.drawText(hi.getHighscore().get(i).toString(), thisCanvas.getWidth()/5, (thisCanvas.getHeight()/3)+100*i, playerPaint );
        }
    }
    public void drawQuestion () {
        ans1.draw(thisCanvas);
        ans2.draw(thisCanvas);
        ans3.draw(thisCanvas);
        ans4.draw(thisCanvas);

        //Draw the answers on the correct buttons
        for (int i = 0; i < anspaints.size(); i++) {
            anspaints.get(i).setTextSize(75 -  (1.4f*ansbtns.get(i).getText().length()));
            thisCanvas.drawText(ansbtns.get(i).getText(), ansbtns.get(i).getX() - ansbtns.get(i).getImageWidth()/3, ansbtns.get(i).getY(), anspaints.get(i));
        }

        QuestionPaint.setTextSize(100 - 0.9f * controller.getThisQuestion().getText().length());

        //Draw the question
        thisCanvas.drawText(controller.getThisQuestion().getText(), thisCanvas.getWidth()/10, thisCanvas.getHeight()/5, QuestionPaint);

        //Draw the time limit if there is one
        if (ZiuqGame.getTimeLimit() != 0) thisCanvas.drawText(""+controller.getSecondsLeft(), thisCanvas.getWidth()-200, thisCanvas.getHeight()/10, TimerPaint);


    }

    public void drawScore () {

        //Get a sorted list with the players, sorted by their current score.
        Highscore hi = new Highscore(new ArrayList<>(ZiuqGame.getPlayers()));

        //Draw the players score sorted
        for (int i = 0; i < hi.getHighscore().size(); i++) {
            thisCanvas.drawText(hi.getHighscore().get(i).toString(), thisCanvas.getWidth()/5, (thisCanvas.getHeight()/3)+100*i, playerPaint );
        }

        //Draw the current time limit until the game continues
        if (ZiuqGame.getTimeLimit() != 0) thisCanvas.drawText(""+controller.getSecondsLeft(), thisCanvas.getWidth()-200, thisCanvas.getHeight()/10, TimerPaint);

        //If the players recently have answered a question, draw the correct answer for the previous question.
        if (state == "s") {
            thisCanvas.drawText("Correct answer was : ", thisCanvas.getWidth()/9,
                    thisCanvas.getHeight()/1.2f, playerPaint );
            thisCanvas.drawText(controller.getPrevQuestion().getRightAnswer().getText(),thisCanvas.getWidth()/9,
                    thisCanvas.getHeight()/1.1f, playerPaint );
        }


    }
    //<<----------------------------


    //UPDATE
    public void update(float dt) {
        super.update(dt);
        ans1.update(dt);
        ans2.update(dt);
        ans3.update(dt);
        ans4.update(dt);
        rdy.update(dt);
        cancelBtn.update(dt);
    }
}
