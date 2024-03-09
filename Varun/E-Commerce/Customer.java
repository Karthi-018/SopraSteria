import java.util.*;


class Customer
{
	Scanner sc=new Scanner(System.in);
	void list(String [] arr)
	{
		for(String s:arr)
		{
			System.out.print(s+" ");
		}
		System.out.println();
	}


	void search(String searchVal,String[] arr)
	{
		int t=0;
		System.out.println(Arrays.toString(arr));
		for(String str:arr)
		{
			if(searchVal.equals(str))
			{
				System.out.println("The value is found.");
				t++;
				break;
			}
		}
		if(t==0)
		{
			System.out.println("The value is not found.");
		}
	}

}