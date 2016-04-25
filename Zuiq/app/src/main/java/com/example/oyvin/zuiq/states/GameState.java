package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.AnswerBtn;

import sheep.graphics.Image;

public class GameState extends BackgroundState {
    private static GameState gameState = null;
    AnswerBtn answerBtnFirst, answerBtnScnd;

    public static GameState getInstance() {
        if(gameState == null){
            gameState = new GameState();
        }
        return gameState;
    }

    private GameState() {
        super();
        answerBtnFirst = new AnswerBtn(new Image(R.drawable.optionbtn),"test");
        answerBtnScnd = new AnswerBtn(new Image(R.drawable.optionbtn), "trolo");
        this.addTouchListener(answerBtnFirst);
        this.addTouchListener(answerBtnScnd);



    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        answerBtnFirst.setPosition(canvas.getWidth() / 2 - 200, canvas.getHeight() / 2);
        answerBtnScnd.setPosition(canvas.getWidth() / 2 + 200, canvas.getHeight() / 2);
        answerBtnFirst.draw(canvas);
        answerBtnScnd.draw(canvas);
        System.out.println(String.format("%s , %s", answerBtnFirst.getPosition(), answerBtnScnd.getPosition()));

    }

    public void update(float dt) {
        super.update(dt);
        answerBtnFirst.update(dt);
        answerBtnScnd.update(dt);
    }
}
