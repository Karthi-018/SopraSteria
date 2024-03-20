package edu.assign;
import java.util.*;
import java.sql.*;

public class Main {
	
	
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);

        Ecommerce e = new Ecommerce();
        Admin a = new Admin();
        Product p = new Product();
        Customer c = new Customer();
        System.out.println("WELCOME TO OUR STORE \n");
        int n = 1;
        while (n != 0) {
            if (n == 1) {
                System.out.println("Enter the User Type: \n");
                System.out.println("1.Admin");
                System.out.println("2.Customer");
                System.out.println("3.Exit\n");
                String username, password;
                switch (inp.nextInt()) {
                    case 1:
                        System.out.println("Enter the UserName:");
                        username = inp.next();
                        System.out.println("Enter the Password:");
                        password = inp.next();
                        if (e.adminLogin(username, password) == 1)
                            n = 2;
                        break;
                    case 2:
                        System.out.println("Enter the UserName:");
                        username = inp.next();
                        System.out.println("Enter the Password:");
                        password = inp.next();
                        if (e.customerLogin(username, password) == 1)
                            n = 3;
                        break;
                    case 3:
                        n = 0;
                        break;
                }
            }
            if (n == 2) {
                System.out.println("\nAdmin Home Page \n");
                System.out.println("1.Add Product");
                System.out.println("2.Edit Product");
                System.out.println("3.List Product");
                System.out.println("4.Delete Product");
                System.out.println("5.Exit \n");
                switch (inp.nextInt()) {
                    case 1:
                        a.addProduct();
                        break;
                    case 2:
                        p.listProduct();
                        System.out.println();
                        a.editProduct();
                        break;
                    case 3:
                        System.out.println("\nList of Products:");
                        p.listProduct();
                        System.out.println();
                        break;
                    case 4:
                        p.listProduct();
                        a.deleteProduct();
                        break;
                    case 5:
                        n = 1;
                        break;
                }
            }
            if (n == 3) {
                System.out.println("\nCustomer Home Page");
                System.out.println("1.List Product");
                System.out.println("2.Search Product");
                System.out.println("3.Exit");
                switch (inp.nextInt()) {
                    case 1:
                        System.out.println("\nList of Products:");
                        p.listProduct();
                        System.out.println();
                        break;
                    case 2:
                        c.searchProduct();
                        break;
                    case 3:
                        System.out.println("Thank you for Visiting Us...");
                        n = 1;
                        break;
                }
            }
        }
    }

}
