package edu.steria;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin ad = new Admin();
        Customer c = new Customer();
//        Connection con=null;
//        con =Dbconnection.getConnection();
        System.out.println("Enter your username...");
        String username = sc.next();
        System.out.println("Enter your password...");
        String password = sc.next();
        if (password.equals("Reset@123")) {
            System.out.println("Enter the option...");
            System.out.println("1. Admin\n2. Customer");
            int opt = sc.nextInt();
            boolean test=true;
            switch (opt) {
                case 1:
                    while(test) {
                        System.out.println("Enter the method to be done..");
                        System.out.println("a.add\nb.edit\nc.list\nd.delete");
                        char choice = sc.next().charAt(0);
                        switch (choice) {
                            case 'a':
                                System.out.println("Enter the number of product should be added.");
                                int count=sc.nextInt();
                                String product[]=new String[count];
                                System.out.println("Enter the product values..");
                                for(int i=0;i<count;i++)
                                {
                                    product[i]=sc.next();
                                }
                                ad.addproduct(product,count);
                                break;
                            case 'b':
                                System.out.println("Enter the product id should be edited");
                                int id=sc.nextInt();
                                System.out.println("Enter the new product value");
                                String newproduct=sc.next();
                                ad.editproduct(id,newproduct);
                                break;
                            case 'c':
                                ad.listproduct();
                                break;
                            case 'd':
                                System.out.println("Enter the product id should be deleted");
                                int deleteid=sc.nextInt();
                                ad.deleteproduct(deleteid);
                                test=false;
                                break;

                        }
                    }

                case 2:
                    while(test) {
                        System.out.println("Enter the method to be done..");
                        System.out.println("a.list\nb.search\nc.buy");
                        char choice = sc.next().charAt(0);
                        switch (choice) {
                            case 'a':
                                c.listproduct();
                                break;
                            case 'b':
                                System.out.println("Enter the product should be searched..");
                                String search=sc.next();
                                c.searchproduct(search);
                                break;
                            case 'c':
                                System.out.println("Name the product you want to buy..");
                                String buypro=sc.next();
                                c.buyproduct(buypro);
                                test=false;
                                break;
                        }
                    }

            }
        } else {
            System.out.println("Incorrect password!");
        }
    }
}