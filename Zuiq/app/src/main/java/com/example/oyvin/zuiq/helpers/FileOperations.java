/*package com.example.oyvin.zuiq.helpers;

public class FileOperations {

    private static final String QUESTION_DIRECTORY = "./data/questions/";

    public static ArrayList<Question> loadQuestions () {
        ArrayList<Question> result = new ArrayList<>();
        try {
            Files.walk(Paths.get(QUESTION_DIRECTORY)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println("Loaded file: " + filePath);
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}*/
