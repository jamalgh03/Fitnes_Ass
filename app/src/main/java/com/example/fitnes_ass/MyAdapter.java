package com.example.fitnes_ass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import android.widget.ArrayAdapter;

import com.example.fitnes_ass.Exercise;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Exercise> {

    private final List<Exercise> exercises;
    private final OnExerciseClickListener onExerciseClickListener;

    public MyAdapter(Context context, List<Exercise> exercises, OnExerciseClickListener onExerciseClickListener) {
        super(context, 0, exercises);
        this.exercises = exercises;
        this.onExerciseClickListener = onExerciseClickListener;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Exercise exercise = exercises.get(position);

        TextView nameTextView = convertView.findViewById(R.id.exerciseName);
        ImageView imageView = convertView.findViewById(R.id.exerciseImage);

        nameTextView.setText(exercise.getName());
        imageView.setImageResource(exercise.getImageResource());

        convertView.setOnClickListener(v -> onExerciseClickListener.onExerciseClick(exercise));

        return convertView;
    }

    public interface OnExerciseClickListener {
        void onExerciseClick(Exercise exercise);
    }
}
