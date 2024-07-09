package com.example.rtoexam;

public class Result {
    private int correctAnswers;
    private int totalQuestions;

    public Result(int correctAnswers, int totalQuestions) {
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}
