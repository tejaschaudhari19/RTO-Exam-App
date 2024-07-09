package com.example.rtoexam;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;
    private int imageResId;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this(questionText, options, correctAnswerIndex, -1); // Default to no image
    }

    public Question(String questionText, List<String> options, int correctAnswerIndex, int imageResId) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.imageResId = imageResId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean hasImage() {
        return imageResId != -1;
    }
}
