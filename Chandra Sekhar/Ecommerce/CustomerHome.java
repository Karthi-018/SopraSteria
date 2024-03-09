class CustomerHome extends AdminHome
{

	AdminHome obj = new AdminHome();
	String array2[] = new String[20];
	array2 = obj.array

	void list()
	{
		System.out.println("List of Items");
		for(String n: array2)
		{
			if(n == null) break;
			System.out.println(n);
		}
	}

	void search(String item){

		for(String n: array2)
		{
			if(n.equals(item))
			{
				System.out.println("The item searched is found");
			}	
		}
		

	}	
}




