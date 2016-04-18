package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Background;

import sheep.game.State;
import sheep.graphics.Image;


public class StartState extends State {
    private static StartState startState = null;
    private Background background;


        private StartState(){
            background = new Background(new Image(R.drawable.background));
            background.setScale(2f,2f);



    }

    public static StartState getInstance() {
        if (startState == null) {
            startState = new StartState();
        }
        return startState;
    }

    public void draw (Canvas canvas){
        super.draw(canvas);
        background.draw(canvas);

    }

    public void update (float dt){

    }
}
