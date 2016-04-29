package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Logo;
import com.example.oyvin.zuiq.sprites.StartBtn;

import sheep.graphics.Image;

public class StartState extends BackgroundState {
    private static StartState startState = null;

    Logo logo;
    StartBtn startBtn;


    //CONSTRUCTOR
    private StartState(){
        super();
        Image logoImg = new Image(R.drawable.logo);
        Image startBtnImg = new Image(R.drawable.startbtn);
        logo = new Logo(logoImg);
        startBtn = new StartBtn(startBtnImg, "config");
        this.addTouchListener(startBtn);
    }

    public static StartState getInstance() {
        if (startState == null) {
            startState = new StartState();
        }
        return startState;
    }

    //DRAW - draws the startbutton
    public void draw (Canvas canvas) {
        super.draw(canvas);
        logo.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 5.5f);
        logo.draw(canvas);
        startBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.5f);
        startBtn.draw(canvas);



    }

    //UPDATE
    public void update (float dt){
        logo.update(dt);
        startBtn.update(dt);
    }

}
