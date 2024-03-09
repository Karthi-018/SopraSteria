package edu.steria.train;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection()
    {
        Connection connection=null;//we should initialize connection object
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
