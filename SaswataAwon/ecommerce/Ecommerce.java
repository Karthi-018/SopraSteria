package edu.steria.branch.ecommerce;

import java.sql.*;
import java.util.Scanner;

public class Ecommerce {


    public static void addItem(){
        Scanner a= new Scanner(System.in);
        Connection connection= null;

        try {
            connection = DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement("insert into product values(?,?,?,?,?)");
            System.out.print("Enter the ProductId : ");
            ps.setInt(1, a.nextInt());
            System.out.print("Enter the Item Name : ");
            ps.setString(2, a.next());
            System.out.print("Enter the Price : ");
            ps.setInt(3, a.nextInt());
            System.out.print("Enter the Description : ");
            ps.setString(4, a.next());
            System.out.print("Enter the quantity : ");
            ps.setInt(5, a.nextInt());


            ps.executeUpdate();
            System.out.println(" Product Details is added successfully");
            System.out.println("-------------------------------------------------");
        }

        catch (SQLException e){
            System.out.println(e);
        }


    }

    public static void edit(){
        Scanner a= new Scanner(System.in);
        Connection connection= null;
        System.out.println("Enter the productID you want to edit : ");
        int id=a.nextInt();





        try {
            connection = DbConnection.getConnection();
            Statement statement= connection.createStatement();
            System.out.println("The list of items: ");
            ResultSet rs= statement.executeQuery("Select * from product");
            while(rs.next()){
                System.out.println("Product ID : "+rs.getInt(1)+"\nProduct Name : "+rs.getString(2)+"\nProduct price : "+rs.getInt(3)+"\nProduct Description : "+rs.getString(4)+"\nProduct quantity : "+rs.getInt(5));
                System.out.println("----------------------------------------");
            }
            System.out.println("Which data index you want to change (1 for price/2 for quantity) ? : ");
            int w=a.nextInt();
             if(w==1) {
                System.out.println("Enter the new price : ");
                int cost=a.nextInt();
                PreparedStatement ps = connection.prepareStatement("update product set price = "+cost+" where productID= " + w + ";");
                ps.executeUpdate();
                System.out.println("Product price is edited");
                System.out.println("------------------------------------------------------");
            }


            else if(w==2) {
                System.out.println("Enter the new quantity : ");
                int qua=a.nextInt();
                if(qua!=0) {
                    PreparedStatement ps = connection.prepareStatement("update product set quantity = " + qua + " where productID= " + w + ";");
                    ps.executeUpdate();
                    System.out.println("Product name is edited");
                    System.out.println("------------------------------------------------------");
                }
                else{
                    System.out.println("Product quantity can't be 0 or product not found");

                    System.out.println("------------------------------------------------------");
                }
            }

        }

        catch (SQLException e){
            System.out.println(e);
        }
    }

 //   delete from table product where productId=" + id +"
    public static void delete(){
        Connection connection= null;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the product ID you want to delete : ");
        int id=s.nextInt();
        try {
            connection =DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from product where productId= " + id + ";");
            ps.executeUpdate();
            System.out.println("Product details is deleted successfully");
            System.out.println("------------------------------------------------------");
        }
        catch(SQLException e ){
            System.out.println(e);
        }
    }

    public static void list(){
        Connection connection= null;

        try {
            connection =DbConnection.getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery("Select * from product");
            while(rs.next()){
                System.out.println("Product ID : "+rs.getInt(1)+"\nProduct Name : "+rs.getString(2)+"\nProduct price : "+rs.getInt(3)+"\nProduct Description : "+rs.getString(4)+"\nProduct quantity : "+rs.getInt(5));
                System.out.println("----------------------------------------");
            }
        }
        catch(SQLException e ){
            System.out.println(e);
        }
    }

}
