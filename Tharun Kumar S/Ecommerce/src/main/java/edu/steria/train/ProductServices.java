package edu.steria.train;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ProductServices {
    static List<Products> productsList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    Connection c=null;

    public void addProduct()
    {
        System.out.println("Enter the following details one by one\n1.Product Name\n2.Product Prize\n3.Product quantity");
        Products p=new Products(sc.next(),sc.nextDouble(),sc.nextInt());
        int flag=0;
        try {
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("insert into products values(?,?,?)");
            ps.setString(1,p.getName());
            ps.setDouble(2,p.getPrice());
            ps.setInt(3,p.getQuantity());
            ResultSet rs=ps.executeQuery("select * from products");
            while(rs.next())
            {
                if(p.getName().equals(rs.getString(1)))
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
    public void listProduct()
    {
        try {
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println("\n****************\n"+rs.getString(1)+"\n"+rs.getDouble(2)+"\n"+rs.getInt(3));
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
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            int flag=0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    flag=1;
                    PreparedStatement ps1;
                    System.out.println("What information do you want to edit?\n1.Product name\n2.product prize\n3.product quantity");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter the new name:");
                            String newName=sc.next();
                            ps1=c.prepareStatement("update products set productName=? where productName=?");
                            ps1.setString(1,newName);
                            ps1.setString(2,rs.getString(1));
                            ps1.executeUpdate();
                            System.out.println("updated successfully ");
                            break;
                        case 2:
                            System.out.println("Enter the new Prize:");
                            double newPrice=sc.nextDouble();
                            ps1=c.prepareStatement("update products set price=? where productName=?");
                            ps1.setDouble(1,newPrice);
                            ps1.setString(2, rs.getString(1));
                            ps1.executeUpdate();
                            break;
                        case 3:
                            System.out.println("Enter the new quantity:");
                            int newQuant=sc.nextInt();
                            ps1=c.prepareStatement("update products set quantity=? where productName=?");
                            ps1.setInt(1,newQuant);
                            ps1.setString(2, rs.getString(1));
                            ps1.executeUpdate();
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                }
            }
            if(flag==0) {
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
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            int flag = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    System.out.println("\n****************\n" + rs.getString(1) + "\n" + rs.getDouble(2) + "\n" + rs.getInt(3));
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
    public void deleteProduct(String name)
    {
        try {
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            int flag = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    PreparedStatement ps1 = c.prepareStatement("delete from products where productName=?");
                    ps1.setString(1, name);
                    ps1.executeUpdate();
                    System.out.println("Product deleted from the record");
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
    public void buyProduct(String name)
    {
        try {
            c=DbConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();
            //PreparedStatement ps1=c.prepareStatement("update products set ?=?");
            int flag = 0;
            while (rs.next()) {
                if (rs.getString(1).equals(name)) {
                    if(rs.getInt(3)!=0) {
                        System.out.println("product is available");
                        PreparedStatement ps1=c.prepareStatement("update products set quantity=? where productName=?" );
                        ps1.setString(2,rs.getString(1));
                        ps1.setInt(1,rs.getInt(3)-1);
                        ps1.executeUpdate();
                        flag = 1;
                        break;
                    }
                    else {
                        System.out.println("Product is not available!!");
                        ps.executeUpdate("delete from where quantity=0");
                        break;
                    }
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

