package Ecommerce;

import java.util.*;
public class Customer {
    public void searchProduct()
    {
        Scanner in=new Scanner(System.in);
        Product p=new Product();
        System.out.println("Enter the Product Name to Search");
        String name=in.next();
        p.searchProduct(name);
    }
    public void buyProduct()
    {
        Scanner in=new Scanner(System.in);
        Product p=new Product();
        Bill b=new Bill();
        int n=1;
        while(n!=0)
        {
            System.out.println("Enter the Product Name to Add:");
            String pname=in.next();
            System.out.println("Enter the Number of Quantities you want:");
            int quantity=in.nextInt();
            b.AddToCart(pname,quantity);
            System.out.println("Product Added Successfully");
            System.out.println("Do you Still want to add the product or want Bill? 1.Add 2. Bill");
            if(in.nextInt()==2) {
                b.BillProduct();
                n = 0;
            }
        }
    }
}
