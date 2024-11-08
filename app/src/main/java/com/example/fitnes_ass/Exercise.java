package com.example.fitnes_ass;

public class Exercise {
    private String name;
    private int imageResource;

    // Constructor
    public Exercise(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for image resource
    public int getImageResource() {
        return imageResource;
    }
    public interface OnExerciseClickListener {
        void onExerciseClick(Exercise exercise);
    }

}
