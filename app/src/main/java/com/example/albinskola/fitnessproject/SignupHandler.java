package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupHandler extends AppCompatActivity {

    private Button submitButton;
    private EditText usernameField;
    private EditText firstnameField;
    private EditText lastnameField;
    private EditText passwordField;
    private EditText emailField;
    private EditText weightField;
    private EditText heightField;
    private EditText sexField;
    DbConnecter db = new DbConnecter();
    private int successOrNah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_handler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        submitButton = (Button) findViewById(R.id.SubmitButton);
        usernameField = (EditText) findViewById(R.id.UsernameField);
        firstnameField = (EditText) findViewById(R.id.FirstnameField);
        lastnameField = (EditText) findViewById(R.id.LastnameField);
        passwordField = (EditText) findViewById(R.id.PasswordField);
        emailField = (EditText) findViewById(R.id.EmailField);
        weightField = (EditText) findViewById(R.id.WeightField);
        heightField = (EditText) findViewById(R.id.HeightField);
        sexField = (EditText) findViewById(R.id.SexField);







        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int weight = Integer.parseInt(weightField.getText().toString());
                        int height = Integer.parseInt(heightField.getText().toString());

                        successOrNah = db.addUser(usernameField.getText().toString(), firstnameField.getText().toString(), lastnameField.getText().toString(),
                                passwordField.getText().toString(), emailField.getText().toString(), weight, height, sexField.getText().toString());


                    }
                });
                thread1.start();

                while (successOrNah == 0) {

                }

                if (successOrNah == 2) {
                    thread1.interrupt();
                    System.out.println("USER IS CREATED");
                    startActivity(new Intent(SignupHandler.this, LoginHandler.class));
                } else if (successOrNah == 1) {
                    thread1.interrupt();
                    System.out.println("CREATION FAILED");
                }

            }
        });
    }

}
