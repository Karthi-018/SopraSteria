package edu.steria.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDAO {
    Scanner sc =new Scanner(System.in);
    //List<Item> item_list=new ArrayList<>();
    Connection c=null;
    public void addItem(Item item)
    {
       try
       {
           c=DbConnection.getConnection();
           PreparedStatement p=c.prepareStatement("insert  into fooditems values(?,?,?)");
           p.setString(1,item.getItem_name());
           p.setDouble(2,item.getPrice());
           p.setString(3,item.getType());
           p.executeUpdate();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
    public void bulkCopy(List<Item> itemList)
    {
        for(int i=0;i<itemList.size();i++)
        {
            addItem(itemList.get(i));
        }
    }
    public void findItem(String type)
    {
        try{
            c=DbConnection.getConnection();
            PreparedStatement p=c.prepareStatement("select * from fooditems");
            ResultSet r=p.executeQuery();
            int flag=0;
            while(r.next())
            {
                if(r.getString(3).equals(type))
                {
                      flag=1;
                      break;
                }
            }
            if(flag==1)
            {
                System.out.println("    Food Type :"+type+"\nITEM        Price");
                PreparedStatement p1=c.prepareStatement("select itemName,price from fooditems where type=?");
                p1.setString(1,type);
                ResultSet rs=p1.executeQuery();
                while(rs.next())
                {
                    System.out.println(rs.getString(1)+"        "+rs.getDouble(2));
                }
            }
            else {
                System.out.println("No such type of item is present !!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void findItem1(double price)
    {
        try{
            c=DbConnection.getConnection();
            PreparedStatement p=c.prepareStatement("select * from fooditems");
            ResultSet r=p.executeQuery();
            int flag=0;
            while(r.next())
            {
                if(r.getDouble(2)==price)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                PreparedStatement p1=c.prepareStatement("select * from fooditems where price=?");
                p1.setDouble(1,price);
                ResultSet rs=p1.executeQuery();
                while(rs.next())
                {
                    System.out.println("Food Item:"+rs.getString(1)+"\nPrice:"+rs.getDouble(2)+"\nType:"+rs.getString(3)+"\n");
                }
            }
            else {
                System.out.println("No such item is present !!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
