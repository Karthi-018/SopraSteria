package edu.steria;
import java.sql.*;
public class Dbconnection
{
    public static Connection getConnection()
    {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            System.out.println("connected...");

        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return con;

    }
}
