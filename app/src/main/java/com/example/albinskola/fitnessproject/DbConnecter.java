package com.example.albinskola.fitnessproject;

    import android.content.SharedPreferences;
    import android.net.NetworkInfo;
    import android.os.AsyncTask;
    import android.os.StrictMode;
    import android.support.v7.app.AppCompatActivity;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.Date;

public class DbConnecter {



    Connection con = null;
    String url = "jdbc:mysql://185.76.64.28:3306/etvffqgz_FitnessNew";
    String usr = "etvffqgz_admin";
    String pass = "admin";

    String USERNAME = null;


    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, usr, pass);
        } catch (Exception ex) {

        }
    }


    public int verifyLogin(String userName,String password) {
        try {

            connect();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Users");
            System.out.println("1");
            while(rs.next()) {
                String tmpUser = rs.getString("UserName");
                String tmpPassword = rs.getString("Password");
                if (tmpUser.equals(userName) && tmpPassword.equals(password)) {
                    return 2;
                }
            }



        } catch (Exception ex) {
            System.out.println(ex);
        }



        return 1;
    }

    public void addWorkOut(String userName, Date date, int elapsedTime, int intensity, String description, int biceps, int triceps, int shoulders, int traps,
                           int upperBack, int lowerBack, int chest, int abdomen, int glutes, int hamstrings, int quadriceps, int calves) {

        try {
            connect();

            Statement st = con.createStatement();

            String sqlWorkout = String.format("INSERT INTO Workouts (Users_UserName, TheDate, ElapsedTime, Intensity, Note, Biceps, Triceps, Shoulders, Traps, UpperBack, LowerBack, Chest, Abdomen, Glutes, Hamstrings, Quadriceps, Calves) VALUES ('%s', '%s', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d)", userName, date, elapsedTime, intensity, description, biceps, triceps, shoulders, traps,
                    upperBack, lowerBack, chest, abdomen, glutes, hamstrings, quadriceps, calves);

            st.executeUpdate(sqlWorkout);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public ArrayList getWorkOuts (String userName) {
        Workout wo;
        ArrayList<Workout> workoutList = new ArrayList();
        try {
            connect();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Workouts where Users_UserName = " + userName);

            while (rs.next()) {
                wo = new Workout(rs.getDate("TheDate"), rs.getInt("ElapsedTime"), rs.getInt("Intensity"), rs.getString("Note"), rs.getInt("Biceps"), rs.getInt("Triceps"), rs.getInt("Shoulders"), rs.getInt("Traps"), rs.getInt("UpperBack"), rs.getInt("LowerBack"), rs.getInt("Chest"), rs.getInt("Abdomen"), rs.getInt("Glutes"), rs.getInt("Hamstrings"), rs.getByte("Quadriceps"), rs.getInt("Calves"));
                workoutList.add(wo);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return workoutList;
    }



}

