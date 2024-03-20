package edu.assign;
import java.util.*;
public class Functions {

		
		    ArrayList<String> Items = new ArrayList<>();
		    public void addProduct(String name)
		    {
		        Items.add(name);
		        System.out.println("\nProduct Added \n");
		    }
		    public void viewProduct()
		    {
		        System.out.println("Your Products : \n");
		        System.out.println(Items);
		    }
		    public void editProduct()
		    {
		        Scanner edit = new Scanner(System.in);
		        System.out.println("Enter the product to Change : ");
		        Items.remove(edit.nextLine());
		        System.out.println("Enter the product to Replace : ");
		        Items.add(edit.nextLine());
		        System.out.println("\nUpdated Successfully \n");
		    }
		    public void searchProduct(String name)
		    {
		        if (Items.contains(name))
		        {
		            System.out.println("\nProduct available \n");
		        }
		        else
		            System.out.println("Product not available \n");
		    }
		    
		}