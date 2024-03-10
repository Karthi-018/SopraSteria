package edu.steria;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class dbconnection {
    public static Connection getConnection()
    {
        Connection connection=null;
        Properties props=new Properties();
        try(FileInputStream fis =new FileInputStream("data.properties");) {
            props.load(fis);
            Class.forName(props.getProperty("className"));
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
            System.out.println("Connected");
        }
        catch(ClassNotFoundException| SQLException| IOException e)
        {
            System.out.println(e);
        }
       return connection;
    }
}
