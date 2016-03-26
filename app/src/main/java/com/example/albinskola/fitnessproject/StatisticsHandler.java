package com.example.albinskola.fitnessproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsHandler extends AppCompatActivity {
    private TextView displayAmountOfWorkouts;

    double bicepsCounter = 0;
    double tricepsCounter = 0;
    double shouldersCounter = 0;
    double trapsCounter = 0;
    double upperbackCounter = 0;
    double lowerbackCounter = 0;
    double chestCounter = 0;
    double abdomenCounter = 0;
    double glutesCounter = 0;
    double hamstringsCounter = 0;
    double quadricepsCounter = 0;
    double calvesCounter = 0;


    DbConnecter db = new DbConnecter();
    public static final String PREFS_NAME = "shared_pref";
    SharedPreferences pref;
    List<WorkoutObject> nls;
    ArrayList<WorkoutObject> ls = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_handler);

        displayAmountOfWorkouts = (TextView) findViewById(R.id.DisplayWorkoutAmount);

        pref = getApplicationContext().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String userName = pref.getString("username", null);

                //ArrayList<WorkoutObject> ls = new ArrayList<>();
                ls = db.getWorkOuts(userName);


                nls = Collections.synchronizedList(new ArrayList<WorkoutObject>());
                nls = ls;

            }
        });
        thread1.start();

        while (nls == null) {

        }
        thread1.interrupt();
        System.out.println(nls.size());
        for (int i = 0; i < nls.size(); i++) {

            bicepsCounter = bicepsCounter + nls.get(i).getBiceps();
            tricepsCounter = tricepsCounter + nls.get(i).getTriceps();
            shouldersCounter = shouldersCounter + nls.get(i).getShoulders();
            trapsCounter = trapsCounter + nls.get(i).getTraps();
            upperbackCounter = upperbackCounter + nls.get(i).getUpperBack();
            lowerbackCounter = lowerbackCounter + nls.get(i).getLowerBack();
            chestCounter = chestCounter + nls.get(i).getChest();
            abdomenCounter = abdomenCounter + nls.get(i).getAbdomen();
            glutesCounter = glutesCounter + nls.get(i).getGlutes();
            hamstringsCounter = hamstringsCounter + nls.get(i).getHamstrings();
            quadricepsCounter = quadricepsCounter + nls.get(i).getQuadriceps();
            calvesCounter = calvesCounter + nls.get(i).getCalves();


        }

        displayAmountOfWorkouts.setText("" + nls.size());











        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, bicepsCounter),
                new DataPoint(1, tricepsCounter),
                new DataPoint(2, shouldersCounter),
                new DataPoint(3, trapsCounter),
                new DataPoint(4, upperbackCounter),
                new DataPoint(5, lowerbackCounter),
                new DataPoint(6, chestCounter),
                new DataPoint(7, abdomenCounter),
                new DataPoint(8, glutesCounter),
                new DataPoint(9, hamstringsCounter),
                new DataPoint(10, quadricepsCounter),
                new DataPoint(11, calvesCounter)
        });
        series.setSpacing(50);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(11);
        graph.getLegendRenderer().setVisible(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(nls.size());

        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        graph.addSeries(series);

        /*
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"biceps", "triceps", "shoudlers", "traps", "upper Back", "lower back", "chest", "abdomen", "glutes", "hamstrings", "quadriceps", "calves"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);*/



    }

}
