package org.example;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Customer customer = new Customer();
        Connection connection = null;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Admin");
            System.out.println("2.Customer");
            System.out.print("Enter your Choice :");
            int choice = sc.nextInt();
            if (choice == 1) {
                while(true){
                    System.out.println("1.Sign Up");
                    System.out.println("2.Sign In");
                    System.out.println("3.Exit");
                    System.out.print("Enter your Choice : ");

                    int ch1 = sc.nextInt();
                    if(ch1 == 3)break;
                    String adminUsername;
                    String adminPassWord;
                    int adminNumber;

                    if(ch1 == 1){
                        System.out.print("Enter Username : ");
                        adminUsername = sc.next();
                        System.out.print("Enter Mobile Number : ");
                        adminNumber = sc.nextInt();
                        System.out.print("Enter password : ");
                        adminPassWord = sc.next();
                        try {
                            Connection connection2 = Dbconnection.getConnection();
                            PreparedStatement ps = connection2.prepareStatement("insert into admi values(?,?,?)");
                            ps.setString(1,adminUsername);
                            ps.setInt(2,adminNumber);
                            ps.setString(3,adminPassWord);
                            ps.execute();
                        }catch (SQLException e){
                            System.out.println(e);
                        }
                    } else if (ch1 == 2) {
                        System.out.print("Enter Username : ");
                        adminUsername = sc.next();
                        System.out.print("Enter password : ");
                        adminPassWord = sc.next();
                        try {
                            Connection connection1 = Dbconnection.getConnection();
                            Statement statement = connection1.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from admi");
                            boolean entry = false;
                            while (resultSet.next()){
                                if(resultSet.getString(1).equals(adminUsername) && Objects.equals(resultSet.getString(3), adminPassWord)){
                                    entry =true;
                                    break;
                                }
                            }
                            if(!entry){
                                System.out.println("Wrong Credentials");
                                continue;
                            }

                        } catch (SQLException e) {
                            System.out.println(e);
                        }

                    }
                    else{
                        System.out.println("wrong Entry");
                        continue;
                    }
                    while(true) {
                        System.out.println("-----------");
                        System.out.println("1.Add Product");
                        System.out.println("2.List Products");
                        System.out.println("3.Edit Products");
                        System.out.println("4.Search product");
                        System.out.println("5.Delete product");
                        System.out.println("6.Exit");
                        System.out.print("Enter your choice : ");
                        int ch2 = sc.nextInt();
                        if (ch2 == 6) {
                            break;
                        }
                        switch (ch2) {
                            case 1: {
                                admin.add();
                                break;
                            }
                            case 2: {
                                admin.list();
                                break;
                            }
                            case 3: {
                                admin.edit();
                                break;
                            }
                            case 4: {
                                admin.search();
                                break;
                            }
                            case 5: {
                                admin.delete();
                                break;
                            }

                            default: {
                                System.out.println("Wrong Entry");
                            }

                        }
                    }
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.println("1.Sign Up");
                    System.out.println("2.Sign In");
                    System.out.println("3.Exit");
                    System.out.print("Enter your Choice : ");

                    int ch1 = sc.nextInt();
                    if(ch1 == 3)break;
                    String custUsername;
                    String custPassWord;
                    int custNumber;

                    if (ch1 == 1) {
                        System.out.print("Enter Username : ");
                        custUsername = sc.next();
                        System.out.print("Enter Mobile Number : ");
                        custNumber = sc.nextInt();
                        System.out.print("Enter password : ");
                        custPassWord = sc.next();
                        try {
                            Connection connection2 = Dbconnection.getConnection();
                            PreparedStatement ps = connection2.prepareStatement("insert into customer values(?,?,?)");
                            ps.setString(1, custUsername);
                            ps.setInt(2, custNumber);
                            ps.setString(3, custPassWord);
                            ps.execute();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    } else if (ch1 == 2) {
                        System.out.print("Enter Username : ");
                        custUsername = sc.next();
                        System.out.print("Enter password : ");
                        custPassWord = sc.next();
                        try {
                            Connection connection1 = Dbconnection.getConnection();
                            Statement statement = connection1.createStatement();
                            ResultSet resultSet = statement.executeQuery("select * from customer");
                            boolean entry = false;
                            while (resultSet.next()) {
                                if (resultSet.getString(1).equals(custUsername) && Objects.equals(resultSet.getString(3), custPassWord)) {
                                    entry = true;
                                    break;
                                }
                            }
                            if (!entry) {
                                System.out.println("Wrong Credentials");
                                continue;
                            }else{
                                System.out.println("helooooo");
                            }

                        } catch (SQLException e) {
                            System.out.println(e);
                        }

                    } else {
                        System.out.println("wrong Entry");
                        continue;
                    }
                    while(true) {
                        System.out.println("------------");
                        System.out.println("1.List Products");
                        System.out.println("2.Search product");
                        System.out.println("3.Buy Product");
                        System.out.println("4.Exit");
                        System.out.print("Enter your choice : ");
                        int ch3 = sc.nextInt();
                        if (ch3 == 4) break;
                        switch(ch3){
                            case 1:{
                                customer.list();
                                break;
                            }
                            case 2:{
                                customer.search();
                                break;
                            }
                            case 3:{
                                customer.buy();
                                break;
                            }
                            default:{
                                System.out.println("Wrong Entry");
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}