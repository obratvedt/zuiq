package com.example.oyvin.zuiq.sprites;

import sheep.game.Game;
import sheep.graphics.Image;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.oyvin.zuiq.ZiuqGame;
import com.example.oyvin.zuiq.states.BackgroundState;
import com.example.oyvin.zuiq.states.ConfigState;
import com.example.oyvin.zuiq.states.GameModeState;
import com.example.oyvin.zuiq.states.GameState;
import com.example.oyvin.zuiq.states.StartState;

public class CancelBtn extends Button {

    public CancelBtn(Image image) {
        super(image, 0.33f, 0.33f);
    }

    @Override
    protected void onTouchDownSprite() {
        new AlertDialog.Builder(ZiuqGame.getContext())
                .setTitle("Cancel game")
                .setMessage("Are you sure you want to cancel this game? This cannot be undone")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with cancellation
                        GameState.getInstance().controller.timesUp();
                        ZiuqGame.resetGame();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
