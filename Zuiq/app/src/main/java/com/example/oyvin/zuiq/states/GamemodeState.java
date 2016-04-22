package com.example.oyvin.zuiq.states;


import android.graphics.Canvas;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.sprites.Logo;
import com.example.oyvin.zuiq.sprites.OptionBtn;

import sheep.graphics.Image;

public class GamemodeState extends BackgroundState {
    private static GamemodeState gamemodeState = null;
    Logo logo;
    OptionBtn questionnaireBtn, scoreRaceBtn;

    private GamemodeState(){
        super();
        Image logoImg = new Image(R.drawable.logo);
        Image questionnaireImg = new Image(R.drawable.optionbtn);
        Image scoreRaceImg = new Image(R.drawable.optionbtn);
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
        super.draw(canvas);
        logo.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 5.5f);
        logo.draw(canvas);
        questionnaireBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.7f);
        scoreRaceBtn.setPosition(canvas.getWidth() / 2, canvas.getHeight() / 1.2f);
        scoreRaceBtn.draw(canvas);
        questionnaireBtn.draw(canvas);

    }
    public void update(float dt){
        logo.update(dt);
        questionnaireBtn.update(dt);
        scoreRaceBtn.update(dt);
    }


}
