package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
    Connection connection = null;
    Scanner sc = new Scanner(System.in);
    public void list() {
        try {

            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()) {
                System.out.println("---------------");
                System.out.println("Product Name : " + resultSet.getString(1));
                System.out.println("Product Desc : " + resultSet.getString(2));
               // System.out.println("Product Quantity : " + resultSet.getString(3));
                System.out.println("Product Price : " + resultSet.getString(4));
                System.out.println("---------------");

            }
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
               // System.out.println("Product Quantity : " + resultSet.getString(3));
                System.out.println("Product Price : " + resultSet.getString(4));
                System.out.println("---------------");
                return;
            }
            System.out.println("Product Not Found");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void buy(){
        System.out.print("Enter Product Name : ");
        String productName =sc.next();
        try{
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =null;
            resultSet  = statement.executeQuery("select quantinty from products where pname="+"'"+productName+"'");
           // System.out.println(resultSet);
            if(!resultSet.next()){
                System.out.println("Product Not Available");
                return;
            }
            int quantity = resultSet.getInt(1);
            System.out.print("Enter Quantity : ");
            int quant = sc.nextInt();
            if(quant>quantity){
                System.out.println("Product quantity not sufficient");
                return ;
            }
                if(quantity!=0){
                    statement.executeUpdate("update products set quantinty = quantinty-" +  quant +" where pname=" + "'" + productName + "'");
                    System.out.println("you bought "+productName);
                }
                else{
                    System.out.println("Product Not Available");
                }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
