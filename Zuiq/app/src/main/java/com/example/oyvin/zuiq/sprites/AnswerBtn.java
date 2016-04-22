package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class AnswerBtn extends Sprite implements TouchListener {
    float imageHeight,imageWidth;

    public AnswerBtn(Image image){
        super(image);
        this.imageHeight = image.getHeight()/2;
        this.imageWidth = image.getWidth()/2;
        setScale(0.4f, 0.4f);
    }

    public float getImageWidth() {
        return imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
    }


    @Override
    public boolean onTouchDown(MotionEvent motionEvent) {
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
}
