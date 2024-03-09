import java.util.*;


class Admin
{
	static int i=0;

	Scanner sc=new Scanner(System.in);
	String[] add(String[] arr)
	{
		
		System.out.println("Type bye to exit the input statement");
	
		while(true)
		{
			
			String temp=sc.next();
			if(temp.equals("bye"))
			{
				break;
			}	
			if(arr[i]==null)
			{
				arr[i]=temp;
				i++;
			}
			else
			{
				i++;
			}
		}
		return arr;
	
	}


	void list(String [] arr)
	{
		for(String s:arr)
		{
			System.out.print(s+" ");
		}
		System.out.println();
	}

	
	String[] edit(String oldVal,String newVal,String [] arr)
	{
	
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j].equals(oldVal))
			{
				arr[j]=newVal;
				break;	
			}
		}
		return arr;

	}


	void delete(String val,String [] arr)
	{
		int temp=0;
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j].equals(val))
			{
				temp=j;
				break;
			}
		}

		for(int j=temp;j<arr.length-1;j++)
		{

			arr[j]=arr[j+1];
			if(j==arr.length-2)
			{
				arr[j]=null;
			}

		}
	}







	

}