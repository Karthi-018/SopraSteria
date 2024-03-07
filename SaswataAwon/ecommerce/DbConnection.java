package edu.steria.branch.ecommerce;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection(){
        Connection connection=null;
        Properties probs= new Properties();

        try(FileInputStream fis= new FileInputStream("data.properties");){
            probs.load(fis);
            Class.forName(probs.getProperty("className"));
            connection= DriverManager.getConnection(probs.getProperty("url"),probs.getProperty("userName"),probs.getProperty("password"));

        }

        catch (ClassNotFoundException | SQLException | IOException e){
            System.out.println(e);
        }
        return connection;

    }
}
