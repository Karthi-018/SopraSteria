package org.example;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        LoginProcess e = new LoginProcess();
        Scanner show = new Scanner(System.in);
        Cart c=new Cart();
        int n = 1;
        while(n!=0)
        {
            if(n==1)
            {
                System.out.println("\nEnter usertype : ");
                System.out.println("\n1.Admin");
                System.out.println("2.Customer");
                System.out.println("3.Exit");
                switch(show.nextInt())
                {
                    case 1:
                        if(e.Adminlogin()==1)
                            n=2;
                        break;
                    case 2:
                        if(e.Customerlogin()==1)
                            n=3;
                        break;
                    case 3:
                        n=0;
                        break;
                }
            }
            if(n==2)
            {
                System.out.println("\nWelcome HARI...");
                System.out.println("\n1.Add");
                System.out.println("2.View");
                System.out.println("3.Edit");
                System.out.println("4.Search");
                System.out.println("5.Exit");
                switch (show.nextInt())
                {
                    case 1:
                        System.out.println("\nEnter the product to add : ");
                        show.nextLine();
                        c.addProduct(show.nextLine());
                        break;
                    case 2:
                        c.viewProduct();
                        break;
                    case 3:
                        c.editProduct();
                        break;
                    case 4:
                        System.out.println("\nEnter the product to search : ");
                        show.nextLine();
                        c.searchProduct(show.nextLine());
                        break;
                    case 5:
                        n = 1;
                        break;
                }
            }
            if(n==3)
            {
                System.out.println("\nTo what do we owe the pleasure...");
                System.out.println("\n1.View");
                System.out.println("2.Search");
                System.out.println("3.Exit");
                switch(show.nextInt())
                {
                    case 1:
                        c.viewProduct();
                        break;
                    case 2:
                        System.out.println("\nEnter the product to search : ");
                        show.nextLine();
                        c.SearchProduct(show.nextLine());
                        break;
                    case 3:
                        System.out.println("\nThank you...Until next time...");
                        n=1;
                        break;
                }
            }
        }
    }
}