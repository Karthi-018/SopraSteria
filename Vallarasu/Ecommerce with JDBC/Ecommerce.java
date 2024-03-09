package Ecommerce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Ecommerce {
    Connection c=new DbConnection().getConnection();
    public int adminLogin(String username,String password){
        try
        {
            Statement statement=c.createStatement();
            ResultSet rs=statement.executeQuery("Select * from admin");
            while (rs.next())
            {
                if(rs.getString(1).equals(username))
                {
                    if(rs.getString(2).equals(password))
                        return 1;
                    else
                    {
                        System.out.println("\nInvalid Credentials\n");
                        return 0;
                    }
                }
                else
                {
                    System.out.println("\nInvalid Credentials\n");
                    return 0;
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public int customerLogin(String username,String password){
        Scanner in=new Scanner(System.in);
        try
        {
            Statement statement=c.createStatement();
            ResultSet rs=statement.executeQuery("Select * from customer");
            while(rs.next())
            {
                if(rs.getString(1).equals(username))
                    if(rs.getString(2).equals(password))
                        return 1;
                    else {
                        System.out.println("\nInvalid Credentials\n");
                        return 0;
                    }
            }
            System.out.println("UserName Not Available");
            System.out.println("Do you want to Register? : 1.YES  2.NO");
            if(in.nextInt()==1)
                if(customerRegister()==0)
                    return 0;
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
    public int customerRegister(){
        Scanner in=new Scanner(System.in);
        try
        {
            Statement statement=c.createStatement();
            System.out.println("Enter the Username");
            String username=in.next();
            System.out.println("Enter the Password");
            String password=in.next();
            statement.executeUpdate("INSERT INTO CUSTOMER VALUES('"+username+"','"+password+"')");
            System.out.println("\nSuccessfully Registered....\n");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return 0;
    }
}