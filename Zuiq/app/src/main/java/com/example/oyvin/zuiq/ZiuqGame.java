package com.example.oyvin.zuiq;

import com.example.oyvin.zuiq.helpers.FileOperations;
import com.example.oyvin.zuiq.models.Player;
import com.example.oyvin.zuiq.models.Question;

import java.util.ArrayList;
import java.util.Random;

public final class ZiuqGame {

    private static ArrayList<Player> players;
    private static int maxPlayers = 1;
    private static ArrayList<Question> questions;
    private static ArrayList<Question> selectedQuestions;
    private static boolean questionnaire;
    private static int timeLimit;
    private static int maxPoints = 10;
    private static int maxQuestions;
    private static int currentQuestionId = -1;

    private ZiuqGame(){
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
        if (newMaxPlayers > 0 && newMaxPlayers <= 5)
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
        if (newMaxPoints >= 10 && newMaxPoints <= 100)
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

    public static void selectQuestions(Random rand) {
        int questionLimit = questions.size();
        if (questionnaire)
            questionLimit = maxQuestions;
        ArrayList<Question> tmp = new ArrayList<>(questions);
        selectedQuestions = new ArrayList<>();
        for(int i = 0; i < questionLimit; i++) {
            selectedQuestions.add(tmp.remove(rand.nextInt(tmp.size())));
        }
    }

    public static boolean hasNextQuestion() {
        return currentQuestionId < maxQuestions;
    }

    public static Question nextQuestion() {
        currentQuestionId++;
        if (currentQuestionId < maxQuestions)
            return selectedQuestions.get(currentQuestionId);
        return null;
    }

    public static void resetGame() {
        players = new ArrayList<>();
        maxPlayers = 1;
        questions = new ArrayList<>();
        selectedQuestions = new ArrayList<>();
        questionnaire = false;
        timeLimit = 0;
        maxPoints = 10;
        maxQuestions = questions.size();
        currentQuestionId = -1;
    }

}
