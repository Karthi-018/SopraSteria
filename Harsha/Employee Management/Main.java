package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> db = new ArrayList<>();
        while (true) {
            System.out.println("""
                            ---MENU---
                    1.Create Employee
                    2.Retrieve Employee
                    3.Update Employee
                    4.Delete Employee
                    5.Show Employees
                    6.Exit
                            """);
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    SwitchHelper.createEmployee(db);
                    break;

                case 2:
                    if(SwitchHelper.isDbEmpty(db)) break;

                    SwitchHelper.retrieveEmployee(db);
                    break;
                case 3:
                    if(SwitchHelper.isDbEmpty(db)) break;
                    SwitchHelper.updateEmployee(db);
                    break;
                case 4:
                    if(SwitchHelper.isDbEmpty(db)) break;
                    SwitchHelper.deleteEmployee(db);
                    break;
                case 5:
                    if(SwitchHelper.isDbEmpty(db)) break;
                    SwitchHelper.showEmployees(db);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}