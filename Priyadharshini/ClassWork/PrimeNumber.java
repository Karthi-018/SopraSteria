class PrimeNumber
{
public static void main(String []args)
{
int i=2;
int count=0;
  while (count<=50)
 {
   int flag=0;
  for(int j=2;j<i/2;j++)
  {
    if(i%j==0)
  {
    flag=1;
    break;
  }
  }
   
  if(flag==0)
  {
  System.out.println(i);
  count++;
  }
  i++;

  
}
}
}

  

