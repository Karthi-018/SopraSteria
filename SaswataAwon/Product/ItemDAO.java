package Product;

import edu.steria.branch.ecommerce.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDAO {
    public void addItem(Item item){
        Connection connection= null;

        try{
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into item values(?,?,?)");
            ps.setString(1,item.getName());
            ps.setDouble(2,item.getPrice() );
            ps.setString(3,item.getType());

            ps.executeUpdate();
            System.out.println("--------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public void bulkCopy(List<Item> itemList)
    {
        System.out.println("Entering the product details into the database : ");
        for(int i=0;i<itemList.size();i++)
        {
            System.out.println(itemList.get(i));
            System.out.println("-------------------------------------------------------");
            addItem(itemList.get(i));
        }
    }

    public List<Item> findItem(String type){
        Scanner a=new Scanner(System.in);
        Connection connection=null;
        List<Item> list=new ArrayList<>();

        try {
            connection=DbConnection.getConnection();
            Statement statement= connection.createStatement();

            ResultSet rs= statement.executeQuery("Select * from item where type='"+type+"'");
            while(rs.next()){
                list.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
                System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getDouble(2),rs.getString(3));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        catch (NullPointerException e){
            System.out.println("No such item is present");
        }

        return list;
    }

    public List<Item> findItem(double price){
        Scanner a=new Scanner(System.in);
        Connection connection=null;
        List<Item> list=new ArrayList<>();

        try {
            connection=DbConnection.getConnection();
            Statement statement= connection.createStatement();

            ResultSet rs= statement.executeQuery("Select * from item where price="+price+";");
            while(rs.next()){
                list.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
                System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getDouble(2),rs.getString(3));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        catch (NullPointerException e){
            System.out.println("No such item is present");
        }

        return list;
    }


}
