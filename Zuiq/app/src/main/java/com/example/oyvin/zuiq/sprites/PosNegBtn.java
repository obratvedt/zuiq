package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import com.example.oyvin.zuiq.controllers.ConfigController;
import com.example.oyvin.zuiq.states.ConfigState;

import sheep.graphics.Image;

public class PosNegBtn extends Button {

    private String type;

    public PosNegBtn(Image image, String type){
        super(image, 0.1f, 0.2f);
        this.type=type;
    }

    @Override
    protected void onTouchDownSprite() {
        if (type.equals("addPlayer")){
            ConfigController.getInstance().addNumberOfPlayers(1);
        }
        else if (type.equals("removePlayer")){
            ConfigController.getInstance().addNumberOfPlayers(-1);
        }
        else if (type.equals("addSecond")){
            ConfigController.getInstance().addNumberOfSeconds(1);
        }
        else if(type.equals("removeSecond")){
            ConfigController.getInstance().addNumberOfSeconds(-1);
        }
        else if(type.equals("addQuestion")){
            ConfigController.getInstance().addNumberOfQuestions(1);
        }
        else if (type.equals("removeQuestion")){
            ConfigController.getInstance().addNumberOfQuestions(-1);
        }
        else if (type.equals("addScore")){
            ConfigController.getInstance().addScoreLimit(50);
        }
        else if (type.equals("removeScore")){
            ConfigController.getInstance().addScoreLimit(-50);
        }
    }

}
