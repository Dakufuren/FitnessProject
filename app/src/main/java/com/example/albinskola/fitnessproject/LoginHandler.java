package com.example.albinskola.fitnessproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginHandler extends AppCompatActivity {


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

                    System.out.println("GRANTED ACCESS BITCH NIGGA");
                } else if (switchornah == 1) {
                    thread1.interrupt();
                    switchornah = 0;
                    System.out.println("ACCESS DENIED");
                }

            }
        });
    }

}
