package com.example.oyvin.zuiq;

import android.app.Activity;
import android.os.Bundle;

import sheep.game.Game;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the game.
        Game game = new Game(this, null);
        // Push the main state.
        //game.pushState(PauseState.getInstance());
        // View the game.
        setContentView(game);

    }

}
