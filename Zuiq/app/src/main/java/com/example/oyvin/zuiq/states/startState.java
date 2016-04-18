package com.example.oyvin.zuiq.states;


import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.os.Build;

import com.example.oyvin.zuiq.R;

import sheep.game.State;
import sheep.graphics.Image;

public class StartState extends State {
    private static StartState startState = null;
    private Image backGround;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private StartState(){
        backGround = new Image(R.drawable.background);

    }

    public static StartState getInstance() {
        if (startState == null) {
            startState = new StartState();
        }
        return startState;
    }

    public void draw (Canvas canvas){
       
    }

    public void update (float dt){

    }
}
