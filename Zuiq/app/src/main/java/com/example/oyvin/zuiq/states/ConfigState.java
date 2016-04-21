package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;

import sheep.game.State;

/**
 * Created by oyvind on 21/04/2016.
 */
public class ConfigState extends State {
    private static ConfigState configState = null;
    String gameMode;
    private ConfigState(){

    }
    public static ConfigState getInstance(){
        if (configState == null){
            configState = new ConfigState();
        }
        return configState;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        if(gameMode == "qn"){
            drawQuestionnaire(canvas);
        }
        else if(gameMode == "sr"){
            drawScoreRace(canvas);
        }
        else{
            System.out.println("fml");
        }
    }

    public void drawQuestionnaire(Canvas canvas){
        canvas.drawColor(Color.BLACK);
    }
    public void drawScoreRace(Canvas canvas){
        canvas.drawColor(Color.BLUE);
    }
}

