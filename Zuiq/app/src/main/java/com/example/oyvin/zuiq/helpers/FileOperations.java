/*
package com.example.oyvin.zuiq.helpers;

import com.example.oyvin.zuiq.models.Answer;
import com.example.oyvin.zuiq.models.Question;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileOperations {

    private static final String QUESTION_DIRECTORY = "./data/questions/";

    public static ArrayList<Question> loadQuestions () {
        ArrayList<Question> result = new ArrayList<>();
        try {
            Files.walk(Paths.get(QUESTION_DIRECTORY)).forEach(filePath -> {
                if (!Files.isDirectory(filePath)) {
                    if (filePath.toString().toLowerCase().endsWith(".txt")) {
                        result.add(createQuestionFromFile(filePath.toFile(),
                                filePath.getParent().getFileName().toString()));
                        System.out.println("Loaded file: " + filePath);
                    }
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }


}*/