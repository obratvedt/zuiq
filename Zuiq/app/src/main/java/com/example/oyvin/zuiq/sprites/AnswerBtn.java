package com.example.oyvin.zuiq.sprites;

import com.example.oyvin.zuiq.states.GameState;

import sheep.graphics.Image;

public class AnswerBtn extends Button {

    private String correct;
    private String text = "";

    public AnswerBtn(Image image, String correct){
        super(image, 0.5f, 0.5f);
        this.correct = correct;

    }


    protected void onTouchDownSprite() {
        GameState.getInstance().controller.isCorrect(correct);

    }

    public String getCorrect() {
        return correct;
    }

    public String getText () {
        return text;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setText (String text) {
        this.text = text;
    }

}
