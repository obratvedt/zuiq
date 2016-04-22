package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.PosNegBtn;

import sheep.graphics.Image;

/**
 * Created by oyvind on 21/04/2016.
 */
public class ConfigState extends BackgroundState {
    private static ConfigState configState = null;
    String gameMode;
    int noOfPlayers = 1;
    Paint dscrtextPaint, varTextPaint;
    PosNegBtn addPlayer, removePlayer;
    private ConfigState(){
        super();
        addPlayer = new PosNegBtn(new Image(R.drawable.optionbtn), "pos");
        removePlayer = new PosNegBtn(new Image(R.drawable.optionbtn), "neg");
        this.addTouchListener(addPlayer);
        this.addTouchListener(removePlayer);
        dscrtextPaint = new Paint();
        dscrtextPaint.setColor(Color.WHITE);
        dscrtextPaint.setTextSize(50);
        varTextPaint = new Paint();
        varTextPaint.setColor(Color.LTGRAY);
        varTextPaint.setTextSize(100);



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
        super.draw(canvas);
        canvas.drawText("Select no. of players", canvas.getWidth() / 2 - 200, canvas.getHeight() / 2 - 110, dscrtextPaint);
        canvas.drawText("" + noOfPlayers, canvas.getWidth() / 2, canvas.getHeight() / 2, varTextPaint);
        setPositionOfSprites(canvas);
        addPlayer.draw(canvas);
        removePlayer.draw(canvas);

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

    }
    public void drawScoreRace(Canvas canvas){

    }
    public void setPositionOfSprites(Canvas canvas){
        addPlayer.setPosition(canvas.getWidth()/2 +200, canvas.getHeight()/2);
        removePlayer.setPosition(canvas.getWidth()/2-200, canvas.getHeight()/2);
    }

    public void update(float dt){
        super.update(dt);
        addPlayer.update(dt);
        removePlayer.update(dt);
    }

    public void setNoOfPlayers(int player){
        if (noOfPlayers > 0 && noOfPlayers < 5 && player >0){
            noOfPlayers += player;
        }
        else if(noOfPlayers >1 && noOfPlayers <= 5 && player < 0){
            noOfPlayers += player;
        }


    }
}

