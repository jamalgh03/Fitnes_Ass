package com.example.fitnes_ass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class FIt_Name_Screen extends AppCompatActivity {

    private double weight;
    private int age, time;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_name_screen);

        ListView listView = findViewById(R.id.listViewExercises);

        List<Exercise> exercises = Data.getExercises();

        Intent intent = getIntent();
        weight = intent.getDoubleExtra("weight", 0.0);
        age = intent.getIntExtra("age", 0);
        gender = intent.getStringExtra("gender");
        time = intent.getIntExtra("time", 0);

        MyAdapter adapter = new MyAdapter(this, exercises, exercise -> {
            Intent showDataIntent = new Intent(FIt_Name_Screen.this, ShowData.class);
            showDataIntent.putExtra("exerciseName", exercise.getName());
            showDataIntent.putExtra("weight", weight);
            showDataIntent.putExtra("age", age);
            showDataIntent.putExtra("gender", gender);
            showDataIntent.putExtra("time", time);
            startActivity(showDataIntent);
        });

        listView.setAdapter(adapter);
    }
}
