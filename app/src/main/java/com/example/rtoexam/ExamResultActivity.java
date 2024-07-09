package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExamResultActivity extends AppCompatActivity {
    Toolbar examrstoolbar;
    TextView resultTextView, resultstmtTextView, scoreTextView;
    Button homeButton, scorecardButton, tryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);
        examrstoolbar=findViewById(R.id.examrstoolbar);
        setSupportActionBar(examrstoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultTextView = findViewById(R.id.resultTextView);
        resultstmtTextView = findViewById(R.id.resultstmtTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        homeButton = findViewById(R.id.homeButton);
        scorecardButton = findViewById(R.id.scorecardButton);
        tryAgainButton = findViewById(R.id.tryAgainButton);

        int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestions", 15);

        resultTextView.setText(correctAnswers >= 9 ? "Passed! \uD83E\uDD73" : "Failed! ☹\uFE0F");
        resultstmtTextView.setText(correctAnswers >= 9 ? "Congratulations! You've just cleared driving licence test. Practice more to increase your success chances in actual test." : "Sorry, you have failed in driving licence test. We would suggest you to refer question bank and try again.");
        scoreTextView.setText("You answered " + correctAnswers + " out of " + totalQuestions + " correctly.");

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamResultActivity.this, OptionsActivity.class));
                finish();
            }
        });

        scorecardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamResultActivity.this, ScorecardActivity.class));
                finish();
            }
        });

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExamResultActivity.this, ExamActivity.class));
                finish();
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
}