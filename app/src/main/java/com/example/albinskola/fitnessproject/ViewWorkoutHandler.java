package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewWorkoutHandler extends AppCompatActivity {

    private ListView fitnessList;
    private TextView tv;
    private CalendarView cv;

    DbConnecter db = new DbConnecter();
    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;
    List<Workout> nls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout_handler);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        //fitnessList = (ListView) findViewById(R.id.listView);
        tv = (TextView) findViewById(R.id.textView);
        fitnessList = (ListView) findViewById(R.id.listView);
        //cv = (CalendarView) findViewById(R.id.calendarView);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String userName = pref.getString("username", null);

                ArrayList<Workout> ls = new ArrayList<>();
                ls = db.getWorkOuts(userName);

                nls = Collections.synchronizedList(new ArrayList<Workout>());
                nls = ls;

            }
        });
        thread1.start();

        while (nls == null) {

        }
        if (nls != null) {
            thread1.interrupt();
            System.out.println(nls.get(0).getDate());

            String[] strTemp;
            strTemp = new String[nls.size()];

            for(int i = 0; i < nls.size(); i++){
                java.util.Date tempDate;
                tempDate = nls.get(i).getDate();

                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                String temp = formatter.format(tempDate);

                strTemp[i] = temp;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.listview,
                    strTemp);
            fitnessList.setAdapter(adapter);

            fitnessList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    long id1 = id;

                }
            });
        }


    }
}
