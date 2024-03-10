public class Parent
{
String name="parent";


}
class Child extends Parent
{
 String name="child";
 public void PrintName()
{

System.out.println(name);
}
public static void main(String[]args)
{
Child c=new Child();
c.PrintName();
}

}
