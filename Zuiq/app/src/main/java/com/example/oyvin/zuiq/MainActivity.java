package com.example.oyvin.zuiq;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;

import com.example.oyvin.zuiq.helpers.FileOperations;
import com.example.oyvin.zuiq.states.StartState;

import java.io.IOException;

import sheep.game.Game;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the game.
        Game game = new Game(this, null);
        // Load all the questions
        AssetManager am = getAssets();
        ZiuqGame.setQuestions(FileOperations.loadQuestions(am));
        ZiuqGame.setContext(this);
        // Push the main state.
        game.pushState(StartState.getInstance());
        // View the game.
        setContentView(game);

    }

}
