package com.example.fitnes_ass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private final List<String> exerciseNames;
    private final List<Integer> exerciseImages;
    private final OnExerciseClickListener listener;

    public MyAdapter(Context context, List<String> exerciseNames, List<Integer> exerciseImages, OnExerciseClickListener listener) {
        this.context = context;
        this.exerciseNames = exerciseNames;
        this.exerciseImages = exerciseImages;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return exerciseNames.size();
    }

    @Override
    public Object getItem(int position) {
        return exerciseNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.exerciseImage);
        TextView textView = convertView.findViewById(R.id.exerciseName);

        imageView.setImageResource(exerciseImages.get(position));
        textView.setText(exerciseNames.get(position));

        convertView.setOnClickListener(v -> listener.onExerciseClick(exerciseNames.get(position)));

        return convertView;
    }

    public interface OnExerciseClickListener {
        void onExerciseClick(String exerciseName);
    }
}
