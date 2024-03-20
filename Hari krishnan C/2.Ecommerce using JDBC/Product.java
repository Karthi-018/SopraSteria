package org.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Product
{
    Connection c = new DBConnection().getConnection();
    public void addProduct(int id, String name, int cost, int quantity)
    {
        try
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("Insert into Products values("+ id +",'"+ name +"',"+ cost +","+ quantity +")");
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
    public void listProduct()
    {
        try
        {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Products");
            System.out.println("Product_id     Product_name      Cost    Quantity");
            while(rs.next())
            {
                System.out.println("    "+ rs.getInt(1)+"           "+ rs.getString(2)+ "        "+ rs.getInt(3)+"     "+rs.getInt(4));
            }
        }
        catch (SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
    public void editProductCost(int id,int cost)
    {
        try
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("Update Products set cost= " + cost + " where Product_id=" + id);
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
    public void editProductQuantity(int id,int quantity)
    {
        try
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("Update Products set quantity= " + quantity + " where Product_id=" +id);
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
    public void deleteProduct(int id)
    {
        try
        {
            Statement statement = c.createStatement();
            statement.executeUpdate("Delete from Products where product_id=" + id);
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
    public void searchProduct(String product_name)
    {
        try
        {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Products where Product_name='"+product_name+"'");
            int n = 0;
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
                n++;
            }
            if(n>0)
            {
                System.out.println("\nThe Product is Available! :)");
            }
            else
            {
                System.out.println("\nSorry...The Product is not Available :(");
            }
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
    }
}