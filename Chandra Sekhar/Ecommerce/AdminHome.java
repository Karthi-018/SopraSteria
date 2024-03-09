class AdminHome
{

	static String array[] = new String[20];
	
	void addItem(String item)
	{
		System.out.println("Adding Product ");
		//int i = 0;
		array[0] = item;
		System.out.println("Item Added Successfully "+ item);
		System.out.println(array[0]);
		//i++;
		
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
			if(n == null) break;
			System.out.println(n);
		}
	}

	void deleteItem(int index){}	
}