package com.example.oyvin.zuiq.models;

import java.util.ArrayList;
import java.util.Random;

public class Question {

    public static int NUMBER_OF_QUESTIONS = 0;

    private int id;
    private String text;
    private String category;
    private ArrayList<Answer> answers;
    private Answer rightAnswer;

    public Question(String text, ArrayList<Answer> answers, Answer rightAnswer, String category) {
        this.id = ++NUMBER_OF_QUESTIONS;
        this.text = text;
        this.category = category;
        randomizeAnswers(answers, new Random());
        this.rightAnswer = rightAnswer;
    }

    private void randomizeAnswers(ArrayList<Answer> answrs, Random rand) {
        answers = new ArrayList<>();
        for(int i = 0; i < answers.size(); i++) {
            answers.add(answrs.remove(rand.nextInt(answrs.size())));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Answer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return String.format("#%s %s {%s} Correct: [%s]", this.id, this.text, this.answers.size(), this.rightAnswer);
    }

}
