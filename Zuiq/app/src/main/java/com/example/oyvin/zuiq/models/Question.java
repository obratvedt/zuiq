package com.example.oyvin.zuiq.models;

import java.util.ArrayList;
import java.util.Random;

public class Question {

    public static int NUMBER_OF_QUESTIONS = 0;

    private int id;
    private String text;
    private ArrayList<Answer> answers;
    private Answer rightAnswer;

    public Question(String text, ArrayList<Answer> answers, Answer rightAnswer) {
        this.id = ++NUMBER_OF_QUESTIONS;
        this.text = text;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public ArrayList<Answer> getRandomizedAnswers(Random rand) {
        ArrayList<Answer> result = new ArrayList<>();
        ArrayList<Answer> tmp = new ArrayList<>(answers);
        for(int i = 0; i < answers.size(); i++) {
            result.add(tmp.remove(rand.nextInt(answers.size())));
        }
        return result;
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

}
