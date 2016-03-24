package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddWorkoutHandler extends AppCompatActivity {

    DbConnecter db = new DbConnecter();

    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;

    private EditText elapsedTimeText;
    private EditText intensityText;
    private EditText noteText;
    private Button bicepsButton;
    private Button tricepsButton;
    private Button shouldersButton;
    private Button trapsButton;
    private Button upperbackButton;
    private Button lowerbackButton;
    private Button chestButton;
    private Button abdomenButton;
    private Button glutesButton;
    private Button hamstringsButton;
    private Button quadricepsButton;
    private Button calvesButton;
    private Button submitButton;


    int elapsedTime = 0;
    int intensity = 0;
    String note = "";
    int biceps = 0;
    int triceps = 0;
    int shoulders = 0;
    int traps = 0;
    int upperback = 0;
    int lowerback = 0;
    int chest = 0;
    int abdomen = 0;
    int glutes = 0;
    int hamstrings = 0;
    int quadriceps = 0;
    int calves = 0;
    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    int successOrNah = 0;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_handler);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        elapsedTimeText = (EditText)findViewById(R.id.editTextElapsed);
        intensityText = (EditText)findViewById(R.id.editTextIntentsity);
        noteText = (EditText)findViewById(R.id.editTextNote);
        bicepsButton = (Button)findViewById(R.id.buttonBiceps);
        tricepsButton = (Button)findViewById(R.id.buttonTriceps);
        shouldersButton = (Button)findViewById(R.id.buttonShoulders);
        trapsButton = (Button)findViewById(R.id.buttonTraps);
        upperbackButton = (Button)findViewById(R.id.buttonUback);
        lowerbackButton = (Button)findViewById(R.id.buttonLback);
        chestButton = (Button)findViewById(R.id.buttonChest);
        abdomenButton = (Button)findViewById(R.id.buttonAbd);
        glutesButton = (Button)findViewById(R.id.buttonGlutes);
        hamstringsButton = (Button)findViewById(R.id.buttonHamstrings);
        quadricepsButton = (Button)findViewById(R.id.buttonQuad);
        calvesButton = (Button)findViewById(R.id.buttonCalves);
        submitButton = (Button)findViewById(R.id.buttonAddWorkout);


        bicepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                biceps = 1;
                System.out.println(biceps);

                System.out.println("Added biceps workout");
            }
        });

        tricepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                triceps = 1;
                System.out.println("Added triceps workout");
            }
        });

        shouldersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shoulders = 1;
                System.out.println("Added shoulder workout");
            }
        });

        trapsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                traps = 1;
                System.out.println("Added traps workout");
            }
        });

        upperbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                upperback = 1;
                System.out.println("Added upperback workout");
            }
        });

        lowerbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lowerback = 1;
                System.out.println("Added lowerback workout");
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chest = 1;
                System.out.println("Added chest workout");
            }
        });

        abdomenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abdomen = 1;
                System.out.println("Added abdomen workout");
            }
        });

        glutesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                glutes = 1;
                System.out.println("Added glutes workout");
            }
        });

        hamstringsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hamstrings = 1;
                System.out.println("Added hamstrings workout");
            }
        });

        quadricepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                quadriceps = 1;
                System.out.println("Added quadriceps workout");
            }
        });

        calvesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calves = 1;
                System.out.println("Added calves workout");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if (elapsedTimeText.getText().toString().length() < 1 || intensityText.getText().toString().length() < 1) {
                    System.out.println("SPECIFY WORKOUT LENGTH AND INTENSITY");
                }

                else if(biceps == 0 && triceps == 0 && shoulders == 0 && traps == 0 && upperback == 0 && lowerback == 0 && chest == 0 && abdomen == 0 && glutes == 0 && hamstrings == 0 && quadriceps == 0 && calves == 0) {
                    System.out.println("YOU HAVE TO ADD A BODY PART");


                } else {


                    System.out.println("Submitted total workout!!!!!!!" + date);

                    Thread thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String userName = pref.getString("username", null);
                            note = noteText.getText().toString();
                            elapsedTime = Integer.parseInt(elapsedTimeText.getText().toString());
                            intensity = Integer.parseInt(intensityText.getText().toString());


                            successOrNah = db.addWorkOut(userName, date, elapsedTime, intensity, note, biceps, triceps, shoulders, traps, upperback, lowerback, chest, abdomen, glutes, hamstrings, quadriceps, calves);


                        }
                    });
                    thread1.start();

                    while (successOrNah == 0) {

                    }

                    if (successOrNah == 2) {
                        thread1.interrupt();
                        System.out.println("WORKOUT ADDED!!!!");

                    } else if (successOrNah == 1) {
                        thread1.interrupt();
                        System.out.println("FAILED");
                    }


                }
                clearWorkoutButtons();

            }

        });

    }

    private void clearWorkoutButtons(){
        elapsedTime = 0;
        intensity = 0;
        biceps = 0;
        triceps = 0;
        shoulders = 0;
        traps = 0;
        upperback = 0;
        lowerback = 0;
        chest = 0;
        abdomen = 0;
        glutes = 0;
        hamstrings = 0;
        quadriceps = 0;
        calves = 0;
    }




}
