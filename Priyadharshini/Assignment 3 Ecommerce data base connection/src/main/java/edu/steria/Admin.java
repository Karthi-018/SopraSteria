package edu.steria;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
public class Admin {
    void addproduct(String[] product,int count) {
        try {
            Connection con = null;
            con = Dbconnection.getConnection();
            Statement s = con.createStatement();
            int k=1;
            for(int i=0;i<count;i++) {
                s.executeUpdate("Insert into product values("+(k++)+",'"+product[i]+"')");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void editproduct(int id,String newproduct) {
        try {
            Connection con = Dbconnection.getConnection();
            Statement s = con.createStatement();
            s.executeUpdate("UPDATE product SET name = '"+newproduct+"' WHERE num = "+id+"");
            System.out.println("Product updated successfully.");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        void listproduct ()
        {
            try {
                Connection con = null;
                con = Dbconnection.getConnection();
                Statement s = con.createStatement();
                ResultSet resultSet = s.executeQuery("select * from product");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        void deleteproduct(int deleteid)
        {
            try {
                Connection con = Dbconnection.getConnection();
                Statement s = con.createStatement();
                int rowsAffected = s.executeUpdate("DELETE FROM product WHERE num = "+deleteid+"");
                if (rowsAffected > 0) {
                    System.out.println("Product deleted successfully.");
                } else {
                    System.out.println("Product with ID not found.");
                }

            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }

    class Customer {
        void listproduct() {
            try {
                Connection con = null;
                con = Dbconnection.getConnection();
                Statement s = con.createStatement();
                ResultSet resultSet = s.executeQuery("select * from product");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

        void buyproduct(String buypro) {
            try {
                Connection con = null;
                con = Dbconnection.getConnection();
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("Select * from product where name='"+ buypro+"'");
                if (rs.next()) {
                    System.out.println("You can buy the product");
                    s.executeUpdate("DELETE FROM product WHERE name = '"+buypro+"'");
                    System.out.println("Product is bought");
                } else {
                    System.out.println("Out of stock");
                }
              }
            catch (SQLException e) {
                System.out.println(e);
            }


        }

        void searchproduct(String search) {
            try
            {
            Connection con = null;
            con = Dbconnection.getConnection();
            Statement s = con.createStatement();
            ResultSet resultSet = s.executeQuery("select * from product where name='"+search+"'");
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
            else {
                System.out.println("The product you searched for is not found");
            }
        }
            catch (SQLException e) {
            System.out.println(e);
        }

    }


        }


