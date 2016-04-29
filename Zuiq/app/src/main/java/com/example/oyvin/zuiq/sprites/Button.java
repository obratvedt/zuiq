package com.example.oyvin.zuiq.sprites;

import android.view.MotionEvent;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.input.TouchListener;

/**
 * Abstract class which each button class inherits from. Contains the minimum logic to create a working button
 */
public abstract class Button extends Sprite implements TouchListener {

    private float imageHeight,imageWidth;

    public float getImageWidth() {
        return imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
    }

    /**
     * Constructs the Sprite class with an Image instance.
     * Sets the proper dimensions of the image and scales the sprite
     * @param image
     * @param scaleX
     * @param scaleY
     */
    public Button(Image image, float scaleX, float scaleY) {
        super(image);
        imageHeight = image.getHeight() * scaleY;
        imageWidth = image.getWidth() * scaleX;
        setScale(scaleX, scaleY);
    }

    /**
     * Whenever the screen is touched
     * Overridden from the TouchListener class
     * @param motionEvent
     * @return
     */
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

    /**
     * Abstract method where the logic for when the button is pressed, should live
     * Abstraction is used because each button will likely execute different code when pressed
     */
    protected abstract void onTouchDownSprite();

    @Override
    public boolean onTouchUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent motionEvent) {
        return false;
    }

    /**
     * Check to see if the location of the touch is within the button/sprite's (image) boundaries
     * @param xPos
     * @param yPos
     * @return
     */
    protected boolean touchOnSprite(float xPos, float yPos) {
        if (xPos >= getX() - (imageWidth / 2) && xPos <= getX() + (imageWidth / 2)) {
            if (yPos >= getY() - (imageHeight / 2) && yPos <= getY() + (imageHeight / 2)) {
                return true;
            }
        }
        return false;
    }

}
