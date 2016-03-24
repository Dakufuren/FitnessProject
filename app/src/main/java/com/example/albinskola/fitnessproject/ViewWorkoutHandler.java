package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewWorkoutHandler extends AppCompatActivity {

    private ListView fitnessList;
    private TextView tv;
    private CalendarView cv;
    DbConnecter db = new DbConnecter();
    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout_handler);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        //fitnessList = (ListView) findViewById(R.id.listView);
        tv = (TextView) findViewById(R.id.textView);
        //cv = (CalendarView) findViewById(R.id.calendarView);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String userName = pref.getString("username", null);

                ArrayList<Workout> ls = new ArrayList<>();
                ls = db.getWorkOuts(userName);
                System.out.println(ls.toString());
                System.out.println(ls.get(0).getBiceps());
                System.out.println(ls.get(1).getBiceps());



                //tv.setText();
            }
        });
        thread1.start();
    }
}
