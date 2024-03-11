package org.example;

import java.sql.*;
import java.util.Scanner;

public class Ecomm {
    static Connection conn = null;

    public static void addcus() {
        try {

            Scanner sc = new Scanner(System.in);
            conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into customers values(?,?)");
            System.out.println("Enter username: ");
            ps.setString(1, sc.next());
            System.out.println("Enter  password: ");
            ps.setString(2, sc.next());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
//            Connection conn = null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static boolean cuslog(String uname, String password) {
        try {

            Scanner sc = new Scanner(System.in);
            conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select*from customers where username=? and password=?");
            ps.setString(1, uname);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
//            Connection conn = null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return false;
    }

    public static void add() {

        try
        {

            Scanner sc = new Scanner(System.in);
            conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into products values(?,?,?,?)");
            System.out.println("Enter product id: ");
            ps.setInt(1, sc.nextInt());
            System.out.println("Enter  Name: ");
            ps.setString(2, sc.next());
            System.out.println("Enter  price: ");
            ps.setInt(3, sc.nextInt());
            System.out.println("Enter quantity: ");
            ps.setInt(4, sc.nextInt());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally {
            try{
//            Connection conn = null;
                conn.close();
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public static void show() {

        try{

            conn=DbConnection.getConnection();
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from products");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                //Connection conn= null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public static void update() {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter name of product that need to be updated :");
        String proname =sc.nextLine();
        System.out.println("enter product new  price");
        int price=sc.nextInt();
        try{
            conn=DbConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("update products set price = "+price+" where pname = '"+proname+"';");
            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                // Connection conn=null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public static void delete() {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter product name you want to delete :");
        String proname =sc.nextLine();
        try{
            conn=DbConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("delete from products where pname = '"+proname+"'");
            ps.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                // Connection conn=null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public static void search() {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter product name to search :");
        String proname=sc.nextLine();
        try{
            conn=DbConnection.getConnection();
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from products where pname ='"+proname+"';");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                // Connection conn=null;
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    public static void buy() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter product name :");
        String proname = sc.nextLine();
        try {
            conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            int exe = st.executeUpdate("update products set quantity = quantity -1 where pname = '" + proname + "'");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }    }
}
