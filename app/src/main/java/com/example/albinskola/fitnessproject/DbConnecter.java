package com.example.albinskola.fitnessproject;

    import android.net.NetworkInfo;
    import android.os.AsyncTask;
    import android.os.StrictMode;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;

public class DbConnecter {
    Connection con = null;
    String url = "jdbc:mysql://185.76.64.28:3306/etvffqgz_FitnessBass";
    String usr = "etvffqgz_admin";
    String pass = "admin";



    public int verifyLogin(String userName,String password) {
        try {

            System.out.println(userName + " " + password);
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(url, usr, pass);

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
}
