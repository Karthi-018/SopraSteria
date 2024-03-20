package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection
{
    public Connection getConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306 / e_commerce","root","root");
        }
        catch(ClassNotFoundException ecom)
        {
            System.out.println(ecom);
        }
        catch (SQLException ecom)
        {
            System.out.println(ecom);
        }
        return connection;
    }
}