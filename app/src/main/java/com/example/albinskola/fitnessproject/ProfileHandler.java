package com.example.albinskola.fitnessproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileHandler extends AppCompatActivity {

    private Button submitButton;
    private EditText weightField;
    private EditText heightField;
    private EditText sexField;
    private ProfileObject po = null;
    DbConnecter db = new DbConnecter();
    int successOrNah = 0;

    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_handler);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        submitButton = (Button) findViewById(R.id.SubmitButton);
        weightField = (EditText) findViewById(R.id.WeightField);
        heightField = (EditText) findViewById(R.id.HeightField);
        sexField = (EditText) findViewById(R.id.SexField);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String userName = pref.getString("username", null);
                po = db.getProfile(userName);
            }
        });
        thread1.start();

        while (po == null) {

        }
        if (po != null) {
            thread1.interrupt();

            weightField.setText(po.getWeight());
            heightField.setText(po.getHeight());
            sexField.setText(po.getSex());

        }


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String userName = pref.getString("username", null);
                        int weight = Integer.parseInt(weightField.getText().toString());
                        int height = Integer.parseInt(heightField.getText().toString());
                        successOrNah = db.setProfile(userName, weight, height, sexField.getText().toString());
                    }
                });
                thread2.start();

                while (successOrNah == 0) {

                }

                if (successOrNah == 2) {
                    System.out.println("Profile updated");
                    thread2.interrupt();
                } else if (successOrNah == 1) {
                    System.out.println("profile didnt update");
                    thread2.interrupt();
                }


            }
        });


    }
}
