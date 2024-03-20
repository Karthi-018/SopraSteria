package edu.assign;
import java.util.*;
import java.sql.*;

public class Admin {
	
	public void addProduct()
	{
		Scanner inp = new Scanner(System.in);
	    Product pro = new Product();
	    
	    System.out.println("Enter the Product Details: \n");
	    
	    System.out.println("Enter the Product Id: ");
	    int id = inp.nextInt();
	    
	    System.out.println("Enter the Product Name: ");
	    String name=inp.next();
	    
	    System.out.println("Enter the Price: ");
	    int cost=inp.nextInt();
	    
	    
	    pro.addProduct(id,name,cost);
	    System.out.println("\nSuccessfully Added...\n");
	}
	
	public void editProduct()
	{
        Scanner inp = new Scanner(System.in);
        Product pro = new Product();
	        
        System.out.println("Enter the Product to Edit");
        String name=inp.next();
	        
        System.out.println("Enter the updated cost:");
        int cost=inp.nextInt();
	        
        pro.editProduct(name,cost);
        System.out.println("\n Successfully Updated...");
    }

	public void deleteProduct()
	{
		Scanner inp = new Scanner(System.in);
        Product pro = new Product();
        
        System.out.println("\nEnter the Product to delete");
        String name=inp.next();
        
        pro.deleteProduct(name);
        System.out.println("\nSuccessfully Deleted...");
	}
}
