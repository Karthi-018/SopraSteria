package edu.steria.branch.ecommerce;

import java.sql.*;
import java.util.Scanner;

public class Login {

    static int choice() {
        Scanner choose = new Scanner(System.in);
        System.out.print("Choose 1 for Admin OR Choose 2 for Customer: ");
        return choose.nextInt();
    }

    static boolean admin(){
        Connection connection=null;
        Scanner q=new Scanner(System.in);
        System.out.print("Enter User Name : ");
        String log=q.next();
        System.out.print("Enter Password : ");
        String pass=q.next();

        try {
            connection =DbConnection.getConnection();
            ResultSet rs;
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("Select * from admin where login='"+log+"' AND password='"+pass+"';");
            if(rs.next()) {
                String admin = rs.getString(1);
                String password = rs.getString(2);

                if (admin.equals(log) && password.equals(pass)) {
                    System.out.println("Login Successful");
                    System.out.println("-------------------------------------------------");
                    return true;
                }
                else {
                    System.out.println("Invalid Credentials!!");
                    Login.check();
                }
            }
            else {
                System.out.println("Invalid Credentials!!!");
                Login.check();
            }


        }
        catch(SQLException e ){
            System.out.println(e);
        }
        return false;

    }

    static boolean customerLogin(){
        Connection connection=null;
        Scanner q=new Scanner(System.in);
        System.out.print("Enter User Name : ");
        String log=q.next();
        System.out.print("Enter Password : ");
        String pass=q.next();

        try {
            connection =DbConnection.getConnection();
            ResultSet rs;
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("Select * from customer where login=\""+log+"\" AND password=\""+pass+"\";");

            if(rs.next()) {
                String customer = rs.getString(1);
                String password = rs.getString(2);

                if (customer.equals(log) && password.equals(pass)) {
                    System.out.println("Login Successful");
                    System.out.println("-------------------------------------------------");
                    return true;
                }
                else{
                    System.out.println("Invalid Credentials!!");
                    Login.check();
                }
            }
            else {
                System.out.println("Invalid Credentials!!!");
                Login.check();
            }

        }
        catch(SQLException e ){
            System.out.println(e);
        }
        return false;

    }

    static void customerRegister(){
        Connection connection=null;
        Scanner j=new Scanner(System.in);

        try {
            connection =DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement("insert into customer values(?,?)");
            System.out.print("Enter your name : ");
            ps.setString(1, j.next());
            System.out.print("Enter your password : ");
            ps.setString(2, j.next());
            ps.executeUpdate();

            System.out.println("Account is created!!");
            System.out.println("-------------------------------------------------");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    static int check(){
        Login log=new Login();
        int ans=0;

        Scanner p=new Scanner(System.in);
        int ch=log.choice();
        if(ch==1){
            if(log.admin())
                ans=1;
            else {
                System.out.println("Wrong User Name or Password");
                System.exit(0);
            }
        }
        else if(ch==2) {
            System.out.print("Login or Register? (log/reg) : ");
            String c = p.next();
            if(c.equals("log")) {
                if(log.customerLogin())
                    ans=2;
                else{
                    System.out.println("Wrong User Name or Password");
                    System.exit(0);
                }

            } else if(c.equals("reg")){
                log.customerRegister();
                System.out.println("Now, Login to your account!!");
                if(log.customerLogin())
                    ans=2;
                else{
                    System.out.println("Wrong User Name or Password");
                    System.exit(0);
                }
            }
            else
                System.out.println("Invalid option");
        }
        return ans;
    }





}
