package com.example.fitnes_ass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowData extends AppCompatActivity {

    private TextView resultText;
    private Button back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        resultText = findViewById(R.id.resultText);

        Intent intent = getIntent();
        double weight = intent.getDoubleExtra("weight", 0);
        int age = intent.getIntExtra("age", 0);
        String gender = intent.getStringExtra("gender");
        int time = intent.getIntExtra("time", 0);
        String exerciseName = intent.getStringExtra("exerciseName");

        double caloriesBurned = calculateCaloriesBurned(exerciseName, weight, time, gender);

        String result = "Exercise: " + exerciseName + "\n"
                + "Weight: " + weight + " kg\n"
                + "Age: " + age + " years\n"
                + "Gender: " + gender + "\n"
                + "Time: " + time + " minutes\n"
                + "Calories Burned: " + String.format("%.2f", caloriesBurned) + " kcal";

        resultText.setText(result);

        back = findViewById(R.id.backButton);
        back.setOnClickListener(v -> {
            Intent backIntent = new Intent(ShowData.this, Data_Screen.class);
            backIntent.putExtra("data", "");
            startActivity(backIntent);
        });
    }

    private double calculateCaloriesBurned(String exerciseName, double weight, int time, String gender) {
        double metValue;

        switch (exerciseName) {
            case "Push":
                metValue = 8.0; // Example MET for push exercises
                break;
            case "Squat":
                metValue = 7.0; // Example MET for squats
                break;
            case "Pull-Up":
                metValue = 9.0; // Example MET for pull-ups
                break;
            case "Bench Press":
                metValue = 6.0; // Example MET for bench press
                break;
            case "Deadlift":
                metValue = 8.5; // Example MET for deadlift
                break;
            case "Lunges":
                metValue = 5.5; // Example MET for lunges
                break;
            case "Plank":
                metValue = 3.0; // Example MET for plank
                break;
            default:
                metValue = 5.0; // Default MET for other exercises
                break;
        }

        // Formula: Calories burned per minute = (MET * weight in kg * 3.5) / 200
        double caloriesBurnedPerMinute = (metValue * weight * 3.5) / 200;
        return caloriesBurnedPerMinute * time; // Total calories burned
    }


}
