package com.example.oyvin.zuiq.sprites;


import android.view.MotionEvent;

import com.example.oyvin.zuiq.controllers.ConfigController;
import com.example.oyvin.zuiq.states.ConfigState;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class PosNegBtn extends Sprite implements TouchListener {
    float imageHeight, imageWidth;
    public String type;
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
                if (type.equals("addPlayer")){
                    ConfigController.getInstance().addNumberOfPlayers(1);
                }
                else if (type.equals("removePlayer")){
                    ConfigController.getInstance().addNumberOfPlayers(-1);
                }
                else if (type == "addSecond"){
                    ConfigController.getInstance().addNumberOfSeconds(1);
                }
                else if(type == "removeSecond"){
                    ConfigController.getInstance().addNumberOfSeconds(-1);
                }
                else if(type == "addQuestion"){
                    ConfigController.getInstance().addNumberOfQuestions(1);
                }
                else if (type == "removeQuestion"){
                    ConfigController.getInstance().addNumberOfQuestions(-1);
                }
                else if (type == "addScore"){
                    ConfigController.getInstance().addScoreLimit(1);
                }
                else if (type == "removeScore"){
                    ConfigController.getInstance().addScoreLimit(-1);

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
