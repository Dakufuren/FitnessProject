package com.example.albinskola.fitnessproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainMenuHandler extends AppCompatActivity {

    DbConnecter db = new DbConnecter();
    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;
    List<WorkoutObject> nls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_handler);

    }

    public void onClickAdd(View v){
        System.out.println("Add Clicked!!!");
        Intent intent = new Intent(MainMenuHandler.this, AddWorkoutHandler.class);
        startActivity(intent);
    }

    public void onClickView(View v){

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String userName = pref.getString("username", null);

                ArrayList<WorkoutObject> ls = new ArrayList<>();
                ls = db.getWorkOuts(userName);

                nls = Collections.synchronizedList(new ArrayList<WorkoutObject>());
                nls = ls;
            }
        });
        thread1.start();

        while (nls == null) {

        }

        if(nls.size() >= 1) {
            System.out.println("View Clicked!!!");
            Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
            startActivity(intent);
        }

        else{
            Context context = getApplicationContext();
            CharSequence text = "No training session to show!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void onClickProfile(View v){
        System.out.println("Profile Clicked!!!");
        Intent intent = new Intent(MainMenuHandler.this, ProfileHandler.class);
        startActivity(intent);
    }

    public void onClickStats(View v){
        System.out.println("Stats Clicked!!!");
        Intent intent = new Intent(MainMenuHandler.this, StatisticsHandler.class);
        startActivity(intent);
    }

    public void onClickTips(View v){
        System.out.println("Tips Clicked!!!");
        Intent intent = new Intent(MainMenuHandler.this, TipsHandler.class);
        startActivity(intent);
    }

    public void onClickLeftover(View v){
        System.out.println("Leftover Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, );
        startActivity(intent);
        */

    }



}
