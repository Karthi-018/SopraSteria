package Alien;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class EcommerceMain {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner s = new Scanner(System.in);
        System.out.println("****Login****");
        System.out.println("enter the username");
        String username = s.nextLine();
        System.out.println("enter the password");
        String passWord = s.nextLine();
//        System.out.println(passWord+"   "+username);
        list.add("ACER");
        list.add("MSI");
        list.add("ASUS");
        list.add("HP");
        list.add("DELL");
        if (username.toLowerCase().equals("admin") && passWord.toLowerCase().equals("reset@123")) {
            System.out.println("Admin Login");
            while (true) {
                System.out.println("1)Add product");
                System.out.println("2)Edit product");
                System.out.println("3)delete product");
                System.out.println("4)Show product");
                System.out.println("5)Exit");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        String pname = new String();
                        System.out.println("Enter the product to add");
                        pname = s.next();
                        list.add(pname);
                        break;
                    case 2:
                        System.out.println("Choose the product to edit");
                        int temp = 1;
                        for (String c : list) {
                            System.out.println(temp + ")" + c);
                            temp++;
                        }
                        System.out.println("Enter the product number");
                        int num = s.nextInt();
                        list.remove(num - 1);
                        System.out.println("Enter new product");
                        String bc = s.next();
                        list.add(num - 1, bc);
                        break;

                    case 3:
                        System.out.println("Enter the product to delete");
                        int y = 1;
                        for (String c : list) {
                            System.out.println(y + ")" + c);
                            y++;
                        }
                        System.out.println("Enter the product number");
                        int pnum = s.nextInt();
                        list.remove(pnum - 1);
                        break;

                    case 4:
                        System.out.println("Available products are");
                        for (String i : list) {
                            System.out.println(i);
                        }
                        break;

                    case 5:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                if (choice == 5)
                    break;
            }
        }

        if(username.toLowerCase().equals("customer") && passWord.toLowerCase().equals("reset@123")) {
            System.out.println("******Customer login******");

            while (true) {
                System.out.println("");
                System.out.println("1)Show product");
                System.out.println("2)Buy product");
                System.out.println("3) Exit");
                int n = s.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Available products are:");
                        int v = 1;
                        for (String m : list) {
                            System.out.println(v + ")" + m);
                            v++;
                        }
                        break;
                    case 2:
                        System.out.println("Enter the product number to buy");
                        int y = s.nextInt();
                        list.remove(y - 1);
                        break;
                    case 3:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                if (n == 3)
                    break;

            }
        }
    }
}








