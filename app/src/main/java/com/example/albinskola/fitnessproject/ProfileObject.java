package com.example.albinskola.fitnessproject;

/**
 * Created by bumblebee on 2016-03-24.
 */
public class ProfileObject {



    private int weight;
    private int height;
    private String sex;

    public ProfileObject(int weight, int height, String sex) {
        this.weight = weight;
        this.sex = sex;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getSex() {
        return sex;
    }




}
