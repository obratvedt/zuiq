package com.example.oyvin.zuiq.sprites;

import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.states.ConfigState;
import com.example.oyvin.zuiq.states.GameModeState;

import sheep.graphics.Image;

public class OptionBtn extends Button {

    boolean gameMode;

    public OptionBtn(Image image, boolean gameMode){
        super(image, 0.5f, 0.5f);
        this.gameMode = gameMode;
    }

    @Override
    protected void onTouchDownSprite() {
        ZiuqGame.setQuestionnaire(gameMode);
        GameModeState.getInstance().switchState(ConfigState.getInstance());

    }

}
