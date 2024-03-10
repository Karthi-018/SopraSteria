package edu.steria.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductFunctionalities {
    static List<ProductPojo> productsList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    Connection connection=null;
    public void addProduct()
    {
        System.out.println("Give the following details \n1.Product Name\n2.Price\n3.Quantity");
        ProductPojo product=new ProductPojo(sc.next(),sc.nextDouble(),sc.nextInt());
        int n=0;
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("insert into products values(?,?,?)");
            ResultSet rs=p.executeQuery("select * from products");
            while(rs.next())
            {
                if(product.getName().equals(rs.getString(1)))
                {
                    System.out.println("Product already exist!!!");
                    n=1;
                    break;
                }
            }
            if(n==0)
            {
                p.setString(1,product.getName());
                p.setDouble(2,product.getPrice());
                p.setInt(3,product.getQuantity());
                productsList.add(product);
                p.executeUpdate();
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void listProduct()
    {
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
                System.out.println("\nProduct Name : "+rs.getString(1)+"\nPrice : "+rs.getDouble(2)+"\nQuantity : "+rs.getInt(3)+"\n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void editProduct(String name)
    {
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet rs = p.executeQuery();
            int n=0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    n=1;
                    PreparedStatement p1;
                    System.out.println("Enter the choice to edit product info\n1.Product name\n2.product prize\n3.product quantity");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter the new name:");
                            String newName=sc.next();
                            p1=connection.prepareStatement("update products set productName=? where productName=?");
                            p1.setString(1,newName);
                            p1.setString(2,rs.getString(1));
                            p1.executeUpdate();
                            System.out.println("\nupdated successfully ");
                            break;
                        case 2:
                            System.out.println("Enter the new Price:");
                            double newPrice=sc.nextDouble();
                            p1=connection.prepareStatement("update products set price=? where productName=?");
                            p1.setDouble(1,newPrice);
                            p1.setString(2, rs.getString(1));
                            p1.executeUpdate();
                            break;
                        case 3:
                            System.out.println("Enter the new quantity:");
                            int newQuantity=sc.nextInt();
                            p1=connection.prepareStatement("update products set quantity=? where productName=?");
                            p1.setInt(1,newQuantity);
                            p1.setString(2, rs.getString(1));
                            p1.executeUpdate();
                            break;
                        default:
                            System.out.println("Invalid choice!!");
                            break;
                    }
                    break;
                }
            }
            if(n==0) {
                System.out.println("Product not found!!!");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void searchProduct(String name)
    {
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet rs = p.executeQuery();
            int n = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    System.out.println("\n\nProduct Name:" + rs.getString(1) + "\nPrice:" + rs.getDouble(2) + "\nQuantity" + rs.getInt(3));
                    n = 1;
                    break;
                }
            }
            if (n == 0) {
                System.out.println("Product not found!!!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void removeProduct(String name)
    {
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet rs = p.executeQuery();
            int n = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    PreparedStatement p1 = connection.prepareStatement("delete from products where productName=?");
                    p1.setString(1, name);
                    p1.executeUpdate();
                    System.out.println("Product removed from the List");
                    n= 1;
                    break;
                }
            }
            if (n == 0) {
                System.out.println("Product not found!!!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void buyProduct(String name)
    {
        try {
            connection=DatabaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement("select * from products");
            ResultSet rs = p.executeQuery();
            int n = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    if(rs.getInt(3)!=0) {
                        System.out.println("product is available");
                        PreparedStatement ps1=connection.prepareStatement("update products set quantity=? where productName=?" );
                        ps1.setString(2,rs.getString(1));
                        ps1.setInt(1,rs.getInt(3)-1);
                        ps1.executeUpdate();
                        n = 1;
                        break;
                    }
                    else {
                        System.out.println("Product is not available!!");
                        p.executeUpdate("delete from where quantity=0");
                        break;
                    }
                }
            }
            if (n == 0) {
                System.out.println("Sorry ! Product not found");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
