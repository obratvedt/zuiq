package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class AnswerBtn extends Sprite implements TouchListener {
    float imageHeight,imageWidth;
    String correct;

    public AnswerBtn(Image image, String correct){
        super(image);
        this.correct = correct;
        this.imageHeight = image.getHeight()/2;
        this.imageWidth = image.getWidth()/2;
        setScale(0.5f, 0.5f);
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

            if(touchOnSprite(motionEvent.getX(),motionEvent.getY())){
                System.out.println("I am touched");;

            }

            return true;
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
