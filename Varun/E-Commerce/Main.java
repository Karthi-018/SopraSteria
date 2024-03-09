import java.util.*;


class Main
{

	public static void main(String [] args)
	{
		Scanner sc=new Scanner(System.in);
		int selector;
		int x;
                String [] arr=new String[10];

		while(true)
		{

		System.out.println("Press 1 to login");
		System.out.println("Press 2 to exit");
		x=sc.nextInt();
		if(x==1)
		{
		System.out.println("LOGIN :");
		System.out.println("Press 1 for admin login");
		System.out.println("Press 2 for Customer login");
		
		selector=sc.nextInt();
		System.out.print("Username : ");
		String userName=sc.next();

		System.out.print("Password : ");
		String password=sc.next();




		switch(selector)
		{
			case 1:
				{
					if(userName.equals("admin") && password.equals("reset@123"))
					{
						while(true)
						{
						Admin objAdmin=new Admin();
						System.out.println("Press 1 to add a product");
						System.out.println("Press 2 to edit a product");
						System.out.println("Press 3 to list a product");
						System.out.println("Press 4 to delete a product");
						System.out.println("Press 5 to exit the admin module");

						System.out.println();
						System.out.println("----------------------------------------------------");
						selector=sc.nextInt();

						if(selector==5)
						{
							System.out.println("session has ended.");
							break;
						}
						if(selector==1)
						{
							System.out.println("Add method is called : ");	
							arr=objAdmin.add(arr);
					
						}
						else if(selector==2)
						{
							System.out.println("Edit method is called : ");	
							System.out.print("Enter the old value : ");
							String oldVal=sc.next();
							System.out.print("Enter the new value : ");
							String newVal=sc.next();
							objAdmin.edit(oldVal,newVal,arr);
					
						}
						else if(selector==3)
						{
							System.out.println("List method is called : ");	
							objAdmin.list(arr);
					
						}

						else if(selector==4)
						{
							System.out.println("Delete method is called : ");
							System.out.print("Enter the product to be deleted : ");
							String delVal=sc.next();	
							objAdmin.delete(delVal,arr);
					
						}
						
						}					
					}

					else 
					{
						System.out.println("Username or Password is incorrect");
					}
					break;	
				}
			case 2:
				{

					if(userName.equals("customer") && password.equals("reset@123"))
					{
					while(true)
					{
					Customer objCustomer=new Customer();
					System.out.println("Press 1 to list the products");
					System.out.println("Press 2 to search a product");
					System.out.println("Press 3 to exit customer module");
					System.out.println();
					System.out.println("----------------------------------------------------");
					selector=sc.nextInt();
					
					if(selector==1)
					{
						objCustomer.list(arr);
					}
					else if(selector==2)
					{
						System.out.println("Enter the Search Element : ");
						String ele=sc.next();
						objCustomer.search(ele,arr);
					}
					else if(selector==3)
					{
						break;
					}
					}
					}
					else 
					{
						System.out.println("Username or Password is incorrect");
					}
					break;
					
				}
		}
		}
		else
		{
			break;
		}
		}
	}

}
