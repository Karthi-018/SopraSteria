package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection=null;
        Properties probes=new Properties();
        try(FileInputStream fis=new FileInputStream("data.properties"))
        {
            probes.load(fis);
            Class.forName(probes.getProperty("className"));
            connection=DriverManager.getConnection(probes.getProperty("url"),probes.getProperty("username"),probes.getProperty("password"));
        }catch(ClassNotFoundException | SQLException | IOException e)
        {
            System.out.println(e);
        }

        return connection;
    }
}

