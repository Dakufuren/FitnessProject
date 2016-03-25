package com.example.albinskola.fitnessproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class StatisticsHandler extends AppCompatActivity {
    int bicepsCounter = 0;
    int tricepsCounter = 0;
    int shouldersCounter = 0;
    int trapsCounter = 0;
    int upperbackCounter = 0;
    int lowerbackCounter = 0;
    int chestCounter = 0;
    int abdomenCounter = 0;
    int glutesCounter = 0;
    int hamstringsCounter = 0;
    int quadricepsCounter = 0;
    int calvesCounter = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_handler);







        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5, 10),
                new DataPoint(6, 4),
                new DataPoint(7, 18),
                new DataPoint(8, 4),
                new DataPoint(9, 12),
                new DataPoint(10, 1),
                new DataPoint(11, 2)
        });
        series.setSpacing(50);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(11);
        graph.getLegendRenderer().setVisible(true);

        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

        graph.addSeries(series);

        /*
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"biceps", "triceps", "shoudlers", "traps", "upper Back", "lower back", "chest", "abdomen", "glutes", "hamstrings", "quadriceps", "calves"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);*/

    }

}
