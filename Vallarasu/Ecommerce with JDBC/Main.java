package Ecommerce;
import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Ecommerce e = new Ecommerce();
        Admin a = new Admin();
        Product p = new Product();
        Customer c = new Customer();
        System.out.println("***************WELCOME TO ECOMMERCE WEBSITE***************");
        int n = 1;
        while (n != 0) {
            if (n == 1) {
                System.out.println("Enter the User Type:");
                System.out.println("1.Admin");
                System.out.println("2.Customer");
                System.out.println("3.Exit\n");
                String username, password;
                switch (in.nextInt()) {
                    case 1:
                        System.out.println("Enter the UserName:");
                        username = in.next();
                        System.out.println("Enter the Password:");
                        password = in.next();
                        if (e.adminLogin(username, password) == 1)
                            n = 2;
                        break;
                    case 2:
                        System.out.println("Enter the UserName:");
                        username = in.next();
                        System.out.println("Enter the Password:");
                        password = in.next();
                        if (e.customerLogin(username, password) == 1)
                            n = 3;
                        break;
                    case 3:
                        n = 0;
                        break;
                }
            }
            if (n == 2) {
                System.out.println("\nAdminHomePage");
                System.out.println("1.Add Product");
                System.out.println("2.Edit Product");
                System.out.println("3.List Product");
                System.out.println("4.Delete Product");
                System.out.println("5.Exit");
                switch (in.nextInt()) {
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
                System.out.println("\nCustomerHomePage");
                System.out.println("1.List Product");
                System.out.println("2.Search Product");
                System.out.println("3.Buy Product");
                System.out.println("4.Exit");
                switch (in.nextInt()) {
                    case 1:
                        System.out.println("\nList of Products:");
                        p.listProduct();
                        System.out.println();
                        break;
                    case 2:
                        c.searchProduct();
                        break;
                    case 3:
                        c.buyProduct();
                        break;
                    case 4:
                        System.out.println("Thanks for Using Ecommerce Website...");
                        n = 1;
                        break;
                }
            }
        }
    }
}