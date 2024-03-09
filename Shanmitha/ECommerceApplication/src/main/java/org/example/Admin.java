package org.example;
import java.util.Scanner;
public class Admin extends ProductServices{
    public void adminFunctions() {
        Scanner scan = new Scanner(System.in);
        ProductServices ps = new ProductServices();
        ps.login();
        String product = null;
        while(true) {
            System.out.println("1.Add product\n2.Edit product\n3.List product\n4.Delete product\n5.Exit");
            switch (scan.nextInt()) {

                case 1:
                    ps.addProduct();
                    break;
                case 2:
                    System.out.println("Enter the product you want to edit:");
                    product = scan.next();
                    ps.editProduct(product);
                    break;
                case 3:
                    ps.listProduct();
                    break;
                case 4:
                    System.out.println("Enter the product you want to delete:");
                    product = scan.next();
                    ps.deleteProduct(product);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
}
