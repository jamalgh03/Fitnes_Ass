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

        String result = "Weight: " + weight + " kg\n"
                + "Age: " + age + " years\n"
                + "Gender: " + gender + "\n"
                + "Time: " + time + " minutes";

        resultText.setText(result);

        back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowData.this , Data_Screen.class);
                intent.putExtra("data","");
                startActivity(intent);
            }
        });
    }


}
