package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.controllers.GameModeController;
import com.example.oyvin.zuiq.sprites.Logo;
import com.example.oyvin.zuiq.sprites.OptionBtn;

import java.util.ArrayList;

import sheep.graphics.Image;

public class GameModeState extends BackgroundState {
    private static GameModeState gameModeState = null;
    Logo logo;
    OptionBtn questionnaireBtn, scoreRaceBtn;
    Paint buttonTextPaint;
    GameModeController gameModeController;
    ArrayList<String> gameModes;

    private GameModeState(){
        super();
        gameModeController = GameModeController.getInstance();
        gameModes = gameModeController.getGameModes();
        Image logoImg = new Image(R.drawable.logo);
        Image questionnaireImg = new Image(R.drawable.optionbtn);
        Image scoreRaceImg = new Image(R.drawable.optionbtn);
        logo = new Logo(logoImg);
        questionnaireBtn = new OptionBtn(questionnaireImg, "qn");
        scoreRaceBtn = new OptionBtn(scoreRaceImg, "sr");
        this.addTouchListener(questionnaireBtn);
        this.addTouchListener(scoreRaceBtn);
        buttonTextPaint = new Paint();
        buttonTextPaint.setColor(Color.BLACK);
        buttonTextPaint.setTextSize(50);

    }

    public static GameModeState getInstance(){
        if (gameModeState == null){
            gameModeState = new GameModeState();
        }
        return gameModeState;
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        logo.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 5.5f);
        logo.draw(canvas);
        questionnaireBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.7f);
        scoreRaceBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.2f);
        scoreRaceBtn.draw(canvas);
        questionnaireBtn.draw(canvas);
        canvas.drawText(gameModes.get(0), questionnaireBtn.getX()-150, questionnaireBtn.getY(),buttonTextPaint);
        canvas.drawText(gameModes.get(1), scoreRaceBtn.getX()-130, scoreRaceBtn.getY(), buttonTextPaint);

    }
    public void update(float dt){
        logo.update(dt);
        questionnaireBtn.update(dt);
        scoreRaceBtn.update(dt);
    }


}
