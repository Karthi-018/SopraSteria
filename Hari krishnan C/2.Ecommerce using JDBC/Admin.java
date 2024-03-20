package org.example;
import java.util.*;
public class Admin
{
    public void addProduct()
    {
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        System.out.println("\nEnter Product Details...");
        System.out.println("\nEnter the Product id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("\nEnter the Product Name: ");
        String Name = input.nextLine();
        System.out.println("\nEnter the cost of the Product: ");
        int cost = input.nextInt();
        System.out.println("\nEnter the Quantity: ");
        int quantity = input.nextInt();
        p.addProduct(id,Name,cost,quantity);
        System.out.println("\n\n*******Product Added Successfully*******");
    }
    public void editProduct()
    {
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        System.out.println("\nEnter the Product_id to edit the Details...");
        int id = input.nextInt();
        int n = 1;
        while(n!=0)
        {
            System.out.println("\nPlease select which one to update...");
            System.out.println("1.Cost");
            System.out.println("2.Quantity");
            int choice = input.nextInt();
            if(choice == 1)
            {
                System.out.println("\nEnter the cost: ");
                int cost = input.nextInt();
                p.editProductCost(id,cost);
                System.out.println("\n*******Successfully updated the cost*******");
                n = 0;
            }
            if(choice == 2)
            {
                System.out.println("\nEnter the Quantity: ");
                int quantity = input.nextInt();
                p.editProductQuantity(id,quantity);
                System.out.println("\n*******Successfully updated the inventory*******");
                n = 0;
            }
            else
            {
                System.out.println("\nEnter the correct choice...");
            }
        }
    }
    public void deleteProduct()
    {
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        System.out.println("\nEnter the Product_id to delete the Product: ");
        int id = input.nextInt();
        p.deleteProduct(id);
        System.out.println("\n*******Successfully Deleted*******");
    }
}