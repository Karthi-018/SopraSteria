package edu.steria.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    Connection connection=null;
    Scanner sc=new Scanner(System.in);


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void signUp(String user)
    {
        System.out.println("*****  SIGN UP  *****\n");
        System.out.println("Set userName:");
        String uname=sc.next();
        System.out.println("Set password:");
        String upassword=sc.next();
        try {
            connection = DatabaseConnection.getConnection();
            int flag=0;
            PreparedStatement ps = connection.prepareStatement("insert into logInDetails values(?,?)");
            ResultSet rs=ps.executeQuery("select * from logInDetails");
            while(rs.next())
            {
                if(rs.getString(1).equals(uname))
                {
                    System.out.println("User already exist!!");
                    logIn(user);
                    flag=1;
                    break;
                }

            }
            if(flag==0) {
                this.username=uname;
                this.password=upassword;
                ps.setString(1, this.getUsername());
                ps.setString(2, this.getPassword());
                ps.executeUpdate();
                logIn(user);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public void logIn(String user) {
        System.out.println("*****  LOG IN  *****\n");
        System.out.println("Enter userName:");
        String uname = sc.next();
        System.out.println("Enter password:");
        String upassword = sc.next();
        int flag = 0;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from logInDetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(uname) && rs.getString(2).equals(upassword)) {
                    System.out.println("Logged in successfully!!\n");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                ProductFunctionalities p = new ProductFunctionalities();
                if(user.equals("admin")) {
                    int n = 0;
                    while (n == 0) {
                        System.out.println("\n1.Add product\n2.Edit product\n3.List product\n4.Remove product\n5.Exit\n");
                        System.out.println("Enter your choice: ");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Enter no of products you want to add: ");
                                for (int i = 0; i < sc.nextInt(); i++) {
                                    p.addProduct();
                                }
                                break;
                            case 2:
                                System.out.println("Enter the product to edit:");
                                p.editProduct(sc.next());
                                break;
                            case 3:
                                p.listProduct();
                                break;
                            case 4:
                                System.out.println("Enter the product to remove:");
                                p.removeProduct(sc.next());
                                break;
                            case 5:
                                n = 1;
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }
                }
                else {
                    int n = 0;
                    while (n == 0) {
                        System.out.println("\n1.List product\n2.Search product\n3.Buy product\n4.Exit\n");
                        System.out.println("Enter your choice: ");
                        switch (sc.nextInt()) {
                            case 2:
                                System.out.println("Enter the product to search ");
                                p.searchProduct(sc.next());
                                break;
                            case 3:
                                p.listProduct();
                                System.out.println("\nEnter the product in the list to buy:");
                                p.buyProduct(sc.next());
                                break;
                            case 1:
                                p.listProduct();
                                break;
                            case 4:
                                n = 1;
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }
                }
            }
            else {
                System.out.println("Invalid username or password!!! Try to log in with correct credentials");
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
