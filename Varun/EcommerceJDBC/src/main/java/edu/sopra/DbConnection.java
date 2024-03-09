package edu.sopra;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbConnection {



    public static Connection getConnection()
    {
        Connection conn=null;
        Properties prop=new Properties();
        FileInputStream fis=null;

        try
        {
            fis=new FileInputStream("data.properties");
            prop.load(fis);
            Class.forName(prop.getProperty("className"));
            conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"),prop.getProperty("password"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        finally
        {

            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }


}

