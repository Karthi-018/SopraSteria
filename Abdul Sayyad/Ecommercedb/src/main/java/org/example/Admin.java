package org.example;

import java.sql.*;
import java.util.Scanner;

public class Admin {
    Connection connection = null;
    Scanner sc = new Scanner(System.in);
    public void add() {
        System.out.println("---------------");

        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();
        System.out.print("Enter Product Description: ");

        String productDesc = sc.nextLine();
        System.out.print("Enter Product Quantity: ");

        int productQuantity = sc.nextInt();
        System.out.print("Enter Product Price: ");
        int productPrice = sc.nextInt();
        System.out.println("---------------");

        try {
            connection = Dbconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into products values(?,?,?,?)");
            ps.setString(1, productName);
            ps.setString(2, productDesc);
            ps.setInt(3, productQuantity);
            ps.setInt(4, productPrice);
            ps.execute();
            System.out.println("---------------");
            System.out.println("product Added");
            System.out.println("---------------");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void search(){
        System.out.print("Enter Product Name : ");
        String productName = sc.next();
        try {

            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products where pname =" + "'" + productName+"'");
            while (resultSet.next()) {
                System.out.println("---------------");
                System.out.println("Product Name : " + resultSet.getString(1));
                System.out.println("Product Desc : " + resultSet.getString(2));
                System.out.println("Product Quantity : " + resultSet.getString(3));
                System.out.println("Product Price : " + resultSet.getString(4));
                System.out.println("---------------");
                return;
            }
            System.out.println("Product Not Found");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void list() {
        try {
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()) {
                System.out.println("---------------");
                System.out.println("Product Name : " + resultSet.getString(1));
                System.out.println("Product Desc : " + resultSet.getString(2));
                System.out.println("Product Quantity : " + resultSet.getString(3));
                System.out.println("Product Price : " + resultSet.getString(4));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void delete(){
        System.out.print("Enter Product Name:");
        String productName = sc.nextLine();
        try {
            connection = Dbconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from products where pname = ?");
            ps.setString(1,productName);
            ps.execute();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void edit(){
        int productQuantity = 0;
        int productPrice = 0;
        System.out.print("Enter Product Name : ");
        String productName = sc.next();
        System.out.println("1.Edit Quantity");
        System.out.println("2.Edit Price");
        System.out.print("Enter your Choice : ");
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.print("Enter new quantity : ");
             productQuantity = sc.nextInt();
        }
        else if(choice == 2) {
            System.out.print("Enter new Price : ");
             productPrice = sc.nextInt();
        }
        else{
            System.out.println("Wrong Entry");
            return;
        }
        try {
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =null;
            resultSet  = statement.executeQuery("select name from products where pname="+"'"+productName+"'");
            // System.out.println(resultSet);
            if(!resultSet.next()){
                System.out.println("Product Not Available");
                return;
            }
            if(choice == 1) {
                PreparedStatement ps = connection.prepareStatement("Update products set quantinty=? where pname =?");
                ps.setInt(1, productQuantity);
                ps.setString(2, productName);
                ps.execute();
            }
            else if(choice == 2){
                PreparedStatement ps1 = connection.prepareStatement("Update products set price=? where pname =?");
                ps1.setInt(1, productPrice);
                ps1.setString(2, productName);
                ps1.execute();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}

