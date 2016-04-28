package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.controllers.GameController;
import com.example.oyvin.zuiq.sprites.AnswerBtn;

import sheep.graphics.Image;

public class GameState extends BackgroundState {
    private static GameState gameState = null;
    public Canvas thisCanvas;
    public AnswerBtn ans1, ans2, ans3, ans4;
    public GameController controller;
    public String state;
    Paint playerPaint;


    public static GameState getInstance() {
        if(gameState == null){
            gameState = new GameState();
        }
        return gameState;
    }

    private GameState() {
        super();
        ans1 = new AnswerBtn(new Image(R.drawable.optionbtn), "correct");
        ans2 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        ans3 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");
        ans4 = new AnswerBtn(new Image(R.drawable.optionbtn), "incorrect");

        playerPaint = new Paint();
        playerPaint.setColor(Color.WHITE);
        playerPaint.setTextSize(50);

        controller = new GameController(this);
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        thisCanvas = canvas;

        ans1.setScale(0.4f, 0.4f);
        ans2.setScale(0.4f, 0.4f);
        ans3.setScale(0.4f, 0.4f);
        ans4.setScale(0.4f, 0.4f);

        ans1.setPosition(canvas.getWidth() / 2 - 250, canvas.getHeight() / 3);
        ans2.setPosition(canvas.getWidth() / 2 + 250, canvas.getHeight() / 3);
        ans3.setPosition(canvas.getWidth() / 2 - 250, canvas.getHeight() / 1.5f);
        ans4.setPosition(canvas.getWidth() / 2 + 250, canvas.getHeight() / 1.5f);


        if (controller.inst == false) {
            controller.init();
            controller.inst = true;
        }

        else {

            if (state.equals("q")) {
                this.addTouchListener(ans1);
                this.addTouchListener(ans2);
                this.addTouchListener(ans3);
                this.addTouchListener(ans4);
                drawQuestion();
            }
            else if (state.equals("p")) {
                this.removeTouchListener(ans1);
                this.removeTouchListener(ans2);
                this.removeTouchListener(ans3);
                this.removeTouchListener(ans4);
                drawPause();
            }

            else if (state.equals("s")) {
                this.removeTouchListener(ans1);
                this.removeTouchListener(ans2);
                this.removeTouchListener(ans3);
                this.removeTouchListener(ans4);
            }
            else if (state.equals("hs")) {
                this.removeTouchListener(ans1);
                this.removeTouchListener(ans2);
                this.removeTouchListener(ans3);
                this.removeTouchListener(ans4);
            }
        }
    }

    public void drawPause() {
        thisCanvas.drawText("Pass the device to player " + (controller.currentPlayer + 1), thisCanvas.getWidth()/2-100, thisCanvas.getHeight()/1.2f, playerPaint);

    }

    public void drawQuestion () {

        ans1.draw(thisCanvas);
        ans2.draw(thisCanvas);
        ans3.draw(thisCanvas);
        ans4.draw(thisCanvas);

    }

    public void update(float dt) {
        super.update(dt);
        ans1.update(dt);
        ans2.update(dt);
        ans3.update(dt);
        ans4.update(dt);
    }
}
