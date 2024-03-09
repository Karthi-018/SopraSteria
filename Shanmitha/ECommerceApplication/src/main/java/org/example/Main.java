package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("****HOME PAGE****");
        System.out.println("Enter\n 1.Admin\n 2.Customer\n 3.Exit");
        while(true) {
            switch (scan.nextInt()) {
                case 1:
                    Admin admin = new Admin();
                    admin.adminFunctions();
                    break;

                case 2:
                    Customer customer = new Customer();
                    customer.customerFunctions();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}