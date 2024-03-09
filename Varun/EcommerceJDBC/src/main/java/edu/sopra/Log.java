package edu.sopra;

import java.sql.*;
import java.util.Scanner;

public class Log {

    Scanner sc=new Scanner(System.in);
    Connection c=null;
    PreparedStatement ps=null;
    public void login() {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / ecommerce","root","root");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        while(true) {
            System.out.println("Press 1 to login");
            System.out.println("Press 2 to exit");
            int var1 = sc.nextInt();
            if (var1 == 2) {
                break;
            }
            if (var1 == 1) {
                while (true) {
                    System.out.println("LOGIN :");
                    System.out.println("Press 1 for admin login");
                    System.out.println("Press 2 for Customer login");
                    System.out.println("Press 3 to go back to login");
                    int var2 = sc.nextInt();
                    if (var2 == 1) {
                        System.out.print("Username : ");
                        String var5 = sc.next();
                        System.out.print("Password : ");
                        String var6 = sc.next();
                        String access = "admin";
                        try {

                            ps = c.prepareStatement("select * from login where username=? and pswd=? and access=?");
                            ps.setString(1, var5);
                            ps.setString(2, var6);
                            ps.setString(3, access);
                            ResultSet rs = ps.executeQuery();
                            System.out.println("--------------------------");




                            if(rs.next()) {
                                if (rs.getString(1).equals(var5) && rs.getString(2).equals(var6) && rs.getString(3).equals(access)) {
                                    Admin ad = new Admin();
                                    while(true)
                                    {
                                        System.out.println("Press 1 to add a product");
                                        System.out.println("Press 2 to edit a product");
                                        System.out.println("Press 3 to list a product");
                                        System.out.println("Press 4 to delete a product");
                                        System.out.println("Press 5 to exit the admin module");
                                        System.out.println();
                                        System.out.println("----------------------------------------------------");
                                        int var7 = sc.nextInt();

                                        if(var7==1)
                                        {

                                            ad.add();
                                        }
                                        else if (var7==2)
                                        {
                                            System.out.println("Enter the product name to be updated : ");
                                            ad.edit(sc.next());
                                        }
                                        else if (var7==3)
                                        {
                                            ad.list();
                                        } else if (var7==4)
                                        {
                                            System.out.print("Enter the product name to be deleted :  ");
                                            ad.delete(sc.next());
                                        }
                                        else if(var7==5)
                                        {
                                            break;
                                        }
                                    }



                                }
                            }
                            else {
                                System.out.println("Username or Password is Incorrect");
                                break;
                            }


                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                    else if (var2 == 2) {

                        try {
//                            Class.forName("com.mysql.cj.jdbc.Driver");
//                            c = DriverManager.getConnection("jdbc:mysql:// localhost : 3306 / demo", "root", "root");
                            System.out.println("Press 1 to sign in");
                            System.out.println("Press 2 to sign up");
                            int var3 = sc.nextInt();
                            if (var3 == 2) {
                                System.out.print("Username : ");
                                String var5 = sc.next();
                                System.out.print("Password : ");
                                String var6 = sc.next();
                                String access="user";
                                ps=c.prepareStatement("insert into login values(?,?,?)");
                                ps.setString(1,var5);
                                ps.setString(2,var6);
                                ps.setString(3,access);
                                ps.executeUpdate();

                            } else if (var3 == 1) {


                                System.out.print("Username : ");
                                String var5 = sc.next();
                                System.out.print("Password : ");
                                String var6 = sc.next();
                                ps=c.prepareStatement("select * from login where username=? and pswd=?;");
                                ps.setString(1,var5);
                                ps.setString(2,var6);
                                ResultSet rs = ps.executeQuery();
                                String name=null;
                                String pswd=null;
                                if(rs.next())
                                {
                                    name = rs.getString(1);
                                    pswd = rs.getString(2);
                                    if (name.equals(var5) && pswd.equals(var6)) {


                                        while(true)
                                        {
                                            User us = new User();
                                            System.out.println("Press 1 to list the products");
                                            System.out.println("Press 2 to search a product");
                                            System.out.println("Press 3 to buy a product");
                                            System.out.println("Press 4 to exit customer module");
                                            System.out.println();
                                            System.out.println("----------------------------------------------------");
                                            int validate = sc.nextInt();
                                            if (validate == 1) {
                                                us.list();
                                            } else if (validate == 2) {
                                                System.out.println("Enter the product name");
                                                String s=sc.next();
                                                us.search(s);
                                            } else if (validate == 4) {
                                                break;
                                            } else if (validate==3) {

                                                System.out.println("Enter the product name  :   ");
                                                String searching=sc.next();
                                                us.buy(searching);
                                            }
                                        }
                                    }

                                }
                                else {
                                    System.out.println("invalid credentials");
                                }
                            }

                        } catch (Exception e) {
                            System.out.println(e);
                        }


                    }
                    else
                    {
                        break;
                    }

                }
            }

        }
    }


}
