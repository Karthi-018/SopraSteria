package edu.training;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.*;
import java.util.Properties;

public class DBConnection
{
    public static Connection getConnection()
    {
        Connection c = null;
        try
        {
            

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:// localhost : 3306/ecommerce","root","root");
//            System.out.println("Connected...........");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return c;


    }

}
