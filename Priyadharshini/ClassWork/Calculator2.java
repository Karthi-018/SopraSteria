class Calculator2
{
 void add(int ... num)
{
 int sum=0;
 for(int n:num)
{
  sum=sum+n;
}

System.out.println(sum);
}

public static void main(String[]args)
{
 Calculator2 ca=new Calculator2();
 ca.add(1,2,3,4,5,66,8);
 ca.add(7,8,9,5,4,3);

}
}
