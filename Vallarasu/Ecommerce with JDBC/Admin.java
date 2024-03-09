package Ecommerce;

import java.util.*;
public class Admin {
    public void addProduct(){
        Scanner in=new Scanner(System.in);
        Product p=new Product();
        System.out.println("Enter the Mobile Details: ");
        System.out.println("Enter the Mobile Id: ");
        int id=in.nextInt();
        System.out.println("Enter the Mobile Name: ");
        String name=in.next();
        System.out.println("Enter the Mobile Cost: ");
        int cost=in.nextInt();
        System.out.println("Enter the Mobile Quantity: ");
        int quantity=in.nextInt();
        p.addProduct(id,name,cost,quantity);
        System.out.println("\nSuccessfully Added...\n");
    }
    public void editProduct()
    {
        Scanner in=new Scanner(System.in);
        Product p=new Product();
        System.out.println("Choose the Product Id to Edit Product Details");
        int id=in.nextInt();
        System.out.println("Enter the updated cost:");
        int cost=in.nextInt();
        p.editProduct(id,cost);
        System.out.println("Successfully Updated...");
    }
    public void deleteProduct()
    {
        Scanner in=new Scanner(System.in);
        Product p=new Product();
        System.out.println("Enter the Product id to delete");
        int id=in.nextInt();
        p.deleteProduct(id);
        System.out.println("Successfully Deleted...");
    }
}
