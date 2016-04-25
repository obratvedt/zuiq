package com.example.oyvin.zuiq.models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int maxPlayers;
    private ArrayList<Question> questions;
    private boolean questionnaire;
    private int timeLimit;
    private int maxPoints;
    private int maxQuestions;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public boolean isQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(boolean questionnaire) {
        this.questionnaire = questionnaire;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        if (maxPoints >= 10 && maxPoints <= 100)
            this.maxPoints = maxPoints;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }
}
