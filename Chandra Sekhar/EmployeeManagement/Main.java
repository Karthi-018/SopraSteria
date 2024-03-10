package sopra.project.employee;

import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        EmployeeService obj = new EmployeeService();

        boolean run = true;
        while(run)
        {
            System.out.println("Welcome the Employee Management Page");
            System.out.println("\n\n1.Add\n2.List\n3.Edit\n4.Search\n5.Delete\n6.Exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1: {
                    System.out.println("Enter ID:");
                    int empID = scan.nextInt();
                    System.out.println("Enter Name");
                    String empName = scan.next();
                    System.out.println("Enter Job Role:");
                    String empDesc = scan.next();
                    System.out.println("Enter Salary");
                    int empSal = scan.nextInt();
                    obj.addEmp(new Employee(empID, empSal, empName, empDesc));
                    break;
                }

                case 2: obj.viewEmp();break;
                case 3: {
                    System.out.println("Enter name of emp to search:");
                    String name = scan.next();
                    System.out.println("Enter the updated salary:");
                    int sal = scan.nextInt();
                    obj.editEmp(name, sal);
                    break;
                }
                case 4:{
                    System.out.println("Enter the emp ID to search:");
                    int ids = scan.nextInt();
                    obj.searchEmp(ids);
                    break;
                }
                case 5:{
                    System.out.println("Enter the name you want to delete:");
                    String names = scan.next();
                    obj.delete(names);
                    break;
                }

                case 6:run = false; break;
                default:
                    System.out.println("You have to choose between 1 to 5");
            }
        }

    }
}