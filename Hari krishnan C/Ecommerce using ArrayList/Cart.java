package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Cart
{
    ArrayList<String> Cart = new ArrayList<>();
    public void addProduct(String name)
    {
        Cart.add(name);
        System.out.println("\nSuccessfully added...");
    }
    public void viewProduct()
    {
        System.out.println("\nYour Inventory...");
        System.out.println("" + Cart);
    }
    public void editProduct()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter the product to Select : ");
        Cart.remove(scan.nextLine());
        System.out.println("\nEnter the product to Replace : ");
        Cart.add(scan.nextLine());
        System.out.println("\nSuccessfully Updated...");
    }
    public void searchProduct(String name)
    {
        if (Cart.contains(name))
        {
            System.out.println("\nYour Inventory contains " + name);
        }
        else
            System.out.println("\nYour Inventory doesn't contains " + name);
    }
    public void SearchProduct(String name)
    {
        if(Cart.contains(name))
        {
            System.out.println("\n Your cart contains " + name);
        }
        else
            System.out.println("\n Your cart doesn't contains " +name);
    }
}