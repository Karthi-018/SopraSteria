package org.example;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Ecommerce ecom = new Ecommerce();
        Admin a = new Admin();
        Product p = new Product();
        Customer c = new Customer();
        System.out.println("\nGood to see you...Please select what you want...\n");
        int n = 1;
        while(n != 0)
        {
            if(n == 1)
            {
                System.out.println("\n1.Login");
                System.out.println("2.Exit");
                int choice1 = input.nextInt();
                if (choice1 == 1)
                {
                    System.out.println("\n1.Admin login");
                    System.out.println("2.Customer login");
                    System.out.println("3.Go back");
                    switch (input.nextInt())
                    {
                        case 1:
                            input.nextLine();
                            System.out.println("\nEnter the Admin Name: ");
                            String Admin_username = input.nextLine();
                            System.out.println("\nEnter the code: ");
                            String Pwd = input.next();
                            if (ecom.Adminlogin(Admin_username, Pwd) == 1)
                            {
                                System.out.println("\nGlad you're back Hari...");
                                n = 2;
                            }
                            else
                            {
                                System.out.println("\nYou picked the wrong choice pal...");
                            }
                            break;
                        case 2:
                            input.nextLine();
                            System.out.println("\nUsername: ");
                            String Username = input.nextLine();
                            System.out.println("\nPassword: ");
                            String Password = input.next();
                            if (ecom.Customerlogin(Username, Password) == 1)
                            {
                                System.out.println("\nSuccessfully logged in...");
                                n = 3;
                            }
                            else
                            {
                                System.out.println("\nInvalid Username or Password...");
                                System.out.println("\nUsername has no Account...Do you want to Create an Account???");
                                System.out.println("\n1.Yes \n2.No");
                                int choice2 = input.nextInt();
                                if(choice2 == 1)
                                {
                                    ecom.customerAccount();
                                }
                                else if(choice2 == 2)
                                {
                                    n = 1;
                                }
                                else
                                {
                                    System.out.println("Enter the correct choice...");
                                }
                            }
                            break;
                        case 3:
                            n = 1;
                            break;
                    }
                }
                else if (choice1 == 2)
                {
                    System.out.println("\nUntil next time....");
                    n = 0;
                }
                else
                {
                    System.out.println("\n You Picked the Wrong Choice Pal");
                }
            }
            if(n == 2)
            {
                System.out.println("\nYour Playground...");
                System.out.println("\n1.Add Product...");
                System.out.println("2.Edit Product...");
                System.out.println("3.Your Inventory...");
                System.out.println("4.Delete product...");
                System.out.println("5.Go back");
                switch(input.nextInt())
                {
                    case 1:
                        a.addProduct();
                        break;
                    case 2:
                        p.listProduct();
                        System.out.println();
                        a.editProduct();
                        break;
                    case 3:
                        System.out.println("\nProducts available in your inventory...");
                        p.listProduct();
                        System.out.println();
                        break;
                    case 4:
                        p.listProduct();
                        System.out.println();
                        a.deleteProduct();
                        break;
                    case 5:
                        System.out.println("\nHave a nice day Hari...");
                        n = 1;
                        break;
                }
            }
            if(n == 3)
            {
                System.out.println("\nWelcome...");
                System.out.println("\n1.List Products");
                System.out.println("2.Search Products");
                System.out.println("3.Buy Products");
                System.out.println("4.Go back");
                switch(input.nextInt())
                {
                    case 1:
                        System.out.println("\nList of Products Available...");
                        p.listProduct();
                        System.out.println();
                        break;
                    case 2:
                        c.searchProduct();
                        break;
                    case 3:
                        c.buyProduct();
                        break;
                    case 4:
                        System.out.println("\nHave a nice day...");
                        n = 1;
                        break;
                }
            }
        }
    }
}