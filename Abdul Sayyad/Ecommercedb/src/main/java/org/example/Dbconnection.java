package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbconnection {
    public static Connection getConnection(){
        Connection connection = null;
        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("data.properties");){
            props.load(fis);
            Class.forName(props.getProperty("className"));
            connection = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"), props.getProperty("password"));

        }catch (IOException | SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
        return connection;
    }
}
