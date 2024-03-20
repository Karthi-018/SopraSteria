package edu.assign;
import java.util.*;
public class Login {

	int adminlogin()
	{
		Scanner user = new Scanner(System.in);
		System.out.println("Enter the username : ");
		String name = user.nextLine();
		System.out.println("Enter the password : ");
		String pwd = user.nextLine();
		
		if (name.equals("Lokesh") && pwd.equals("Lokesh@18"))
		{
			System.out.println("\nUser logged in \n");
			return 1;
		}
		else 
			System.out.println("\nUser not available \n");
		return 0;
	}
		
	int customerlogin()
		{
			Scanner user = new Scanner(System.in);
			System.out.println("Enter customer ID : ");
			String name = user.nextLine();
			System.out.println("Enter Password : ");
			String pwd = user.nextLine();
			
			if (name.equals("Customer") && pwd.equals("Cust1234"))
			{
				System.out.println("\nWelcome \n");
				return 1;
			}
			else
				System.out.println("\nCustomer not found \n");
			return 0;
		}		
	}