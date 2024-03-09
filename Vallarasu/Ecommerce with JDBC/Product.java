package Ecommerce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Product {
    Connection c = new DbConnection().getConnection();

    public void addProduct(int id, String name, int cost, int quantity) {
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate("INSERT INTO Product VALUES(" + id + ",'" + name + "'," + cost+","+quantity+")");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void listProduct()
    {
        try{
            Statement statement=c.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Product");
            while(resultset.next())
            {
                System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3)+" "+resultset.getInt(4));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }

    public void editProduct(int id,int cost)
    {
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate("UPDATE PRODUCT SET COST=" + cost + " WHERE PID=" +id);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int id)
    {
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate("DELETE FROM PRODUCT WHERE PID=" + id);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void searchProduct(String name)
    {
        try{
            Statement statement=c.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Product Where pname='"+name+"'");
            int temp=0;
            while(resultset.next())
            {
                System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getInt(3)+" "+resultset.getInt(4));
                temp++;
            }
            if(temp>0) {
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