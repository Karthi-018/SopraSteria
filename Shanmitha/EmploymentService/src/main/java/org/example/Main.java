package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        EmployeeFunctions emp=new EmployeeFunctions();
        int flag=0,id;
        while(flag==0) {
            System.out.println("\n1.add\n2.view\n3.edit\n4.search\n5.delete\n6.exit\n");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    emp.add();
                    break;
                case 2:
                    emp.view();

                    break;
                case 3:
                    System.out.println("Enter the employee id to edit:");
                    id=sc.nextInt();
                    emp.edit(id);
                    break;
                case 4:
                    System.out.println("Enter the employee id to Search:");
                    id=sc.nextInt();
                    emp.search(id);
                    break;
                case 5:
                    System.out.println("Enter the employee id to delete:");
                    id=sc.nextInt();
                    emp.delete(id);
                    break;
                case 6:
                    flag=1;
                    break;
            }
        }
    }
}