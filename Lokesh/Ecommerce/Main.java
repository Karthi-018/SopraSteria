package edu.assign;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Login entry = new Login();
		Scanner prod = new Scanner(System.in);
		Functions cal =new Functions();
		int n = 1;
		while(n!=0)
		        {
		            if(n==1)
		            {
		                System.out.println("Enter usertype : \n");
		                System.out.println("1.Admin");
		                System.out.println("2.Customer");
		                System.out.println("3.Exit \n");
		                switch(prod.nextInt())
		                {
		                    case 1:
		                        if(entry.adminlogin()==1)
		                            n=2;
		                        break;
		                    case 2:
		                        if(entry.customerlogin()==1)
		                            n=3;
		                        break;
		                    case 3:
		                        n=0;
		                        break;
		                }
		            }
		            if(n==2)
		            {
		                System.out.println("\nWelcome \n");
		                System.out.println("1.Add");
		                System.out.println("2.View");
		                System.out.println("3.Edit");
		                System.out.println("4.Search");
		                System.out.println("5.Exit \n");
		                switch (prod.nextInt())
		                {
		                    case 1:
		                        System.out.println("Enter the product to add : ");
		                        prod.nextLine();
		                        cal.addProduct(prod.nextLine());
		                        break;
		                    case 2:
		                        cal.viewProduct();
		                        break;
		                    case 3:
		                        cal.editProduct();
		                        break;
		                    case 4:
		                        System.out.println("Enter the product to search : ");
		                        prod.nextLine();
		                        cal.searchProduct(prod.nextLine());
		                        break;
		                    case 5:
		                        n = 1;
		                        break;
		                }
		            }
		            if(n==3)
		            {
		                System.out.println("\nHow can we help you?? \n");
		                System.out.println("1.View");
		                System.out.println("2.Search");
		                System.out.println("3.Exit \n");
		                switch(prod.nextInt())
		                {
		                    case 1:
		                        cal.viewProduct();
		                        break;
		                    case 2:
		                        System.out.println("Enter the product to search : ");
		                        prod.nextLine();
		                        cal.searchProduct(prod.nextLine());
		                        break;
		                    case 3:
		                        System.out.println("\nThank you...See you again \n");
		                        n=1;
		                        break;
		                }
		            }
		        }
	}
}
	
