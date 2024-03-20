package edu.assign;
import java.util.*;
import java.sql.*;

public class Product {
	
    Connection connect = new DBConnection().getConnection();

    public void addProduct(int id, String name, int cost) 
    {
        try 
        {
            Statement statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO Product VALUES(" + id + ",'" + name + "'," + cost + " )");
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }

    public void listProduct()
    {
        try
        {
            Statement statement=connect.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Product");
            while(resultset.next())
            {
                System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }

    public void editProduct(String name,int cost)
    {
        try 
        {
            Statement statement = connect.createStatement();
            statement.executeUpdate("UPDATE PRODUCT SET COST = " + cost + " WHERE PNAME = '" + name+"'");
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(String name)
    {
        try 
        {
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM PRODUCT WHERE PNAME = '" + name+"'");
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchProduct(String name)
    {
        try
        {
            Statement statement=connect.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Product Where pname = '" + name + "'");
            int temp=0;
            while(resultset.next())
            {
                System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3));
                temp++;
            }
            if(temp>0) 
            {
                System.out.println("The Product is Available");
            }
            else
                System.out.println("The Product is Not Available");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
	
}
