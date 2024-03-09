package steria.emp.test;


import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
public class Main {
    EmpOpr obj = new EmpOpr();
    Scanner scan = new Scanner(System.in);
    void rec()
    {
        System.out.println("Welcome the Employee Management Page");
        System.out.println("\n\n1.Add\n2.Search\n3.Edit\n4.List\n5.Exit");
        int choice = scan.nextInt();
        switch(choice)
        {
            case 1:
            {

                System.out.println("Enter Employee Code:");
                int empcd = scan.nextInt();
                System.out.println("Enter Employee Name:");
                String empname = scan.next();
                System.out.println("Enter Employee Salary:");
                int sal = scan.nextInt();
                System.out.println("Enter Employee Work:");
                String wrk = scan.next();
                obj.addEmp(new Employee(empcd, sal, empname, wrk));
                rec();
            }
            case 2:
            {
                System.out.println("Enter employee ID : ");
                int eid = scan.nextInt();
                obj.searchEmp(eid);
                rec();
            }
            case 3:
            {
                System.out.println("Enter the employee id:");
                int eid = scan.nextInt();
                System.out.println("Enter the edited salary:");
                int salary = scan.nextInt();
                obj.editEmp(eid, salary);
                rec();
            }
            case 4: obj.viewEmp(); rec();
            case 5: break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args)
    {
        Main obj = new Main();
        obj.rec();
    }
}
