package edu.steria;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin ad = new Admin();
        Customer c = new Customer();
        System.out.println("Enter your username...");
        String username=sc.next();
        System.out.println("Enter your password...");
        String password = sc.next();
        if (password.equals("Reset@123")) {
            System.out.println("Enter the option...");
            System.out.println("1. Admin\n2. Customer");
            int opt = sc.nextInt();
            boolean test=true;
            switch (opt) {
                case 1:
                    while(test) {
                        System.out.println("Enter the method to be done..");
                        System.out.println("a.add\nb.edit\nc.list\nd.delete\ne.exit");
                        char choice = sc.next().charAt(0);
                        switch (choice) {
                            case 'a':
                                System.out.println("Enter the count to add");
                                int count=sc.nextInt();
                                if(count<=10)
                                {
                                    for(int i=0;i<count;i++)
                                    {
                                        String name=sc.next();
                                        ad.addproduct (name);
                                    }
                                }
                                else
                                {
                                    System.out.println("Sorry,Only 10 products can be added");
                                }
                                break;
                            case 'b':
                                System.out.println("Enter the product should be edited");
                                String edit1=sc.next();
                                System.out.println("Enter the new value");
                                String update=sc.next();
                                ad.editproduct(edit1,update);
                                break;
                            case 'c':
                                ad.listproduct ();
                                break;
                            case 'd':
                                System.out.println("Enter the product should be deleted");
                                String del=sc.next();
                                ad.deleteproduct (del);
                                break;
                            case 'e':
                                System.out.println("*************end*********");
                                test=false;
                                break;
                            default:
                                System.out.println ("Invalid credentials");
                                break;
                        }



                    }

                case 2:
                    while(test) {
                        System.out.println("Enter the method to be done..");
                        System.out.println("a.list\nb.search");
                        char choice = sc.next().charAt(0);
                        switch (choice) {
                            case 'a':
                                c.listproduct();
                                break;
                            case 'b':
                                System.out.println("Enter the product to be searched...");
                                String search=sc.next();
                                c.searchproduct(search);
                                test=false;
                                break;

                        }
                    }

            }
        } else {
            System.out.println("Incorrect password!");
        }
    }
}