package Ecommerce;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Bill {
    static ArrayList<ProductDAO> l=new ArrayList<ProductDAO>();
    Connection c = new DbConnection().getConnection();

    public void AddToCart(String pname,int quantity)
    {
        try{
            Statement statement=c.createStatement();
            ResultSet resultset= statement.executeQuery("SELECT * FROM Product");
            while(resultset.next())
            {
                if(resultset.getString(2).equalsIgnoreCase(pname))
                {
                    l.add(new ProductDAO(resultset.getInt(1),resultset.getString(2),
                            resultset.getInt(3)*quantity,quantity));
                    statement.executeUpdate("UPDATE PRODUCT SET quantity=" + (resultset.getInt(4)-quantity) + " WHERE pid="+resultset.getInt(1));
                    break;
                }
            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public void BillProduct(){
        int total=0;
        for(ProductDAO p:l)
        {
            System.out.println(p);
            total+=p.getCost();
        }
        System.out.println("Total Cost: "+total);
    }
}
