package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScorecardActivity extends AppCompatActivity {
    Toolbar examsctoolbar;
    ListView scoreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);
        examsctoolbar=findViewById(R.id.examsctoolbar);
        setSupportActionBar(examsctoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        scoreListView = findViewById(R.id.score_list_view);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<Map<String, String>> scoreData = new ArrayList<>();
        for (Result result : databaseHelper.getResults()) {
            Map<String, String> datum = new HashMap<>(2);
            datum.put("correctAnswers", "No of Correct Answers: " + result.getCorrectAnswers());
            datum.put("totalQuestions", "No of Total Questions: " + result.getTotalQuestions());
            scoreData.add(datum);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, scoreData,
                android.R.layout.simple_list_item_2,
                new String[]{"correctAnswers", "totalQuestions"},
                new int[]{android.R.id.text1, android.R.id.text2});

        scoreListView.setAdapter(adapter);

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