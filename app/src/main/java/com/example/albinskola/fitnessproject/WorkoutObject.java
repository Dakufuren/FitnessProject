package com.example.albinskola.fitnessproject;

import java.util.Date;

/**
 * Created by bumblebee on 2016-03-22.
 */
public class WorkoutObject {


    Date date = null;
    int elapsedTime = 0;
    int intensity = 0;
    String description = null;
    int biceps = 0;
    int triceps = 0;
    int shoulders = 0;
    int traps = 0;
    int upperBack = 0;
    int lowerBack = 0;
    int chest = 0;
    int abdomen = 0;
    int glutes = 0;
    int hamstrings = 0;
    int quadriceps = 0;
    int calves = 0;

    public WorkoutObject(Date date, int elapsedTime, int intensity, String description, int biceps, int triceps, int shoulders, int traps,
                   int upperBack, int lowerBack, int chest, int abdomen, int glutes, int hamstrings, int quadriceps, int calves) {
        this.date = date;
        this.elapsedTime = elapsedTime;
        this.intensity = intensity;
        this.description = description;
        this.biceps = biceps;
        this.triceps = triceps;
        this.shoulders = shoulders;
        this.traps = traps;
        this.upperBack = upperBack;
        this.lowerBack = lowerBack;
        this.chest = chest;
        this.abdomen = abdomen;
        this.glutes = glutes;
        this.hamstrings = hamstrings;
        this.quadriceps = quadriceps;
        this.calves = calves;



    }

    public Date getDate() {
        return date;
    }

    public int getShoulders() {
        return shoulders;
    }

    public int getBiceps() {
        return biceps;
    }

    public int getIntensity() {
        return intensity;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public String getDescription() {
        return description;
    }

    public int getTriceps() {
        return triceps;
    }

    public int getTraps() {
        return traps;
    }

    public int getUpperBack() {
        return upperBack;
    }

    public int getLowerBack() {
        return lowerBack;
    }

    public int getChest() {
        return chest;
    }

    public int getAbdomen() {
        return abdomen;
    }

    public int getGlutes() {
        return glutes;
    }

    public int getHamstrings() {
        return hamstrings;
    }

    public int getCalves() {
        return calves;
    }

    public int getQuadriceps() {
        return quadriceps;
    }






}
