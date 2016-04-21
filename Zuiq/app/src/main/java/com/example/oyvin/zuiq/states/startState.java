package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Background;
import com.example.oyvin.zuiq.sprites.Logo;
import com.example.oyvin.zuiq.sprites.StartBtn;

import sheep.game.State;
import sheep.graphics.Image;


public class StartState extends State {
    private static StartState startState = null;
    Background background;
    Logo logo;
    StartBtn startBtn;


    private StartState(){
        Image backgroundImg = new Image(R.drawable.background);
        Image logoImg = new Image(R.drawable.logo);
        Image startBtnImg = new Image(R.drawable.startbtn);
        background = new Background(backgroundImg);
        logo = new Logo(logoImg);
        startBtn = new StartBtn(startBtnImg);
        this.addTouchListener(startBtn);


    }

    public static StartState getInstance() {
        if (startState == null) {
            startState = new StartState();
        }
        return startState;
    }

    public void draw (Canvas canvas) {

        background.setScale(canvas.getWidth() / background.getImageWidth(), canvas.getHeight() / background.getImageHeight());
        background.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 2);
        background.draw(canvas);
        logo.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 5.5f);
        logo.draw(canvas);
        startBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.5f);
        startBtn.draw(canvas);



    }

    public void update (float dt){
        logo.update(dt);
        background.update(dt);
        startBtn.update(dt);
    }
   public void switchState(State state){
       getGame().popState();
       getGame().pushState(state);
    }
}
