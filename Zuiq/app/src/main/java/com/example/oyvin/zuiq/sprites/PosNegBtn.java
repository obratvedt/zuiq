package com.example.oyvin.zuiq.sprites;


import android.view.MotionEvent;

import com.example.oyvin.zuiq.states.ConfigState;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class PosNegBtn extends Sprite implements TouchListener {
    float imageHeight, imageWidth;
    String type;
    public PosNegBtn(Image image, String type){
        super(image);
        this.type=type;
        this.imageHeight = image.getHeight()/2;
        this.imageWidth = image.getWidth()/2;
        setScale(0.1f, 0.2f);
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
                if (type == "addPlayer"){
                    ConfigState.getInstance().setNoOfPlayers(1);
                }
                else if (type == "removePlayer"){
                    ConfigState.getInstance().setNoOfPlayers(-1);
                }
                else if (type == "addSecond"){
                    ConfigState.getInstance().setNoOfSeconds(1);
                }
                else if(type == "removeSecond"){
                    ConfigState.getInstance().setNoOfSeconds(-1);
                }

                else if(type == "addQuestion"){
                    ConfigState.getInstance().setNoOfQuestions(1);
                }
                else if (type == "removeQuestion"){
                    ConfigState.getInstance().setNoOfQuestions(-1);
                }
                else if (type == "addScore"){
                    ConfigState.getInstance().setScoreLimit(1);
                }
                else if (type == "removeScore"){
                    ConfigState.getInstance().setScoreLimit(-1);
                }
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
