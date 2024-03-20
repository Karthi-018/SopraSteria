package edu.assign;
import java.util.*;

public class Customer {
    public void searchProduct()
    {
        Scanner inp = new Scanner(System.in);
        Product pro = new Product();
        
        System.out.println("Enter the Product Name to Search");
        String name = inp.next();
        
        pro.searchProduct(name);
    }
}
