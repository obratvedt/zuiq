package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;

import sheep.game.State;

public class ConfigState extends State {
    private ConfigState configState = null;

    private ConfigState(){

    }

    public ConfigState getInstance(){
        if (configState == null){
            configState = new ConfigState();
        }
        return configState;
    }

    public void draw(Canvas canvas){

    }
}
