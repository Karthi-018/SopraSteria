package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Bill
{
    static ArrayList<Product_POJO> l=new ArrayList<Product_POJO>();
    Connection c = new DBConnection().getConnection();

    public int AddtoCart(String product_name, int quantity)
    {
        try
        {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Products");
            while(rs.next())
            {
                if (rs.getString(2).equalsIgnoreCase(product_name))
                {
                    l.add(new Product_POJO(rs.getInt(1),rs.getString(2),rs.getInt(3)*quantity,quantity));
                    statement.executeUpdate("Update products set quantity = " + (rs.getInt(4)-quantity) + " where product_id = " + rs.getInt(1));
                    return 1;
                }
            }
        }
        catch(SQLException ecom)
        {
            System.out.println(ecom);
        }
        return 0;
    }
    public void billProduct()
    {
        int total = 0;
        System.out.println("\nProduct_name     Quantity      cost");
        for (Product_POJO p:l)
        {
            System.out.println(p);
            total +=p.getCost();
        }
        System.out.println("\nTotal Amount :                " +total);
    }
}
