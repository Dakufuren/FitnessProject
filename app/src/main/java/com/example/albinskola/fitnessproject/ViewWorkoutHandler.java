package com.example.albinskola.fitnessproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ViewWorkoutHandler extends AppCompatActivity {

    private ListView fitnessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout_handler);

        fitnessList = (ListView) findViewById(R.id.listView);

    }
}
