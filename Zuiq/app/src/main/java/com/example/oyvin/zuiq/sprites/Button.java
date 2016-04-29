package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public abstract class Button extends Sprite implements TouchListener {

    private float imageHeight,imageWidth;

    public float getImageWidth() {
        return imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
    }

    public Button(Image image, float scaleX, float scaleY) {
        super(image);
        imageHeight = image.getHeight();
        imageWidth = image.getWidth();
        setScale(scaleX, scaleY);
    }

    @Override
    public boolean onTouchDown(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if(touchOnSprite(motionEvent.getX(), motionEvent.getY())){
                onTouchDownSprite();
                return true;
            }
        }
        return false;
    }

    protected abstract void onTouchDownSprite();

    @Override
    public boolean onTouchUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent motionEvent) {
        return false;
    }

    protected boolean touchOnSprite(float xPos, float yPos) {
        if (xPos >= getX() - imageHeight / 2 && xPos <= getX() + imageWidth / 2) {
            if (yPos >= getY() - imageHeight / 2 && yPos <= getY() + imageHeight / 2) {
                return true;
            }
        }
        return false;
    }

}
