package com.example.fitnes_ass;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Exercise> getExercises() {
        return Arrays.asList(
                new Exercise("Push", R.drawable.push),
                new Exercise("Squat", R.drawable.squat),
                new Exercise("Pull-Up", R.drawable.pullup),
                new Exercise("Bench Press", R.drawable.benchpress),
                new Exercise("Deadlift", R.drawable.tricep),
                new Exercise("Lunges", R.drawable.russiantwist),
                new Exercise("Plank", R.drawable.plank)
        );
    }
}
