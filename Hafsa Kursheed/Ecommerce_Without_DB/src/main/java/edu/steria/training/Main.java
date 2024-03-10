package edu.steria.training;

import java.util.*;

public class Main
{
    static String prod[] = new String[10];
    static int prodAvail=0;

    static Scanner sc = new Scanner(System.in);

    static void addProduct()
    {
        System.out.print("Enter Product: ");
        prod[prodAvail]=sc.next();
        prodAvail++;
        System.out.println("Product is added");
    }

    static void editProduct()
    {
        int edflag=0;
        System.out.print("Enter the product to edit: ");
        String editProd = sc.next();
        for(int i=0; i<prodAvail; i++)
        {
            if(prod[i].equals(editProd))
            {
                System.out.print("Enter the edited product: ");
                prod[i] = sc.next();
                edflag=1;
                System.out.println("Product is Edited");
            }

        }
        if(edflag==0)
        {
            System.out.println("Product is not present to edit");
        }

    }

    static void viewProduct()
    {
        if(prodAvail!=0)
        {
            System.out.println("Products are: ");
            for(int i=0; i<prodAvail; i++)
            {
                System.out.println(prod[i]);
            }
        }
        else
        {
            System.out.println("No Products are available......");
        }

    }

    static void deleteProduct()
    {

        int delflag=0, k=-1;
        System.out.print("Enter the product to Delete: ");
        String delProd = sc.next();
        for(int i=0; i<prodAvail; i++)
        {
            if(prod[i].equals(delProd))
            {
                delflag=1;
                k=i;
                break;
            }
        }
        if(delflag==0)
        {
            System.out.println("Product is not present to delete");
            return;
        }
        for(int i=k;i<prodAvail-1; i++)
        {
            prod[i]=prod[i+1];
        }
        System.out.println("Product is deleted");
        prodAvail--;


    }

    static void searchProduct()
    {
        System.out.print("Enter Product to search: ");
        String prodName = sc.next();
        for(int i=0; i<prodAvail; i++)
        {
            if(prod[i].equals(prodName))
            {
                System.out.println("Product is found");
                return;
            }
        }
        System.out.println("Product not found");
    }
    static boolean isValidate(String user, String pwd)
    {
        if(pwd.equals(user+"@123"))
            return true;
        return false;
    }


    public static void main(String args[])
    {
        while(true)
        {
            System.out.println("\n1.Admin\n2.Customer\n3.Exit");
            System.out.print("Choose user type: ");
            int opt = sc.nextInt();

            if(opt==3)
            {
                System.out.println("Exiting the code.....");
                break;
            }

            System.out.print("Enter username: ");
            String username = sc.next();
            System.out.print("Enter password: ");
            String pwd = sc.next();

            int oper;


            if(opt==1)
            {
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
                        System.out.print("Select option: ");
                        oper = sc.nextInt();

                        if(oper == 1)
                            addProduct();
                        else if(oper==2)
                            editProduct();
                        else if(oper==3)
                            viewProduct();
                        else if(oper==4)
                            deleteProduct();
                        else
                        {	System.out.println("Admin left...........");
                            break;
                        }
                    }
                }
                else
                    System.out.println("Invalid Credentials........");
            }
            else if(opt==2)
            {
                if(isValidate(username,pwd))
                {
                    System.out.println("\nOperations:");
                    System.out.println("1.View Products");
                    System.out.println("2.Search Product");
                    System.out.println("3.Exit");
                    while(true)
                    {
                        System.out.print("Select option: ");
                        oper = sc.nextInt();

                        if(oper==1)
                            viewProduct();
                        else if(oper==2)
                            searchProduct();
                        else
                        {	System.out.println("Customer left..........");
                            break;
                        }


                    }
                }

                else
                    System.out.println("Invalid Credentials............");


            }

            else
            {
                System.out.println("Invalid Option.........");
            }
        }

    }
}
				

		