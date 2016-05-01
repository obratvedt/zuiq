package com.example.oyvin.zuiq;

import android.content.Context;

import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.models.Question;
import com.example.oyvin.zuiq.states.GameState;
import com.example.oyvin.zuiq.states.StartState;

import java.util.ArrayList;
import java.util.Random;

/**
 * A fully static class, containing all the central variables and functions for our game.
 */
public final class ZiuqGame {

    private static ArrayList<Player> players;
    private static int maxPlayers = 1;
    private static ArrayList<Question> questions;
    private static ArrayList<Question> selectedQuestions;
    private static boolean questionnaire;
    private static int timeLimit = 10;
    private static int maxPoints = 10;
    private static int maxQuestions = 1;
    private static int currentQuestionId = -1;
    private static Context context;


    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> newPlayers) {players = newPlayers;
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Set the number of players that are participating in a game
     * @param newMaxPlayers
     */
    public static void setMaxPlayers(int newMaxPlayers) {
        if (newMaxPlayers > 0 && newMaxPlayers <= 5)
            maxPlayers = newMaxPlayers;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Set all the questions for the game
     * @param newQuestions
     */
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
        if (newTimeLimit >= 0 && newTimeLimit <= 30)
            timeLimit = newTimeLimit;
    }

    public static int getMaxPoints() {
        return maxPoints;
    }

    public static void setMaxPoints(int newMaxPoints) {
        if (newMaxPoints >= 10 && newMaxPoints <= (questions.size() * 50))
            maxPoints = newMaxPoints;
    }

    public static void addMaxPoints(int add) {
        setMaxPoints(maxPoints + add);
    }

    public static int getMaxQuestions() {
        return maxQuestions;
    }

    public static void setMaxQuestions(int newMaxQuestions) {
        if (newMaxQuestions <= questions.size() && newMaxQuestions > 0)
            maxQuestions = newMaxQuestions;
    }

    public static ArrayList<Question> getSelectedQuestions() {
        return selectedQuestions;
    }

    /**
     * Fills the selectedQuestions ArrayList with random questions
     * @param rand
     */
    public static void selectQuestions(Random rand) {
        int questionLimit = questions.size();
        if (questionnaire) // If the game mode is questionnaire, the question limit is based on the max questions selected by the user(s)
            questionLimit = maxQuestions;
        ArrayList<Question> tmp = new ArrayList<>(questions); // Creating a temporary ArrayList from which we can remove
        selectedQuestions = new ArrayList<>();
        for(int i = 0; i < questionLimit; i++) {
            selectedQuestions.add(tmp.remove(rand.nextInt(tmp.size())));
        }
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context newContext) {
        context = newContext;
    }

    /**
     * Does the game have another question to display
     * @return
     */
    public static boolean hasNextQuestion() {
        return currentQuestionId < maxQuestions;
    }

    /**
     * Provide the next question from the selectedQuestions ArrayList
     * @return
     */
    public static Question nextQuestion() {
        currentQuestionId++;
        if (currentQuestionId < selectedQuestions.size())
            return selectedQuestions.get(currentQuestionId);
        return null;
    }

    /**
     * Resets all the variables, except for the context (retrieved in the MainActivity class)
     * and the questions ArrayList with the total collection of questions.
     * Then switches to the StartState.
     */
    public static void resetGame() {
        players = new ArrayList<>();
        maxPlayers = 1;
        selectedQuestions = new ArrayList<>();
        questionnaire = false;
        timeLimit = 10;
        maxPoints = 10;
        maxQuestions = questions.size();
        currentQuestionId = -1;

        GameState.getInstance().setState("stop");
        GameState.getInstance().getController().timesUp();
        StartState.getInstance().switchState(StartState.getInstance());

    }
}
