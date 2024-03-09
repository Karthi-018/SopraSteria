package org.example;
import java.util.Scanner;
public class Customer extends ProductServices{

    public void customerFunctions() {
        Scanner scan = new Scanner(System.in);
        ProductServices ps = new ProductServices();
        ps.login();
        String product = null;
        while(true) {
            System.out.println("1.List product\n2.Search product\n3.Buy product\n4.Exit");
            switch (scan.nextInt()) {
                case 1:
                    ps.listProduct();
                    break;
                case 2:
                    System.out.println("Enter the product you want to search:");
                    product = scan.next();
                    ps.searchProduct(product);
                    break;
                case 3:
                    System.out.println("Enter the product you want to buy:");
                    product = scan.next();
                    ps.buyProduct(product);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

}
