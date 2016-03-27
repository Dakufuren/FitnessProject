package com.example.albinskola.fitnessproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    final Context context = this;
    private int tempId;

    DbConnecter db = new DbConnecter();
    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;
    List<WorkoutObject> nls;

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

                ArrayList<WorkoutObject> ls;
                ls = db.getWorkOuts(userName);

                nls = Collections.synchronizedList(new ArrayList<WorkoutObject>());
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
                    tempId = position;

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);



                    // set title
                    alertDialogBuilder.setTitle("Session " + nls.get(tempId).getDate());

                    // set dialog message
                    alertDialogBuilder
                            .setMessage(getDiaMsg())
                            .setCancelable(false)
                            .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
            });
        }



    }
    public String getDiaMsg(){
        String diaMsg = "";

        diaMsg = "Elapsed time: " + nls.get(tempId).getElapsedTime();
        diaMsg = diaMsg + "\n" + "Intensity: " + nls.get(tempId).getIntensity();
        diaMsg = diaMsg + "\n" + "Note: " + nls.get(tempId).getDescription();
        diaMsg = diaMsg + "\n" + "Burned Calories: " + nls.get(tempId).getKcal() + "\n" + "\n";

        if(nls.get(tempId).getAbdomen() == 1){
            diaMsg = diaMsg + "Abdomen" + "\n";
        }
        if(nls.get(tempId).getBiceps() == 1){
            diaMsg = diaMsg + "Biceps" + "\n";
        }
        if(nls.get(tempId).getCalves() == 1){
            diaMsg = diaMsg + "Calves"  + "\n";
        }
        if(nls.get(tempId).getChest() == 1){
            diaMsg = diaMsg + "Chest" + "\n";
        }
        if(nls.get(tempId).getTriceps() == 1){
            diaMsg = diaMsg + "Triceps" + "\n";
        }
        if(nls.get(tempId).getShoulders() == 1){
            diaMsg = diaMsg + "Shoulders" + "\n";
        }
        if(nls.get(tempId).getTraps() == 1){
            diaMsg = diaMsg + "Traps" + "\n";
        }
        if(nls.get(tempId).getUpperBack() == 1){
            diaMsg = diaMsg + "Upper Back" + "\n";
        }
        if(nls.get(tempId).getLowerBack() == 1){
            diaMsg = diaMsg + "Lower Back" + "\n";
        }
        if(nls.get(tempId).getGlutes() == 1){
            diaMsg = diaMsg + "Glutes" + "\n";
        }
        if(nls.get(tempId).getHamstrings() == 1){
            diaMsg = diaMsg + "Hamstrings" + "\n";
        }
        if(nls.get(tempId).getQuadriceps() == 1){
            diaMsg = diaMsg + "Quadriceps" + "\n";
        }
        return diaMsg;
    }
}
