package com.example.oyvin.zuiq.sprites;

import sheep.graphics.Image;

public class AnswerBtn extends Button {

    private String correct;

    public AnswerBtn(Image image, String correct){
        super(image, 0.5f, 0.5f);
        this.correct = correct;
    }

    public String getCorrect() {
        return correct;
    }

}
