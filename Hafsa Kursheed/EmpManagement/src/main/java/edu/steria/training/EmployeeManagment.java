package edu.steria.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagment
{
    List<Employee> employeeList = new ArrayList<>();
    public void addEmp(Employee e)
    {
        employeeList.add(e);
    }
    public void viewEmp()
    {
        if(employeeList.isEmpty())
        {
            System.out.println("No Employees are found...........");
        }
        else
        {
            System.out.println("Employee Details: ");
            for(Employee e: employeeList)
            {
                System.out.println(e);
            }
        }
    }

    public void editEmp(int id)
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        for(Employee e: employeeList)
        {
            if(id==e.getEmpId())
            {
                System.out.println(e);
                flag = false;
                System.out.println("Edit:\n1.Department\n2.Salary\n3.Exit");
                System.out.print("Enter your choice(1,2): ");
                int ch = sc.nextInt();
                if(ch==1)
                {
                    System.out.print("Enter the Department to change: ");
                    e.setEmpDept(sc.next());
                    System.out.println(e);
                }
                else if(ch==2)
                {
                    System.out.print("Enter the Salary to change: ");
                    e.setSalary(sc.nextDouble());
                    System.out.println(e);
                }
                else if(ch==3)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid option........");
                }
            }
        }
        if(flag)
        {
            System.out.println("Employee not present");
        }
    }


    public void searchEmp(int id)
    {
        boolean flag = true;
        for(Employee e: employeeList)
        {
            if(id==e.getEmpId())
            {
                System.out.println(e);
                flag = false;
                break;
            }
        }
        if(flag)
        {
            System.out.println("Employee not present.........");
        }
    }

    public void delEmp(int id)
    {
        boolean flag = true;
        for (Employee e : employeeList)
        {
            if (id == e.getEmpId())
            {
                employeeList.remove(e);
                System.out.println("Employee Removed.........");
                flag = false;
                break;
            }
        }
        if (flag)
        {
            System.out.println("Employee not present..........");
        }
    }
}
