package com.example.oyvin.zuiq.sprites;

import sheep.game.Sprite;
import sheep.graphics.Image;

public class Background extends Sprite {

    float imageWidth, imageHeight;

    public Background (Image image){
        super(image);
        this.imageHeight = image.getHeight();
        this.imageWidth = image.getWidth();
    }

    public float getImageWidth() {
        return imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
    }
}
