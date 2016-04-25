package com.example.oyvin.zuiq;

import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.models.Question;

import java.util.ArrayList;

public final class Game {

    private static ArrayList<Player> players;
    private static int maxPlayers;
    private static ArrayList<Question> questions;
    private static boolean questionnaire;
    private static int timeLimit;
    private static int maxPoints;
    private static int maxQuestions;

    private Game (){
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> newPlayers) {players = newPlayers;
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static void setMaxPlayers(int newMaxPlayers) {
        maxPlayers = newMaxPlayers;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(ArrayList<Question> newQuestions) {
        questions = newQuestions;
    }

    public static boolean isQuestionnaire() {
        return questionnaire;
    }

    public static void setQuestionnaire(boolean newQuestionnaire) {
        questionnaire = newQuestionnaire;
    }

    public static int getTimeLimit() {
        return timeLimit;
    }

    public static void  setTimeLimit(int newTimeLimit) {
        if (newTimeLimit > 0 && newTimeLimit <= 30)
            timeLimit = newTimeLimit;
    }

    public static int getMaxPoints() {
        return maxPoints;
    }

    public static void setMaxPoints(int newMaxPoints) {
        if (maxPoints >= 10 && maxPoints <= 100)
            maxPoints = newMaxPoints;
    }

    public static int getMaxQuestions() {
        return maxQuestions;
    }

    public static void setMaxQuestions(int newMaxQuestions) {
        maxQuestions = newMaxQuestions;
    }
}
