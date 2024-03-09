import java.util.Scanner;

class Ecommerce
{


	String adminUsername = "admin";
	String adminPassword = "Reset@123";
	void adminProfile(String un, String pw)
	{
		System.out.println(un + pw);
		System.out.println(adminUsername + adminPassword);
		if(adminUsername.equals(un) && adminPassword.equals(pw))
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to Admin Profile");
			
			System.out.println("Select your Choice !!! \n1. Add Product\n2. Edit Product\n3. List of Products\n4. Delete Product\n5. Exit");
			int choice = scan.nextInt();
			if(choice == 1)
			{
				
				System.out.println("Enter the product name that is to be added : ");			
				AdminHome obj1 = new AdminHome();
				String item = scan.next();
				System.out.println(item);
				obj1.addItem("Samsung");
			}
			else if(choice == 2){}
			else if(choice == 3){
				AdminHome obj2 = new AdminHome();
				obj2.list();
			}
			else if(choice == 4){}
			else if(choice == 5){}
			else{}
		}
		else
		{
			System.out.println("Incorrect username or password !!!");
		}
	
	}

	class AdminHome
	{

	String array[] = new String[20];
	int i = 0;
	void addItem(String item)
	{
		
		array[i] = item;
		System.out.println("Item Added Successfully");
	}

	void editItem(String item, String changedItem)
	{

		for(int i = 0; i<20; i++)
		{
			if(array[i].equals(item))
			{
				System.out.println("Enter the change : ");
				array[i] = changedItem;
				System.out.println("Item Edited Successfully");
			}
		}
	}

	void list()
	{
		System.out.println("List of Items");
		for(String n: array)
		{
			System.out.println(n);
		}
	}

	void deleteItem(int index){}	
	}
	public static void main(String args[])
	{
		Ecommerce admin = new Ecommerce();
		
		System.out.println("**** Welcome to the Mobile Website ****");
		System.out.println("**** LOGIN ****");
		System.out.println("1. Admin Login\n2. Customer Login");
		System.out.println("Enter your choice(1 or 2) : ");
		Scanner scan = new Scanner(System.in);
		String input1 = scan.nextLine();
		
		System.out.println("Enter username : ");
		String usename = scan.nextLine();
		System.out.println("Enter your password : ");
		String pass = scan.nextLine();
		if(input1.equals("1")){admin.adminProfile(usename, pass);}
		else{}
		

		
		System.out.println("******* THE END ********");

	}
}