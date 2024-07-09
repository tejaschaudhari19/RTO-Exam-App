package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestionActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    Toolbar examqstoolbar;
    TextView questionTextView;
    ImageView questionImage;
    RadioGroup optionsRadioGroup;
    Button nextQuestionButton;
    TextView timerTextView;
    TextView questionCounterTextView;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private CountDownTimer countDownTimer;
    private boolean examEnded = false;  // Flag to check if exam has ended

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_question);
        databaseHelper = new DatabaseHelper(ExamQuestionActivity.this);
        Toast.makeText(this, "Exam Started", Toast.LENGTH_SHORT).show();
        examqstoolbar = findViewById(R.id.examqstoolbar);
        setSupportActionBar(examqstoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        questionTextView = findViewById(R.id.questionTextView);
        questionImage = findViewById(R.id.questionImage);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        timerTextView = findViewById(R.id.timerTextView);
        questionCounterTextView = findViewById(R.id.questionCounterTextView);

        questions = getSampleQuestions();
        showNextQuestion();

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionsRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(ExamQuestionActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    checkAnswer();
                    if (currentQuestionIndex < questions.size() - 1) {
                        currentQuestionIndex++;
                        showNextQuestion();
                        optionsRadioGroup.clearCheck();
                    } else {
                        endExam();
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void showNextQuestion() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Question question = questions.get(currentQuestionIndex);
        questionTextView.setText(question.getQuestionText());
        questionCounterTextView.setText((currentQuestionIndex + 1) + "/15");

        optionsRadioGroup.removeAllViews();
        for (int i = 0; i < question.getOptions().size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setText(question.getOptions().get(i));
            optionsRadioGroup.addView(radioButton);
        }
        // Clear the previous selection if any
        optionsRadioGroup.clearCheck();

        if (question.getImageResId() != -1) {
            questionImage.setVisibility(View.VISIBLE);
            questionImage.setImageResource(question.getImageResId());
        } else {
            questionImage.setVisibility(View.GONE);
        }

        if (currentQuestionIndex == questions.size() - 1) {
            nextQuestionButton.setText("Submit");
        } else {
            nextQuestionButton.setText("Next Question >");
        }

        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                checkAnswer();
                if (currentQuestionIndex < questions.size() - 1) {
                    currentQuestionIndex++;
                    showNextQuestion();
                } else {
                    endExam();
                }
            }
        }.start();
    }

    private void checkAnswer() {
        int selectedId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            int answerIndex = questions.get(currentQuestionIndex).getCorrectAnswerIndex();
            if (selectedId == answerIndex) {
                correctAnswers++;
            }
        }
    }

    private void endExam() {
        if (examEnded) return;  // Check if the exam has already ended
        examEnded = true;  // Set the flag to true to indicate the exam has ended
        saveResultToDatabase();
        Intent intent = new Intent(this, ExamResultActivity.class);
        intent.putExtra("correctAnswers", correctAnswers);
        intent.putExtra("totalQuestions", questions.size());
        startActivity(intent);
        finish();
    }

    private void saveResultToDatabase() {
        DatabaseHelper databaseHelper = new DatabaseHelper(ExamQuestionActivity.this);
        databaseHelper.insertResult(correctAnswers, questions.size());
    }

    private List<Question> getSampleQuestions() {
        DatabaseHelper databaseHelper = new DatabaseHelper(ExamQuestionActivity.this);
        return databaseHelper.getQuestions();
    }

}