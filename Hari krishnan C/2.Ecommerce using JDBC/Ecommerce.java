package org.example;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ecommerce
{
    Connection c = new DBConnection().getConnection();
    public int Adminlogin(String Admin_username,String Pwd)
    {
        try
        {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from admin");
            while(rs.next())
            {
                if(rs.getString(1).equals(Admin_username))
                {
                    if(rs.getString(2).equals(Pwd))
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
                else
                {
                    return 0;
                }
            }
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
        return 0;
    }
    public int Customerlogin(String Username,String Password)
    {
        try
        {
            Statement statement = c.createStatement();
            Scanner input = new Scanner(System.in);
            ResultSet rs = statement.executeQuery("Select * from Customer");
            int temp = 0;
            while(rs.next()) {
                if (rs.getString(1).equals(Username)) {
                    if (rs.getString(2).equals(Password)) {
                        temp = 1;
                        return 1;
                    }
                }
            }
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
        return 0;
    }
    public int customerAccount()
    {
        Scanner input = new Scanner(System.in);
        try
        {
            Statement statement = c.createStatement();
            System.out.println("\nEnter the Username: ");
            String Username = input.nextLine();
            System.out.println("\nEnter the Password: ");
            String Password = input.nextLine();
            statement.executeUpdate("Insert into Customer values('"+Username+"','"+Password+"')");
            System.out.println("\nAccount Created Successfully!");
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
        return 0;
    }
}