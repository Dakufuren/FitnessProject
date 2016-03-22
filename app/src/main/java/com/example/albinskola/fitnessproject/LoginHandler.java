package com.example.albinskola.fitnessproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginHandler extends AppCompatActivity {


    public static final String PREFS_NAME = "shared_pref";

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    private EditText username;
    private EditText password;
    private Button loginButton;
    DbConnecter db = new DbConnecter();
    int switchornah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_handler);
        username = (EditText)findViewById(R.id.textUser);
        password = (EditText) findViewById(R.id.textPass);
        loginButton = (Button) findViewById(R.id.loginButton);



        loginButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String tmpPassword = password.getText().toString();
                        String tmpUsername = username.getText().toString();
                        switchornah = db.verifyLogin(tmpUsername, tmpPassword);
                    }
                });
                thread1.start();


                while (switchornah == 0) {

                }


                if (switchornah == 2) {
                    thread1.interrupt();
                    switchornah = 0;
                    setLoggedIn();
                    String test = pref.getString("username", null);
                    System.out.println("YOU ARE LOGGED IN AS THIS MFER" + test);
                    System.out.println("GRANTED ACCESS BITCH NIGGA");
                    startActivity(new Intent(LoginHandler.this, MainMenuHandler.class));

                } else if (switchornah == 1) {
                    thread1.interrupt();
                    switchornah = 0;
                    System.out.println("ACCESS DENIED");
                }

            }
        });


    }

     public void setLoggedIn(){

         pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
         editor = pref.edit();

         editor.putString("username", username.getText().toString());
         editor.commit();

     }


}

