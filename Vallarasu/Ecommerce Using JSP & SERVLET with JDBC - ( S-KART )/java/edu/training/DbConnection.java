package edu.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection()
    {
        Connection connection=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/skart","root","root");
            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
