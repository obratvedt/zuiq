package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;
import android.graphics.Color;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Background;
import com.example.oyvin.zuiq.sprites.Logo;
import com.example.oyvin.zuiq.sprites.OptionBtn;

import sheep.game.State;
import sheep.graphics.Image;

public class GamemodeState extends State {
    private static GamemodeState gamemodeState = null;
    Background background;
    Logo logo;
    OptionBtn questionnaireBtn, scoreRaceBtn;

    private GamemodeState(){
        Image backgroundImg = new Image(R.drawable.background);
        Image logoImg = new Image(R.drawable.logo);
        Image questionnaireImg = new Image(R.drawable.optionbtn);
        Image scoreRaceImg = new Image(R.drawable.optionbtn);
        background = new Background(backgroundImg);
        logo = new Logo(logoImg);
        questionnaireBtn = new OptionBtn(questionnaireImg, "qn");
        scoreRaceBtn = new OptionBtn(scoreRaceImg, "sr");
        this.addTouchListener(questionnaireBtn);
        this.addTouchListener(scoreRaceBtn);

    }

    public static GamemodeState getInstance(){
        if (gamemodeState == null){
            gamemodeState = new GamemodeState();
        }
        return gamemodeState;
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        background.setScale(canvas.getWidth() / background.getImageWidth(), canvas.getHeight() / background.getImageHeight());
        background.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 2);
        background.draw(canvas);
        logo.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 5.5f);
        logo.draw(canvas);
        questionnaireBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.7f);
        scoreRaceBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.2f);
        scoreRaceBtn.draw(canvas);
        questionnaireBtn.draw(canvas);

    }
    public void update(float dt){
        background.update(dt);
        logo.update(dt);
        questionnaireBtn.update(dt);
        scoreRaceBtn.update(dt);
    }

    public void switchState(State state){
        getGame().popState();
        getGame().pushState(state);
    }
}
