package com.example.oyvin.zuiq.states;


import sheep.game.State;

public class StartState extends State {
    private static StartState startState = null;

    private StartState(){

    }

    public static StartState getinstance(){
        if(startState == null){
            startState = new StartState();
        }
        return startState;
    }
    
}
