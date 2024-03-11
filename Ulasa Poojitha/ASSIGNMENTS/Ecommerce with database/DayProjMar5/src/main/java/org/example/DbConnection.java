package org.example;
//runs in mainco
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DbConnection
{
    public static Connection getConnection() {
        Connection connection = null;
        Properties prop = new Properties();
        try (FileInputStream file = new FileInputStream("demoexm.properties");) {
            prop.load(file);
            Class.forName(prop.getProperty("className"));
            connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("userName"), prop.getProperty("password"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.out.println(e);
        }
        return connection;
    }
}

