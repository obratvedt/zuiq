package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Background;

import sheep.game.State;
import sheep.graphics.Image;


public class BackgroundState extends State {
    Background background;

    public BackgroundState(){
        Image backgroundImg = new Image(R.drawable.background);
        background = new Background(backgroundImg);
    }



    public void draw (Canvas canvas){
        canvas.drawColor(Color.BLACK);
        background.setScale(canvas.getWidth() / background.getImageWidth(), canvas.getHeight() / background.getImageHeight());
        background.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 2);
        background.draw(canvas);
    }

    public void update(float dt){
        background.update(dt);
    }

    public void switchState(State state){
        getGame().popState();
        getGame().pushState(state);
    }
}
