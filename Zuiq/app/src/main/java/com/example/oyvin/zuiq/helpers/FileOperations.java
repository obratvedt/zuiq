
package com.example.oyvin.zuiq.helpers;

import com.example.oyvin.zuiq.models.Answer;
import com.example.oyvin.zuiq.models.Question;

import java.io.*;
import java.util.ArrayList;


public class FileOperations {

    private static final String QUESTION_DIRECTORY = "./data/questions/";

    public static ArrayList<Question> loadQuestions () {
        ArrayList<Question> result = new ArrayList<>();
        File rootFolder = new File(QUESTION_DIRECTORY);
        for (File folder : rootFolder.listFiles()) {
            if (folder.isDirectory()) {
                for (File question_file : folder.listFiles()) {
                    if (!question_file.isDirectory())
                        result.add(createQuestionFromFile(question_file, folder.getName()));
                }
            }
        }
        return result;
    }

    private static Question createQuestionFromFile(File file, String category) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
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

    public static void main (String[] args) {
        System.out.println(FileOperations.loadQuestions());
    }

}