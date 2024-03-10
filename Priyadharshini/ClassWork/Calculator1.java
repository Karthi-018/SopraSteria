class Calculator1
{
  void addition(int a1,int a2)
{
  System.out.println("sum of 2 numbers"+(a1+a2));
}
  
  void addition(int a1,int a2,int a3)
{
   System.out.println("sum of 3 numbers" +(a1+a2+a3));
}
void addition(int a1,int a2,int a3,int a4)
{
   System.out.println("sum of 4 numbers" +(a1+a2+a3+a4));
}
void addition(int a1,int a2,int a3,int a4,int a5)
{
   System.out.println("sum of 5 numbers" +(a1+a2+a3+a4+a5));
}
void addition(int a1,int a2,int a3,int a4,int a5,int a6)
{
   System.out.println("sum of 6 numbers" +(a1+a2+a3+a4+a5+a6));
}
void addition(int a1,int a2,int a3,int a4,int a5,int a6,int a7)
{
   System.out.println("sum of 7 numbers" +(a1+a2+a3+a4+a5+a6+a7));
}
void addition(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8)
{
   System.out.println("sum of 8 numbers" +(a1+a2+a3+a4+a5+a6+a7+a8));
}
void addition(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9)
{
   System.out.println("sum of 9 numbers" +(a1+a2+a3+a4+a5+a6+a7+a8+a9));
}
void addition(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10)
{
   System.out.println("sum of 10 numbers" +(a1+a2+a3+a4+a5+a6+a7+a8+a9+a10));
}
  
public static void main(String[]args)
{
  Calculator1 cal=new Calculator1();
  cal.addition(10,20);
   cal.addition(10,20,30,40,50);
}
}
  
  