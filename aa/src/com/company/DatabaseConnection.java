package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection conn;
    public static DatabaseConnection dbc ;
    public DatabaseConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.print("driver loaded");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Etudiants","root","");
            System.out.println("cnx etablie");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public static DatabaseConnection getDatabaseConnection()
    {
        if (dbc==null)
            dbc= new DatabaseConnection();
        return dbc ;

    }
    public Connection getConnection()
    {
        return conn ;
    }

}
