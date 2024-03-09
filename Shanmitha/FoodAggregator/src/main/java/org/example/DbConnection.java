package org.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection()
    {
        Connection connection = null;
        Properties properties = new Properties(); //creating obj for reading from properties file

        try(FileInputStream fileInputStream = new FileInputStream("data.properties");) {
            properties.load(fileInputStream);//load properties file data
            Class.forName(properties.getProperty("className"));
            connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return connection;

    }
}
