package com.example.oyvin.zuiq.sprites;

import com.example.oyvin.zuiq.states.ConfigState;
import com.example.oyvin.zuiq.states.GameState;
import com.example.oyvin.zuiq.states.GameModeState;
import com.example.oyvin.zuiq.states.StartState;

import sheep.graphics.Image;

public class StartBtn extends Button {

    String state;

    public StartBtn(Image image, String state){
        super(image, 0.4f, 0.4f);
        this.state = state;
        //this.imageHeight = image.getHeight()/4; ???
        //this.imageWidth = image.getWidth()/4; ???
    }

    protected void onTouchDownSprite() {
        if (state.equals("config")) {
            StartState.getInstance().switchState(GameModeState.getInstance());
        }
        else if (state.equals("start")) {
            ConfigState.getInstance().switchState(GameState.getInstance());
        }
    }
}
