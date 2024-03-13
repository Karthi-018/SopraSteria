package org.example;
import java.util.*;
public class Ecommerce
{
    int Adminlogin()
    {
        Scanner Login = new Scanner(System.in);
        System.out.println("\nEnter the Admin name : ");
        String a = Login.nextLine();
        System.out.println("\nEnter the password : ");
        String b = Login.next();
        if (a.equals("Hari krishnan") && b.equals("Hari@123"))
        {
            System.out.println("\nSuccessfully logged in...");
            return 1;
        }
        else
            System.out.println("\nInvalid Credentials...");
        return 0;
    }
    int Customerlogin()
    {
        Scanner Login = new Scanner(System.in);
        System.out.println("\nEnter the Username : ");
        String a = Login.nextLine();
        System.out.println("\nEnter the Password : ");
        String b = Login.next();
        if(a.equals("Customer 1") && b.equals("Customer@123"))
        {
            System.out.println("\nSuccessfully logged in...Welcome...");
            return 1;
        }
        else
        {
            System.out.println("\nUsername or Password is incorrect...");
            return 0;
        }
    }
    public static void main(String[] args)
    {
        Ecommerce e = new Ecommerce();
        Scanner show = new Scanner(System.in);
        ArrayList<String> Cart = new ArrayList<>();
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
                        Cart.add(show.next());
                        System.out.println("\nSuccessfully added...");
                        break;
                    case 2:
                        System.out.println("\nYour Inventory...");
                        System.out.println("" + Cart);
                        break;
                    case 3:
                        System.out.println("\nEnter the product to Select : ");
                        Cart.remove(show.next());
                        System.out.println("\nEnter the product to Replace : ");
                        Cart.add(show.next());
                        System.out.println("\nSuccessfully Updated...");
                        break;
                    case 4:
                        System.out.println("\nEnter the product to search : ");
                        String A = show.next();
                        if (Cart.contains(A))
                        {
                            System.out.println("\nYour Inventory contains " + A);
                        }
                        else
                            System.out.println("\nYour Inventory doesn't contains " + A);
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
                        System.out.println("\nYour Cart : ");
                        System.out.println("\n"+Cart);
                        break;
                    case 2:
                        System.out.println("\nEnter the product to search : ");
                        String A = show.next();
                        if(Cart.contains(A))
                            System.out.println("\nYour Cart contains "+A);
                        else
                            System.out.println("\nYour Cart doesn't contains "+A);
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