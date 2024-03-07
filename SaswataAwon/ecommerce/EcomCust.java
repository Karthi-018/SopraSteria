package edu.steria.branch.ecommerce;

import java.sql.*;
import java.util.Scanner;

public class EcomCust {

    static void show(){
        Connection connection= null;

        try {
            connection =DbConnection.getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery("Select * from product");
            while(rs.next()){
                System.out.println("Product Name : "+rs.getString(2)+"\nProduct price : "+rs.getInt(3)+"\nProduct Description : "+rs.getString(4));
                System.out.println("----------------------------------------");
            }
        }
        catch(SQLException e ){
            System.out.println(e);
        }
    }

    static void search(){
        Scanner d=new Scanner(System.in);
        Connection connection=null;

        try{
            connection= DbConnection.getConnection();
            Statement statement=connection.createStatement();
            System.out.print("Enter the product you want to search : ");
            String pName=d.next();
            ResultSet rp = statement.executeQuery("Select * from product where name = '"+pName+"';");
            while(rp.next()){
                System.out.println("Product Name : "+pName+"\nProduct price : "+rp.getInt(3)+"\nProduct Description : "+rp.getString(4));
                System.out.println("----------------------------------------");
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    static void buy(){
        Scanner b=new Scanner(System.in);
        Connection connection=null;

        try {
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            System.out.print("Name of the product you want to buy : ");
            String bName = b.next();
            ResultSet rp = statement.executeQuery("Select * from product where name = '" + bName + "';");
            String product = null;
            if (rp.next()) {
                product = rp.getString(2);
            }

            System.out.print("Confirm to buy (y/n): ");
            String confirm = b.next();

            if (confirm.equals("y") && product.equals(bName)) {
                PreparedStatement ps = connection.prepareStatement("update product set quantity=quantity-1 where name = '" + bName + "' AND quantity>=0;");
                PreparedStatement pr = connection.prepareStatement("delete from product where quantity=0;");
                ps.executeUpdate();
                pr.executeUpdate();
                System.out.println("Congratulations!! Order confirmed for : " + bName);
                System.out.println("------------------------------------------------------");
            } else {
                System.out.println("Search for more options");
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        catch(NullPointerException e){
            System.out.println("Product not found");
            System.out.println("------------------------------------------------------");
        }
    }
}
