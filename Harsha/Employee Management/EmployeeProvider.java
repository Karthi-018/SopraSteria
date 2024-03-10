package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeProvider {
    public static Employee createEmployee(int eId, String name, String dept, double sal){
        return new Employee(eId, name, dept, sal);
    }

    public static class SwitchHelper {
        static Scanner s = new Scanner(System.in);

        public static boolean isDbEmpty(ArrayList<Employee> db){
            if(db.isEmpty()){
                System.out.println("No employees created");
                return true;
            }
            else
                return false;
        }

        public static void createEmployee(ArrayList<Employee> db){
            System.out.println("Enter employee details:");
            System.out.println("Employee id: ");
            int eid = s.nextInt();
            String s1 = s.nextLine();
            System.out.println("Employee name: ");
            String name = s.nextLine();
            System.out.println("Employee dept: ");
            String dept = s.nextLine();
            System.out.println("Employee sal: ");
            double sal = s.nextDouble();
            db.add(EmployeeProvider.createEmployee(eid, name, dept, sal));
        }
        public static void retrieveEmployee(ArrayList<Employee> db){
            System.out.println("Enter the eid to retrieve:");
            int eid = s.nextInt();
            for (Employee e : db) {
                if(e.geteId() == eid)
                    System.out.println(e);
            }
        }

        public static void updateEmployee(ArrayList<Employee> db){
            System.out.println("Enter the eid to update:");
            int eid = s.nextInt();
            String s1 = s.nextLine();
            for (Employee e : db) {
                if(e.geteId() == eid){
                    System.out.println("Enter updated employee details:");
                    System.out.println("Employee name: ");
                    String name = s.nextLine();
                    System.out.println("Employee dept: ");
                    String dept = s.nextLine();
                    System.out.println("Employee sal: ");
                    double sal = s.nextDouble();
                    //setting new values
                    e.setName(name);
                    e.setDept(dept);
                    e.setSal(sal);
                    return;
                }
            }
            System.out.println("Employee id doesn't exist");
        }
        public static void deleteEmployee(ArrayList<Employee> db){
            System.out.println("Enter the eid to delete:");
            int eid = s.nextInt();
            for (Employee e : db) {
                if(e.geteId() == eid){
                    boolean isRemovalSuccess = db.remove(e);
                    if(isRemovalSuccess)
                        System.out.println("Employee deleted successfully");

                    return;
                }
            }
            System.out.println("Employee id doesn't exist");
        }
        public static void showEmployees(ArrayList<Employee> db) {
            for (Employee emp : db) {
                System.out.println(emp);
            }
        }

    }
}