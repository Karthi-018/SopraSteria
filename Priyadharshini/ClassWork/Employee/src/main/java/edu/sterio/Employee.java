package edu.sterio;

public class Employee {
    private int Eid;
    private String Ename;
    private String dept;
    private double salary;

    Employee()
    {
        System.out.println("Employee details");
    }
    Employee(int Eid)
    {
        this();

        System.out.println("Eid is"+ Eid);
    }
    Employee(int Eid,String Ename)
    {
        this(Eid);

        System.out.println("Name is"+Ename);
    }
    Employee(int Eid,String Ename,String dept)
    {
        this(Eid,Ename);

        System.out.println("Dept is"+dept);
    }
    Employee(int Eid,String Ename,String dept,double salary)
    {

        this(Eid,Ename,dept);


        System.out.println("salary is"+ salary);
    }
}
