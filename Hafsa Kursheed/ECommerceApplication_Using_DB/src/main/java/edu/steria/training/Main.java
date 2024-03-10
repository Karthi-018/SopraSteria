package edu.steria.training;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        EcomApp em = new EcomApp();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Ecommerce Application.........");

        while(true)
        {
            System.out.println("\n1.Admin\n2.Customer\n3.Exit");
            System.out.print("Choose user type: ");
            int opt = sc.nextInt();

            if(opt==3)
            {
                System.out.println("Leaving the Application.....");
                break;
            }
            int oper;

            if(opt==1)
            {
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String pwd = sc.next();

                if(username.equals("Admin") && pwd.equals("test@123"))
                {
                    System.out.println("\nOperations:");
                    System.out.println("1.Add Product");
                    System.out.println("2.Edit Product");
                    System.out.println("3.View Product");
                    System.out.println("4.Delete Product");
                    System.out.println("5.Exit");

                    while(true)
                    {
                        boolean flag = false;
                        System.out.print("Select option: ");
                        oper = sc.nextInt();
                        switch (oper)
                        {
                            case 1:
                                em.addProduct();
                                break;
                            case 2:
                                em.editProduct();
                                break;
                            case 3:
                                em.viewProduct();
                                break;
                            case 4:
                                em.deleteProduct();
                                break;
                            case 5:
                                System.out.println("Admin left...........");
                                flag=true;
                                break;
                            default:
                                System.out.println("Improper option");
                        }
                        if(flag)
                        {
                           break;
                        }
                    }
                }
                else
                    System.out.println("Invalid Credentials........");
            }
            else if(opt==2)
            {
                System.out.println("1.Register\n2.Login");
                System.out.print("Enter choice: ");
                int ch= sc.nextInt();
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                String pwd = sc.next();
                if(ch==1)
                {
                    em.register(username,pwd);
                }
                else
                {
                    if(em.isValidate(username,pwd))
                    {
                        System.out.println("\nOperations:");
                        System.out.println("1.View Products");
                        System.out.println("2.Search Product");
                        System.out.println("3.Buy Product");
                        System.out.println("4.Exit");
                        while(true)
                        {
                            System.out.print("Select option: ");
                            oper = sc.nextInt();

                            if(oper==1)
                                em.viewProduct();
                            else if(oper==2)
                                em.searchProduct();
                            else if(oper==3)
                                em.buyProduct();
                            else if(oper==4)
                            {	System.out.println("Customer left..........");
                                break;
                            }
                            else
                                System.out.println("Improper option");
                        }
                    }

                    else
                        System.out.println("Invalid Credentials............");
                }

            }
            else
            {
                System.out.println("Invalid Option.........");
            }
        }

    }
}
