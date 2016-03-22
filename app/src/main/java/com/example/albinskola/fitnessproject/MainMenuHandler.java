package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainMenuHandler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    public void onClickAdd(View v){
        System.out.println("Add Clicked!!!");
        Intent intent = new Intent(MainMenuHandler.this, AddWorkoutHandler.class);
        startActivity(intent);
    }

    public void onClickView(View v){
        System.out.println("View Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
        startActivity(intent);
        */
    }

    public void onClickProfile(View v){
        System.out.println("Profile Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
        startActivity(intent);
        */
    }

    public void onClickStats(View v){
        System.out.println("Stats Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
        startActivity(intent);
        */
    }

    public void onClickTips(View v){
        System.out.println("Tips Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
        startActivity(intent);
        */

    }

    public void onClickLeftover(View v){
        System.out.println("Leftover Clicked!!!");
        /*
        Intent intent = new Intent(MainMenuHandler.this, ViewWorkoutHandler.class);
        startActivity(intent);
        */

    }



}
