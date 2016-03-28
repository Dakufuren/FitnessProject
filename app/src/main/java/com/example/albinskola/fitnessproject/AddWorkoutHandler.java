package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private SeekBar elapsedTimeSeekBar;
    private SeekBar intensitySeekBar;
    private TextView progressTimeTextView;
    private TextView progressIntensityTextView;


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
    double METvalue = 3.0; //value for heavy lifting when calculating burned calories per workout.
    private ProfileObject po = null;
    int progress = 0;
    int progress2 = 0;
    int offset = 10;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_handler);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);



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
        elapsedTimeSeekBar = (SeekBar)findViewById(R.id.seekBarTime);
        intensitySeekBar = (SeekBar)findViewById(R.id.seekBarIntensity);
        progressTimeTextView = (TextView)findViewById(R.id.textView11);
        progressIntensityTextView = (TextView)findViewById(R.id.textView12);



        progressTimeTextView.setText("total time: " + elapsedTimeSeekBar.getProgress());
        progressIntensityTextView.setText("intensity: " + intensitySeekBar.getProgress());



        elapsedTimeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar elapsedTimeSeekBar, int progresValue, boolean fromUser) {
                progress = progresValue;


            }

            @Override
            public void onStartTrackingTouch(SeekBar elapsedTimeSeekBar) {
                progressTimeTextView.setText("total time: " + progress + " min");

            }

            @Override
            public void onStopTrackingTouch(SeekBar elapsedTimeSeekBar) {
                progressTimeTextView.setText("total time: " + progress + " min");
            }
        });

        intensitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar intensitySeekBar, int progresValue, boolean fromUser) {
                progress2 = progresValue;


            }

            @Override
            public void onStartTrackingTouch(SeekBar intensitySeekBar) {
                progressIntensityTextView.setText("Intensity: " + progress2 + " %");
            }

            @Override
            public void onStopTrackingTouch(SeekBar intensitySeekBar) {
                progressIntensityTextView.setText("Intensity: " + progress2 + " %");
            }
        });



        bicepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                biceps = 1;
                bicepsButton.getBackground().setColorFilter(0xFF447183,PorterDuff.Mode.MULTIPLY);
                System.out.println(biceps);

                System.out.println("Added biceps workout");
            }
        });

        tricepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                triceps = 1;
                tricepsButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added triceps workout");
            }
        });

        shouldersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                shoulders = 1;
                shouldersButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added shoulder workout");
            }
        });

        trapsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                traps = 1;
                trapsButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added traps workout");
            }
        });

        upperbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                upperback = 1;
                upperbackButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added upperback workout");
            }
        });

        lowerbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lowerback = 1;
                lowerbackButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added lowerback workout");
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chest = 1;
                chestButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added chest workout");
            }
        });

        abdomenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                abdomen = 1;
                abdomenButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added abdomen workout");
            }
        });

        glutesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                glutes = 1;
                glutesButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added glutes workout");
            }
        });

        hamstringsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hamstrings = 1;
                hamstringsButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added hamstrings workout");
            }
        });

        quadricepsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                quadriceps = 1;
                quadricepsButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added quadriceps workout");
            }
        });

        calvesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calves = 1;
                calvesButton.getBackground().setColorFilter(0xFF447183, PorterDuff.Mode.MULTIPLY);
                System.out.println("Added calves workout");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if ( elapsedTimeSeekBar.getProgress() == 0 || elapsedTimeSeekBar.getProgress() == 0) {
                    System.out.println("SPECIFY WORKOUT LENGTH AND INTENSITY");
                    Toast.makeText(getApplicationContext(), "please specify time and intensity of workout", Toast.LENGTH_SHORT).show();
                } else if (biceps == 0 && triceps == 0 && shoulders == 0 && traps == 0 && upperback == 0 && lowerback == 0 && chest == 0 && abdomen == 0 && glutes == 0 && hamstrings == 0 && quadriceps == 0 && calves == 0) {
                    System.out.println("YOU HAVE TO ADD A BODY PART");
                    Toast.makeText(getApplicationContext(), "please add body part", Toast.LENGTH_SHORT).show();


                } else {





                    System.out.println("Submitted total workout!!!!!!!" + date);

                    Thread thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String userName = pref.getString("username", null);
                            note = noteText.getText().toString();
                            elapsedTime = elapsedTimeSeekBar.getProgress();
                            intensity = intensitySeekBar.getProgress();
                            double kcal = burnedCalories();

                            System.out.println("JAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + kcal);



                            successOrNah = db.addWorkOut(userName, date, elapsedTime, intensity, note, biceps, triceps, shoulders, traps, upperback, lowerback, chest, abdomen, glutes, hamstrings, quadriceps, calves, kcal);


                        }
                    });
                    thread1.start();

                    while (successOrNah == 0) {

                    }

                    if (successOrNah == 2) {
                        thread1.interrupt();
                        System.out.println("WORKOUT ADDED!!!!");
                        Toast.makeText(getApplicationContext(), "Workout added!", Toast.LENGTH_SHORT).show();
                        clearTextFields();
                        Intent intent = new Intent(AddWorkoutHandler.this, MainMenuHandler.class);
                        startActivity(intent);

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
        bicepsButton.getBackground().clearColorFilter();
        tricepsButton.getBackground().clearColorFilter();
        shouldersButton.getBackground().clearColorFilter();
        trapsButton.getBackground().clearColorFilter();
        upperbackButton.getBackground().clearColorFilter();
        lowerbackButton.getBackground().clearColorFilter();
        chestButton.getBackground().clearColorFilter();
        abdomenButton.getBackground().clearColorFilter();
        glutesButton.getBackground().clearColorFilter();
        hamstringsButton.getBackground().clearColorFilter();
        quadricepsButton.getBackground().clearColorFilter();
        calvesButton.getBackground().clearColorFilter();

    }

    private void clearTextFields(){
        noteText.setText("");
    }

    private double burnedCalories(){

        double tempCalories = 0;
        double calories = 0;

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                String username = pref.getString("username", null);
                po = db.getProfile(username);


            int w = po.getWeight();
            //int h = po.getHeight();

            double weight = (double)w;
            //double height = (double)h;

            double elapsedTime = Double.parseDouble(String.valueOf(progress)) / 60;
            double intensity = Double.parseDouble(String.valueOf(progress2)) / 100;

            tempCalories = (METvalue * weight) * elapsedTime;
            calories = tempCalories * intensity;



        return calories;

    }















}
