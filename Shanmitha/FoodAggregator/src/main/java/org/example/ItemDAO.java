package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ItemDAO {
    static Scanner sc = new Scanner(System.in);
//    public void addItem(){
//        Item item = new Item();
//
//        System.out.println("Enter Item Name:");
//        String name = sc.next();
//
//        System.out.println("Enter Item price:");
//        int price = sc.nextInt();
//
//        System.out.println("Enter Item type:");
//        String type = sc.next();
//
//        item.setName(name);
//        item.setPrice(price);
//        item.setType(type);
//
//        System.out.println(item);
//    }
    public void addItem(String itemString)
    {
        List<String> items = Arrays.asList(itemString.split(","));
        Connection connection = null;
        try
        {
            connection = DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement("insert into items values(?,?,?)");

            ps.setString(1, items.get(0));
            ps.setDouble(2, Double.parseDouble(items.get(1)));
            ps.setString(3, items.get(2));
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void bulkCopy(ArrayList<String> itemList)
    {
        for (String i: itemList)
        {
            addItem(i);
        }
    }
    public void findItem(String type)
    {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement("select * from items where type = ?");
            ps.setString(1,type);
            ResultSet rs = ps.executeQuery();
            if (!rs.next() ) {
                System.out.println("No such item present");
            }
            else {
                do {
                    String col1 = rs.getString(1);
                    double col2 = rs.getDouble(2);
                    String col3 = rs.getString(3);
                    System.out.format("%-20s %-5s %s\n",col1,col2,col3);
                    //System.out.println(rs.getString(1) + " " + rs.getDouble(2) + " " + rs.getString(3));
                }while (rs.next());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void findItem(double price)
    {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement("select * from items where price = ?");
            ps.setDouble(1,price);
            ResultSet rs = ps.executeQuery();
            if (!rs.next() ) {
                System.out.println("No such item present");
            }
            else {
                do {
                    String col1 = rs.getString(1);
                    double col2 = rs.getDouble(2);
                    String col3 = rs.getString(3);
                    System.out.format("%-20s %-5s %s\n",col1,col2,col3);
                    //System.out.println(rs.getString(1) + " " + rs.getDouble(2) + " " + rs.getString(3));
                }while (rs.next());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
