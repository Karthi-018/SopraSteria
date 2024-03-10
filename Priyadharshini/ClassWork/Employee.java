class Employee
{
private int Eid;
void setEid(int id)
{
Eid=id;
}
int get()
{
return Eid;
}

public static void main(String[]args)
{
 Employee emp=new Employee();
 emp.setEid(101);
 System.out.print(emp.get());
}
}
 