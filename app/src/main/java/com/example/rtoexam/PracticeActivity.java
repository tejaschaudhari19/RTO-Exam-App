package com.example.rtoexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeActivity extends AppCompatActivity {
    Toolbar practoolbar;
    TextView questionTextView;
    ImageView questionImageView;
    CardView optionCard1, optionCard2, optionCard3, optionCard4;
    TextView optionText1, optionText2, optionText3, optionText4;
    Button previousButton, nextButton;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int selectedOptionIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        practoolbar = findViewById(R.id.practoolbar);
        setSupportActionBar(practoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        questionTextView = findViewById(R.id.question_text_view);
        questionImageView = findViewById(R.id.question_image);
        optionCard1 = findViewById(R.id.option_card_1);
        optionCard2 = findViewById(R.id.option_card_2);
        optionCard3 = findViewById(R.id.option_card_3);
        optionCard4 = findViewById(R.id.option_card_4);
        optionText1 = findViewById(R.id.option_text_1);
        optionText2 = findViewById(R.id.option_text_2);
        optionText3 = findViewById(R.id.option_text_3);
        optionText4 = findViewById(R.id.option_text_4);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);

        questions = getSampleQuestions();

        loadQuestion(currentQuestionIndex);

        optionCard1.setOnClickListener(v -> onOptionSelected(0));
        optionCard2.setOnClickListener(v -> onOptionSelected(1));
        optionCard3.setOnClickListener(v -> onOptionSelected(2));
        optionCard4.setOnClickListener(v -> onOptionSelected(3));

        previousButton.setOnClickListener(v -> {
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                loadQuestion(currentQuestionIndex);
            }
        });

        nextButton.setOnClickListener(v -> {
            if (currentQuestionIndex < questions.size() - 1) {
                currentQuestionIndex++;
                loadQuestion(currentQuestionIndex);
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

    private void loadQuestion(int index) {
        Question question = questions.get(index);
        questionTextView.setText(question.getQuestionText());
        if (question.hasImage()) {
            questionImageView.setImageResource(question.getImageResId());
            questionImageView.setVisibility(View.VISIBLE);
        } else {
            questionImageView.setVisibility(View.GONE);
        }
        optionText1.setText(question.getOptions().get(0));
        optionText2.setText(question.getOptions().get(1));
        optionText3.setText(question.getOptions().get(2));
        optionText4.setText(question.getOptions().get(3));

        resetOptionStyles();

        int selectedOption = question.getSelectedOptionIndex();
        if (selectedOption != -1) {
            highlightOptions(selectedOption);
        }
    }

    private void onOptionSelected(int index) {
        Question question = questions.get(currentQuestionIndex);
        question.setSelectedOptionIndex(index);
        highlightOptions(index);
    }

    private void highlightOptions(int selectedOptionIndex) {
        Question question = questions.get(currentQuestionIndex);
        CardView selectedOptionCard = getOptionCard(selectedOptionIndex);
        TextView selectedOptionText = getOptionText(selectedOptionIndex);

        if (selectedOptionIndex == question.getCorrectOptionIndex()) {
            selectedOptionCard.setCardBackgroundColor(Color.GREEN);
            selectedOptionText.setTextColor(Color.WHITE);
        } else {
            selectedOptionCard.setCardBackgroundColor(Color.RED);
            selectedOptionText.setTextColor(Color.WHITE);
            CardView correctOptionCard = getOptionCard(question.getCorrectOptionIndex());
            TextView correctOptionText = getOptionText(question.getCorrectOptionIndex());
            correctOptionCard.setCardBackgroundColor(Color.GREEN);
            correctOptionText.setTextColor(Color.WHITE);
        }
    }

    private void resetOptionStyles() {
        optionCard1.setCardBackgroundColor(Color.WHITE);
        optionText1.setTextColor(Color.BLACK);
        optionCard2.setCardBackgroundColor(Color.WHITE);
        optionText2.setTextColor(Color.BLACK);
        optionCard3.setCardBackgroundColor(Color.WHITE);
        optionText3.setTextColor(Color.BLACK);
        optionCard4.setCardBackgroundColor(Color.WHITE);
        optionText4.setTextColor(Color.BLACK);
    }

    private CardView getOptionCard(int index) {
        switch (index) {
            case 0:
                return optionCard1;
            case 1:
                return optionCard2;
            case 2:
                return optionCard3;
            case 3:
                return optionCard4;
            default:
                return null;
        }
    }

    private TextView getOptionText(int index) {
        switch (index) {
            case 0:
                return optionText1;
            case 1:
                return optionText2;
            case 2:
                return optionText3;
            case 3:
                return optionText4;
            default:
                return null;
        }
    }

    private List<Question> getSampleQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q. The mandatory signs giving orders are mostly in...",
                Arrays.asList("1. Red/Blue circles", "2. Red Triangles", "3. Base triangles", "4. Square shapes"), 0));
        questions.add(new Question("Q. At an intersection, what should you do when you see a yield sign?",
                Arrays.asList("1. Stop completely", "2. Slow down and give way", "3. Speed up", "4. Ignore it"), 1));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Stop", "2. Slow", "3. No Parking", "4. Give Way"), 2,R.drawable.noparking));
        questions.add(new Question("Q. Motor cyclists usually cause hazard by...",
                Arrays.asList("1. Passing very close to you by driving in the zigzag manner", "2. Speed more than permitted", "3. Riding in the middle of road", "4. All of the above"), 3));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. No entry for motor vehicles", "2. No entry for cars and motorcycles", "3. Entry allowed for cars and motor vehicles", "4. No entry for cars and bicycles"), 1,R.drawable.noentryforcnm));
        questions.add(new Question("Q. While you reach a junction with limited visibility you should...",
                Arrays.asList("1. Look both ways and move carefully", "2. Look at right and move slowly", "3. Move quickly", "4. Move slowly"), 0));
        questions.add(new Question("Q. What is the minimum age requirement to obtain a learner's driving license?",
                Arrays.asList("1. 16 years", "2. 19 years", "3. 18 years", "4. 21 years"), 2));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Give Way", "2. Hospital Ahead", "3. Traffic Island ahead", "4. Two Way"), 0,R.drawable.giveway));
        questions.add(new Question("Q. When should you use your vehicle's horn?",
                Arrays.asList("1. Continuously in a traffic jam", "2. To greet a friend", "3. To alert other drivers when overtaking", "4. To scare pedestrians"), 2));
        questions.add(new Question("Q. What does a double solid white line in the center of the road mean?",
                Arrays.asList("1. Speed up to clear the crossing quickly", "2. Honk to alert pedestrians of your presence", "3. Ignore the crossing if there are no pedestrians", "4. Slow down and prepare to stop if pedestrians are crossing"), 3));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Cycle prohibited", "2. Horse cart prohibited", "3. Bullock cart prohibited", "4. All vehicles prohibited"), 2,R.drawable.bullockcartprohib));
        questions.add(new Question("Q. What is the legal blood alcohol concentration (BAC) limit for drivers?",
                Arrays.asList("1. 0.08%", "2. 0.1%", "3. 0.05%", "4. 0.0%"), 0));
        questions.add(new Question("Q. How often should you check your rearview and side mirrors while driving?",
                Arrays.asList("1. Every 30 seconds", "2. Every 5-8 seconds", "3. Once every 5 minutes", "4. Only when changing lanes"), 1));
        questions.add(new Question("Q. What should you do if you approach a red traffic light?",
                Arrays.asList("1. Proceed with caution if there is no traffic", "2. Stop completely", "3. Speed up to cross before it turns green", "4. Sound your horn and proceed"), 1));
        questions.add(new Question("Q. What does a flashing yellow traffic light mean?",
                Arrays.asList("1. Stop and wait for the light to change", "2. Yield to oncoming traffic", "3. Accelerate to pass quickly", "4. Proceed with caution"), 3));
        questions.add(new Question("Q. When is it permissible to use a mobile phone while driving?",
                Arrays.asList("1. Only with a hands-free device", "2. When stopped at a red light", "3. When driving at low speeds", "4. It is never permissible"), 0));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Overtaking prohibited through the right side", "2. Turn left", "3. Left turn prohibited", "4. Right turn prohibited"), 2,R.drawable.leftturnprohib));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Right turn prohibited", "2. Sharp curve to the right", "3. One way", "4. U-turn prohibited"), 3,R.drawable.nouturn));
        questions.add(new Question("Q. What is the recommended hand position on the steering wheel?",
                Arrays.asList("1. 10 and 2 o'clock", "2. 9 and 3 o'clock", "3. 12 and 6 o'clock", "4. 8 and 4 o'clock"), 1));
        questions.add(new Question("Q. What should you do if your vehicle starts to hydroplane?",
                Arrays.asList("1. Speed up to regain control", "2. Steer sharply to correct the direction", "3. Ease off the accelerator and steer straight", "4. Apply the brakes firmly"), 2));
        questions.add(new Question("Q. What does a yellow diamond-shaped sign typically indicate?",
                Arrays.asList("1. A regulatory instruction", "2. A construction zone", "3. An informational message", "4. A warning of upcoming hazards or changes in road conditions"), 3));
        questions.add(new Question("Q. What should you do if an emergency vehicle is approaching with flashing lights and sirens?",
                Arrays.asList("1. Speed up to get out of the way", "2. Pull over to the right and stop", "3. Continue driving at the same speed", "4. Ignore it and proceed"), 1));
        questions.add(new Question("Q. When parking uphill on a two-way street with no curb, in which direction should you turn your front wheels?",
                Arrays.asList("1. Towards the curb", "2. Away from the curb", "3. Towards the street", "4. Straight ahead"), 3));
        questions.add(new Question("Q. How should you react to a “Yield” sign?",
                Arrays.asList("1. Slow down and be prepared to stop if necessary", "2. Stop completely and then proceed", "3. Accelerate to merge quickly", "4. Ignore it and continue at the same speed"), 0));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Speed limit 2.5 km/hr", "2. No entry for vehicles having more than 2.5 meters width", "3. No entry for vehicles having more than 2.5 meters height", "4. None of the above"), 1,R.drawable.widthlimit));
        questions.add(new Question("Q. What is the safe following distance in normal driving conditions?",
                Arrays.asList("1. One second behind the vehicle in front", "2. Two seconds behind the vehicle in front", "3. Three seconds behind the vehicle in front", "4. Five seconds behind the vehicle in front"), 2));
        questions.add(new Question("Q. When is it acceptable to drive on the shoulder of the road?",
                Arrays.asList("1. When overtaking", "2. In heavy traffic", "3. Never", "4. In an emergency"), 3));
        questions.add(new Question("Q. What is the main purpose of anti-lock braking systems (ABS)?",
                Arrays.asList("1. To increase speed", "2. To prevent wheel lockup during braking", "3. To reduce fuel consumption", "4. To improve tire wear"), 1));
        questions.add(new Question("Q. What does a solid yellow line on your side of the road mean?",
                Arrays.asList("1. Passing is not allowed", "2. You may pass if there is no oncoming traffic", "3. You may pass at any time", "4. Passing is allowed during the day only"), 0));
        questions.add(new Question("Q. This sign represents...",
                Arrays.asList("1. Drive the vehicle at 50 km/hr", "2. Drive the vehicle exceeding 50 km/hr", "3. Drive the vehicle not exceeding 50 km/hr", "4. Load limit"), 2,R.drawable.maxspeedlimit));

        return questions;
    }

    private static class Question {
        private final String questionText;
        private final List<String> options;
        private final int correctOptionIndex;
        private int selectedOptionIndex = -1;
        private int imageResId = -1;

        public Question(String questionText, List<String> options, int correctOptionIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
        }

        public Question(String questionText, List<String> options, int correctOptionIndex, int imageResId) {
            this.questionText = questionText;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
            this.imageResId = imageResId;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<String> getOptions() {
            return options;
        }

        public int getCorrectOptionIndex() {
            return correctOptionIndex;
        }

        public int getSelectedOptionIndex() {
            return selectedOptionIndex;
        }

        public void setSelectedOptionIndex(int selectedOptionIndex) {
            this.selectedOptionIndex = selectedOptionIndex;
        }

        public boolean hasImage() {
            return imageResId != -1;
        }

        public int getImageResId() {
            return imageResId;
        }
    }
}