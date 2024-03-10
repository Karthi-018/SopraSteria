
import java.util.*;
public class PrimeSquare
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int a[]=new int[10];
	    int k=0;
	    int count=0;
	    int n=2;
	    while(count<10)
	    {
	        int flag=0;
	        for(int i=2;i<n/2;i++)
	        {
	            if(n%i==0)
	            {
	               flag=1;
	               break;
	            }
	        }
	        if(flag==0)
	        {
	           a[k++]=n; 
	           count++;
	        }
	        n++;
	    }
	    for(int j=0;j<k;j++)
	    {
	        System.out.print(a[j]+" ");
	    }
	    System.out.println();
	    int m=0;
	    int b[]=new int[10];
	    for(int r=0;r<k;r++)
	    {
	        b[m++]=a[r]*a[r];
	    }
	    for(int d:b)
	    {
	        System.out.print(d+" ");
	    }
	    
	}
}
	   
