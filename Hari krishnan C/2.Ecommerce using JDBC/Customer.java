package org.example;
import java.util.*;
public class Customer
{
    public void searchProduct()
    {
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        System.out.println("\nEnter the Product Name to Search: ");
        String Name = input.nextLine();
        p.searchProduct(Name);
    }
    public void buyProduct()
    {
        Scanner input = new Scanner(System.in);
        Product p = new Product();
        Bill b = new Bill();
        int n = 1;
        while(n!=0)
        {
//            input.nextLine();
            System.out.println("\nEnter the product_name:");
            String product_name = input.nextLine();
            System.out.println("\nEnter the number of Quantities: ");
            int quantity = input.nextInt();
            if(b.AddtoCart(product_name,quantity) == 1)
            {
                System.out.println("\nSuccessfully Added to the Cart...");
            }
            else
            {
                System.out.println("\nEnter the correct product name...");
            }
            System.out.println("\nContinue shopping? :)");
            System.out.println("\n1.Yes :D");
            System.out.println("2.No...Proceed to Payment! :)");
            if(input.nextInt() == 2)
            {
                b.billProduct();
                n = 0;
            }
            else
            {
                input.nextLine();
            }
        }
    }
}