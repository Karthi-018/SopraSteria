package edu.steria.training;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;
import java.util.Properties;

public class DBConnection
{
    public static Connection getConnection()
    {
        Connection c = null;
        try(FileInputStream file = new FileInputStream("Application.properties");)
        {
            Properties prob = new Properties();
            prob.load(file);

            Class.forName(prob.getProperty("className"));
            c = DriverManager.getConnection(prob.getProperty("url"),prob.getProperty("userName"),prob.getProperty("password"));
//            System.out.println("Connected...........");
        }
        catch (ClassNotFoundException | SQLException  | IOException e)
        {
            System.out.println(e);
        }
        return c;


    }

}
