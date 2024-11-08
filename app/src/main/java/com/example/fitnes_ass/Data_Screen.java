package com.example.fitnes_ass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Data_Screen extends AppCompatActivity {
    private Button selectExercise;
    private EditText weightInput, ageInput;
    private RadioGroup genderGroup;
    private Spinner timeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_screen);

        selectExercise = findViewById(R.id.selectExercise);
        weightInput = findViewById(R.id.weight);
        ageInput = findViewById(R.id.age);
        genderGroup = findViewById(R.id.Gender);
        timeSpinner = findViewById(R.id.Time);

        List<String> timeOptions = new ArrayList<>();
        for (int i = 5; i <= 60; i += 5) {
            timeOptions.add(String.valueOf(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(adapter);

        selectExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightInput.getText().toString();
                String ageStr = ageInput.getText().toString();
                int selectedGenderId = genderGroup.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedGenderId);

                if (weightStr.isEmpty() || ageStr.isEmpty() || selectedGenderId == -1) {
                    Toast.makeText(Data_Screen.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double weight = Double.parseDouble(weightStr);
                int age = Integer.parseInt(ageStr);
                String gender = selectedGender.getText().toString();
                int time = Integer.parseInt(timeSpinner.getSelectedItem().toString());

                Intent intent = new Intent(Data_Screen.this, FIt_Name_Screen.class);
                intent.putExtra("weight", weight);
                intent.putExtra("age", age);
                intent.putExtra("gender", gender);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });
    }
}
