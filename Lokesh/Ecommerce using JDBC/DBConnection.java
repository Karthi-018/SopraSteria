package edu.assign;
import java.util.*;
import java.sql.*;

import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection()
	{
		Connection connect = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomm","root","mSqlroot@24");
		}
		
		catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        
		catch (SQLException e)
		{
            System.out.println(e);
        }
        
		return connect;
	}
}