package org.example;
import java.util.Scanner;
public class LoginProcess
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
        if (a.equals("Customer 1") && b.equals("Customer@123"))
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
}
