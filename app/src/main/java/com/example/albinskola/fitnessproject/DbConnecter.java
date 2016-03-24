package com.example.albinskola.fitnessproject;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import java.util.ArrayList;

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

    public int addWorkOut(String userName, String date, int elapsedTime, int intensity, String description, int biceps, int triceps, int shoulders, int traps,
                           int upperBack, int lowerBack, int chest, int abdomen, int glutes, int hamstrings, int quadriceps, int calves) {
        int isAdded = 2;
        try {
            connect();

            Statement st = con.createStatement();

            String sqlWorkout = String.format("INSERT INTO Workouts (Users_UserName, TheDate, ElapsedTime, Intensity, Note, Biceps, Triceps, Shoulders, Traps, UpperBack, LowerBack, Chest, Abdomen, Glutes, Hamstrings, Quadriceps, Calves) VALUES ('%s', '%s', %d, %d, '%s', %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d)", userName, date, elapsedTime, intensity, description, biceps, triceps, shoulders, traps,
                    upperBack, lowerBack, chest, abdomen, glutes, hamstrings, quadriceps, calves);

            st.executeUpdate(sqlWorkout);

        } catch (Exception ex) {
            System.out.println(ex);
            isAdded = 1;
        }
        return isAdded;

    }

    public ArrayList getWorkOuts (String userName) {
        Workout wo;
        ArrayList<Workout> workoutList = new ArrayList();
        try {
            connect();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Workouts WHERE Users_UserName = '" + userName + "'");

            while (rs.next()) {
                wo = new Workout(rs.getDate("TheDate"), rs.getInt("ElapsedTime"), rs.getInt("Intensity"), rs.getString("Note"), rs.getInt("Biceps"), rs.getInt("Triceps"), rs.getInt("Shoulders"), rs.getInt("Traps"), rs.getInt("UpperBack"), rs.getInt("LowerBack"), rs.getInt("Chest"), rs.getInt("Abdomen"), rs.getInt("Glutes"), rs.getInt("Hamstrings"), rs.getByte("Quadriceps"), rs.getInt("Calves"));
                workoutList.add(wo);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return workoutList;
    }

    public int addUser(String userName, String firstName, String lastName, String passWord, String email, int wieght, int height, String sex) {


        int isAdded = 2;
        try {

            connect();

            Statement st = con.createStatement();
            Statement st2 = con.createStatement();

            String userString = String.format("INSERT INTO Users (UserName, FirstName, LastName, Password, Email) VALUES ('%s', '%s', '%s', '%s', '%s')", userName, firstName, lastName, passWord, email);
            st.executeUpdate(userString);

            String profileString = String.format("INSERT INTO Profile (Users_UserName, Weight, Height, sex) VALUES ('%s', %d, %d, '%s')", userName, wieght, height, sex);
            st2.executeUpdate(profileString);





        } catch (Exception ex) {
            isAdded = 1;
            System.out.println(ex);
        }

        return isAdded;



    }

    public ProfileObject getProfile(String username) {
        ProfileObject po = null;


        try {
            connect();

            Statement st = con.createStatement();

            String sqlStatement = String.format("SELECT * FROM Profile WHERE Users_UserName = %s", username);

            ResultSet rs = st.executeQuery(sqlStatement);

            while (rs.next()) {
                po = new ProfileObject(rs.getInt("Weight"), rs.getInt("Height"), rs.getString("Sex"));
            }


        } catch (Exception ex) {
            System.out.println(ex);
        }

        return po;
    }

    public int setProfile(String username, int weight, int height, String sex) {
        int isAdded = 2;

        try {
            connect();

            Statement st = con.createStatement();

            String sqlStatement = String.format("UPDATE Profile SET Weight = %d, Height = %d, Sex = %s WHERE Users_UserName = %s", weight, height, sex, username);

            st.executeUpdate(sqlStatement);



        } catch (Exception ex) {
            System.out.println(ex);
            isAdded = 1;
        }



        return isAdded;
    }



}

