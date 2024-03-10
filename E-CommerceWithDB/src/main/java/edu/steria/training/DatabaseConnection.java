package edu.steria.training;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection()
    {
        Connection connection=null;
        Properties prop=new Properties();
        try(FileInputStream fis=new FileInputStream("data.properties");)
        {
            prop.load(fis);
            Class.forName(prop.getProperty("className"));
            connection= DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
        }
        catch(IOException | ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return connection;
    }
}
