package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.*;

public class ProductServices {
    static Scanner scan = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();

    Connection connection = null;
    int flag = 0;
    public void signUp()
    {
        System.out.println("***SIGN UP***");
        System.out.println("Enter user name:");
        String userName = scan.next();
        System.out.println("Create password:");
        String password = scan.next();
        //Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into login_details values(?,?)");
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.executeUpdate();
            login();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void login() {
        System.out.println("***LOGIN***");
        System.out.println("Enter user name:");
        String userName = scan.next();
        System.out.println("Enter password:");
        String password = scan.next();
        flag = 0;
        try {
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from login_details");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(userName) && rs.getString(2).equals(password)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Username or password does not match");
                signUp();
            } else {
                System.out.println("Login Successful!!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

        public void buyProduct(String name)
        {
            try {
                connection = DbConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement("select * from products");
                ResultSet rs = ps.executeQuery();
                flag = 0;
                int i=0;
                while (rs.next()) {
                    if (rs.getString(1).equals(name)) {
                        int originalQuantity = rs.getInt(3);
                        System.out.println("Adding product to cart");
                        ps.executeUpdate("update products set quantity="+(originalQuantity-1));
                        flag = 1;
                        break;
                    }
                    i++;
                }
                if (flag == 0) {
                    System.out.println("Product not found");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

    public void addProduct() {
        System.out.println("Enter the following details:\n1.Product Name\n2.Product Prize\n3.Product quantity");
        Product p = new Product(scan.next(),scan.nextInt(),scan.nextInt());
        //productsList.add(p);
        flag=0;
        try {
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into products values(?,?,?)");
            ps.setString(1,p.getProductName());
            ps.setInt(2,p.getPrice());
            ps.setInt(3,p.getQuantity());
            ResultSet rs = ps.executeQuery("select * from products");
            while(rs.next())
            {
                if(p.getProductName().equals(rs.getString(1)))
                {
                    System.out.println("Product already exist!!!");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                productsList.add(p);
                ps.executeUpdate();
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void listProduct() {
        try {
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(rs.getInt(3)==0)
                {
                    deleteProduct(rs.getString(1));
                }
                System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getString(2),rs.getString(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editProduct(String name) {
        try {
            connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from products where name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                PreparedStatement ps1;
                System.out.println("What information do you want to edit?\n1. Product name\n2. Product price\n3. Product quantity");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the new name:");
                        String newName = scan.next();
                        ps1 = connection.prepareStatement("update products set name = ? where name = ?");
                        ps1.setString(1, newName);
                        ps1.setString(2, rs.getString(1));
                        ps1.executeUpdate();
                        break;
                    case 2:
                        System.out.println("Enter the new Price:");
                        int newPrice = scan.nextInt();
                        ps1 = connection.prepareStatement("update products set price = ? where name = ?");
                        ps1.setInt(1, newPrice);
                        ps1.setString(2, rs.getString(1));
                        ps1.executeUpdate();
                        break;
                    case 3:
                        System.out.println("Enter the new quantity:");
                        int quantity = scan.nextInt();
                        ps1 = connection.prepareStatement("update products set quantity = ? where name = ?");
                        ps1.setInt(1, quantity);
                        ps1.setString(2, rs.getString(1));
                        ps1.executeUpdate();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } else {
                System.out.println("Product not found!!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchProduct(String name) {

        try {
            connection=DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            flag = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    System.out.format("%-20s %-5s %s\n",rs.getString(1),rs.getString(2),rs.getString(3));
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Product not found!!!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void deleteProduct(String name) {

        try {
            connection=DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            flag = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    PreparedStatement ps1 = connection.prepareStatement("delete from products where name=?");
                    //ps1.setString(1, productsList.get(i).getName());
                    ps1.setString(1, name);
                    ps1.executeUpdate();
                    //System.out.println("Product deleted from the record");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Product not found");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
