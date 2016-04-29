package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

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
    public boolean onTouchDown(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if (touchOnSprite(motionEvent.getX(), motionEvent.getY())){
                ZiuqGame.setQuestionnaire(gameMode);
                GameModeState.getInstance().switchState(ConfigState.getInstance());
                return true;
            }
        }
        return false;
    }

}
