package edu.steria.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        EmployeeManagment em = new EmployeeManagment();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            boolean flag = false;

            System.out.println("Welcome to Employee Management system.........");
            System.out.println("1.Enter\n2.Exit");
            System.out.print("Enter your choice (1 or 2): ");
            int ch = sc.nextInt();

            if(ch==2)
            {
                System.out.println("Leaving the employee management system.......");
                break;
            }
            else if(ch==1)
            {
                while(true)
                {

                    System.out.println("1.Add Employee\n2.View Employee\n3.Edit Employee\n4.Search Employee\n5.Delete Employee\n6.Exit");
                    System.out.print("Enter your choice: ");
                    int opch = sc.nextInt();
                    switch (opch) {
                        case 1:
                            System.out.print("Enter name: ");
                            String name = sc.next();
                            System.out.print("Enter Employee id: ");
                            int id = sc.nextInt();
                            System.out.print("Enter Employee Dept: ");
                            String dept = sc.next();
                            System.out.print("Enter Employee Salary: ");
                            double sal = sc.nextDouble();
                            Employee e = new Employee(name, id, dept,sal);
                            em.addEmp(e);
                            break;

                        case 2:
                            em.viewEmp();
                            break;

                        case 3:
                            System.out.print("Enter the employee id to edit: ");
                            int edid = sc.nextInt();
                            em.editEmp(edid);
                            break;

                        case 4:
                            System.out.print("Enter the employee id to search: ");
                            int sid = sc.nextInt();
                            em.searchEmp(sid);
                            break;

                        case 5:
                            System.out.print("Enter the employee id to delete: ");
                            int did = sc.nextInt();
                            em.delEmp(did);
                            break;
                        case 6:
                            flag = true;
                            break;
                        default:
                            System.out.println("Invalid option.........");
                    }
                    if(flag)
                    {
                        break;
                    }

                }
            }
            else
            {
                System.out.println("Invalid option..........");
            }

        }
    }
}