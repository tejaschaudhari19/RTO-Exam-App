package com.example.rtoexam;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;
    public DatabaseHelper(@Nullable Context context) {
        super(context, "RTOQuiz.db", null, 1);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Results(Id integer primary key autoincrement, Correct_Answers integer, Total_Questions integer)");
        db.execSQL("CREATE TABLE Questions(Ques_Id integer primary key autoincrement, Question text, Option_1 text, Option_2 text, Option_3 text, Option_4 text, Correct_Option integer, Image_Res_Id integer DEFAULT -1)");
        insertSampleQuestions(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertSampleQuestions(SQLiteDatabase db) {
        insertQuestion(db, "Q. While driving, avoid...",
                "Observing traffic rules", "Reacting to wrong behaviour of other drivers", "Observing the dashboard gauges", "Looking to the outer view mirrors", 1,-1);
        insertQuestion(db, "Q. The sign represents...",
                "Slippery road", "Traffic island ahead", "Falling Rocks", "Rough road", 2,R.drawable.fallingrocks);
        insertQuestion(db, "Q. A cyclist is signaling to turn right and drawn to center of the road, you should.",
                "Overtake through left side", "Sound horn continually", "Overtake through right side only", "Pass by nearly", 0,-1);
        insertQuestion(db, "Q. You should switch on your hazard warning lights...",
                "When you are moving straight", "When your vehicle is parked at roadside", "When your vehicle parked at a no parking zone", "When you want to attract people towards your vehicle", 1,-1);
        insertQuestion(db, "Q. While you reach a junction with limited visibility you should...",
                "Look at right and move slowly", "Move quickly", "Merge in between by disrupting other vehicles", "Look both ways and move carefully", 3,-1);
        insertQuestion(db, "Q. The sign represents...",
                "Stop", "No parking", "Hospital ahead", "Give Way", 0,R.drawable.stop);
        insertQuestion(db, "Q. The sign represents...",
                "U-turn prohibited", "Right turn prohibited", "Overtaking through right prohibited", "Left turn prohibited", 3,R.drawable.leftturnprohib);
        insertQuestion(db, "Q. When you approach a bridge you should...",
                "Slow down and do not overtake", "Beware of pedestrians", "Switch on the headlights", "Increase your speed to cross the bridge quickly", 0,-1);
        insertQuestion(db, "Q. When driving in foggy conditions, you should...",
                "Use high beam headlights", "Turn off headlights to avoid glare", "Use low beam headlights", "Drive with hazard lights on", 2,-1);
        insertQuestion(db, "Q. The sign represents...",
                "Restriction ends", "Stop", "No parking", "No stopping", 0,R.drawable.restrictionends);
        insertQuestion(db, "Q. When approaching a roundabout, you should...",
                "Honk to alert other drivers", "Always take the nearest exit", "Enter the roundabout without slowing down", "Yield to traffic already in the roundabout", 3,-1);
        insertQuestion(db, "Q. When parking uphill on a road with a curb, you should...",
                "Turn your front wheels towards the curb", "Turn your front wheels away from the curb", "Leave your wheels parallel to the curb", "Set the parking brake only", 1,-1);
        insertQuestion(db, "Q. Before taking an U-turn",
                "Select the neutral gear and the indicator", "Wait for signal to turn red", "Take vehicle to left side and make u-turn", "Show the right signal, watch in the rear view mirror", 3,-1);
        insertQuestion(db, "Q. The sign represents...",
                "Speed limit 2.5 km/hr", "No entry for vehicles having more than 2.5 meters width", "No entry for vehicles having more than 2.5 meters height", "None of the above", 1,R.drawable.widthlimit);
        insertQuestion(db, "Q. To safely navigate a sharp curve, you should...",
                "Brake hard in the middle of the curve", "Maintain your speed throughout the curve", "Reduce your speed before entering the curve", "Speed up to get through the curve faster", 2,-1);
    }

    private void insertQuestion(SQLiteDatabase db, String questionText, String option1, String option2, String option3, String option4, int correctOption, int imageResId) {
        ContentValues values = new ContentValues();
        values.put("Question", questionText);
        values.put("Option_1", option1);
        values.put("Option_2", option2);
        values.put("Option_3", option3);
        values.put("Option_4", option4);
        values.put("Correct_Option", correctOption);
        values.put("Image_Res_Id", imageResId);
        db.insert("Questions", null, values);
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Questions", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String questionText = cursor.getString(1);
                List<String> options = new ArrayList<>();
                options.add(cursor.getString(2));
                options.add(cursor.getString(3));
                options.add(cursor.getString(4));
                options.add(cursor.getString(5));
                int correctOption = cursor.getInt(6);
                int imageResId = cursor.getInt(7);
                questions.add(new Question(questionText, options, correctOption, imageResId));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return questions;
    }

    public void insertResult(int correctAnswers, int totalQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Correct_Answers", correctAnswers);
        values.put("Total_Questions", totalQuestions);
        db.insert("Results", null, values);
        db.close();
    }

    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Results", null, null, null, null, null, null);

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        int correctAnswers = cursor.getInt(cursor.getColumnIndexOrThrow("Correct_Answers"));
                        int totalQuestions = cursor.getInt(cursor.getColumnIndexOrThrow("Total_Questions"));
                        results.add(new Result(correctAnswers, totalQuestions));
                    } while (cursor.moveToNext());
                }
            } finally {
                cursor.close();
            }
        }
        return results;
    }
}
