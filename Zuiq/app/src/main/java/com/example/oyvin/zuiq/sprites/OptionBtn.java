package com.example.oyvin.zuiq.sprites;


import android.view.MotionEvent;

import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.states.ConfigState;
import com.example.oyvin.zuiq.states.GameModeState;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class OptionBtn extends Sprite implements TouchListener{
    float imageWidth, imageHeight;
    boolean gameMode;

    public OptionBtn(Image image, boolean gameMode){
        super(image);
        this.imageHeight = image.getHeight()/2;
        this.imageWidth = image.getWidth()/2;
        setScale(0.5f, 0.5f);
        this.gameMode = gameMode;

    }

    public float getImageWidth() {
        return imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
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

    @Override
    public boolean onTouchUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent motionEvent) {
        return false;
    }

    private boolean touchOnSprite(float xPos, float yPos) {
        if (xPos >= getX() - getImageHeight() / 2 && xPos <= getX() + getImageWidth() / 2) {
            if (yPos >= getY() - getImageHeight() / 2 && yPos <= getY() + getImageHeight() / 2) {
                return true;
            }
        }
        return false;
    }
}
