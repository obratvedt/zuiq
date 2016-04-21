package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import com.example.oyvin.zuiq.states.GamemodeState;
import com.example.oyvin.zuiq.states.StartState;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

/**
 * Created by oyvind on 21/04/2016.
 */
public class StartBtn extends Sprite implements TouchListener{
    float imageWidth, imageHeight;
    public StartBtn(Image image){
        super(image);
        this.imageHeight = image.getHeight()/4;
        this.imageWidth = image.getWidth()/4;
        this.setScale(0.4f,0.4f);

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
                StartState.getInstance().switchState(GamemodeState.getInstance());
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
