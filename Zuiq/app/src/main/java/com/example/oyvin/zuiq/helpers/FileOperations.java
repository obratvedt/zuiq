
package com.example.oyvin.zuiq.helpers;

import android.content.res.AssetManager;

import com.example.oyvin.zuiq.models.Answer;
import com.example.oyvin.zuiq.models.Question;

import java.io.*;
import java.util.ArrayList;


public class FileOperations {

    private static final String QUESTION_DIRECTORY = "data/questions";

    public static ArrayList<Question> loadQuestions (AssetManager am) {
        ArrayList<Question> result = new ArrayList<>();
        try {
            String[] paths = am.list(QUESTION_DIRECTORY);
            if (paths.length > 0) { // This is a folder
                System.out.println("Found questions folder!");
                for (String path : paths) {
                    System.out.println("Found category '" + path + "'");
                    String[] files = am.list(QUESTION_DIRECTORY + "/" + path);
                    if (files.length > 0) { // Another folder
                        for (String filePath : files) {
                            InputStreamReader isr = new InputStreamReader(am.open(QUESTION_DIRECTORY + "/" + path + "/" + filePath));
                            result.add(createQuestionFromFile(isr, path));
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static Question createQuestionFromFile(InputStreamReader isr, String category) {
        try {
            BufferedReader br = new BufferedReader(isr);
            String question_text = br.readLine();
            String line;
            ArrayList<Answer> answers = new ArrayList<>();
            Answer rightAnswer = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("*")) {
                    rightAnswer = new Answer(line.substring(1));
                    answers.add(rightAnswer);
                } else
                    answers.add(new Answer(line));
            }
            return new Question(question_text, answers, rightAnswer, category);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}