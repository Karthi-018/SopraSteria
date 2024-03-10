package edu.steria.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EcomApp
{
    Connection conn = null;
    Scanner sc = new Scanner(System.in);

    public void register(String name, String pwd)
    {
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("select * from customerlogin where username = ?;");
            ps1.setString(1, name);
            ResultSet rs = ps1.executeQuery();
            if(rs.next())
            {
                System.out.println("OOPS!!! User already exists.........");
            }
            else
            {
                PreparedStatement ps = conn.prepareStatement("insert into customerlogin values(?,?);");
                ps.setString(1, name);
                ps.setString(2, pwd);
                ps.executeUpdate();
            }
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }


    }
    public boolean isValidate(String name, String pwd)
    {
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from customerlogin");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                if(name.equals(resultSet.getString(1)) && pwd.equals(resultSet.getString(2)))
                {
                    return true;
                }
            }
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }
        return false;
    }
     void addProduct()
    {
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?)");
            System.out.print("Enter Product Name: ");
            ps.setString(1,sc.next());
            System.out.print("Enter Product Price: ");
            ps.setInt(2, sc.nextInt());
            System.out.print("Enter Quantity: ");
            ps.setInt(3,sc.nextInt());

            ps.executeUpdate();
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }

    }

    void editProduct()
    {
        System.out.print("Enter Product name to edit: ");
        String name = sc.next();
        try
        {

            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from product where name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println("Update\n1.Price\n2.Quantity");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                if(ch==1)
                {
                    System.out.print("Enter Price: ");
                    PreparedStatement ps1 = conn.prepareStatement("Update product set price = ? where name = ?");
                    ps1.setInt(1,sc.nextInt());
                    ps1.setString(2,name);
                    ps1.executeUpdate();

                }
                else if(ch==2)
                {
                    System.out.print("Enter Quantity: ");
                    PreparedStatement ps2 = conn.prepareStatement("Update product set quantity = ? where name = ?");
                    ps2.setInt(1,sc.nextInt());
                    ps2.setString(2,name);
                    ps2.executeUpdate();
                }
                else
                {
                    System.out.println("Improper option");
                }

            }
            else
            {

                System.out.println("Product not Present");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }
    }

    public void viewProduct()
    {
        System.out.println("Product Details.........");
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from product");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                System.out.println("Name: " +resultSet.getString(1)+"\nPrice: "+resultSet.getInt(2)+ "\nQuantity: "+ resultSet.getInt(3)+"\n");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }


    }

    public void deleteProduct()
    {
        try
        {
            conn = DBConnection.getConnection();
            System.out.print("Enter the product you want to delete: ");
            String name = sc.next();
            PreparedStatement ps = conn.prepareStatement("delete from product where name = ?");
            ps.setString(1,name);
            int nr = ps.executeUpdate();
            if(nr!=0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("Product is not present");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }



    }

    public void searchProduct()
    {
        System.out.print("Enter Product name to search: ");
        String name = sc.next();
        try
        {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from product where name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println("Name: " +rs.getString(1)+"\nPrice: "+rs.getInt(2)+ "\nQuantity: "+ rs.getInt(3)+"\n");

            }
            else
            {
                System.out.println("Product not found");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }

    }


    public void buyProduct()
    {
        System.out.print("Enter the Product you want to buy: ");
        String name = sc.next();
        try
        {

            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from product where name = ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {

                int quantity = rs.getInt(3);
                int price = rs.getInt(2);

                System.out.println("Name: " +name+"\nPrice: "+price+ "\nQuantity: "+ quantity+"\n");

                System.out.print("Enter the quantity you want to buy: ");
                int q = sc.nextInt();
                if(q>quantity)
                {
                    System.out.println("Out of stock");
                }
                else
                {
                    System.out.println("Product bought");
                    System.out.println("Product name: "+name+"\nTotal Price: "+(price*q)+"\nQuantity: "+q);
                    if(q==quantity)
                    {
                        PreparedStatement ps1 = conn.prepareStatement("delete from product where name = ?");
                        ps1.setString(1,name);
                        ps1.executeUpdate();
                    }
                    else
                    {
                        PreparedStatement ps2 = conn.prepareStatement("Update product set quantity = ? where name = ? ");
                        ps2.setInt(1, (quantity-q));
                        ps2.setString(2, name);
                        ps2.executeUpdate();
                    }
                }
            }

            else
            {
                System.out.println("Product not found");
            }
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println(e);
            }
        }

    }
}



