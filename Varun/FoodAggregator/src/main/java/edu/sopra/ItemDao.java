package edu.sopra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ItemDao {

    Connection c=null;
    PreparedStatement ps=null;
    public void addItem(Item i)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / foodaggregator","root","root");
            ps=c.prepareStatement("insert into item values(?,?,?)");
            ps.setString(1,i.getName());
            ps.setDouble(2,i.getPrice());
            ps.setString(3,i.getType());
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void bulkCopy(List<Item> li)
    {
        for(int i=0;i<li.size();i++)
        {
            System.out.println(li.get(i));
            addItem(li.get(i));
        }
    }



    public List<Item> findItem(String type)
    {
        List<Item> l=new ArrayList<>();
        try
        {
            ps=c.prepareStatement("select * from item where type=?");
            ps.setString(1,type);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                l.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
                System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getDouble(2),rs.getString(3));
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return l;
    }



    public List<Item> findItem(double type)
    {
        List<Item> ll=new ArrayList<>();


        try
        {
            ps=c.prepareStatement("select * from item where price=?");
            ps.setDouble(1,type);
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                ll.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
                System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getDouble(2),rs.getString(3));
            }

        }
        catch(Exception e)
        {
            System.out.println(e);

        }

        return ll;
    }



}
