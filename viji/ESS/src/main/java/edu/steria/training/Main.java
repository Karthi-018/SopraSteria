package edu.steria.training;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc=new Scanner(System.in);
        Admin ad=new Admin();
        int flag=0,id;
        System.out.println("Welcome to employee Management");
        while(flag==0) {
            System.out.println("1.add\n2.view\n3.edit\n4.search\n5.delete\n6.exit\n");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ad.add();
                    break;
                case 2:
                    ad.view();
                    break;
                case 3:
                    System.out.println("Enter the employee id to edit:");
                    id=sc.nextInt();
                    ad.edit(id);
                    break;
                case 4:
                    System.out.println("Enter the employee id to Search:");
                    id=sc.nextInt();
                    ad.search(id);
                    break;
                case 5:
                    System.out.println("Enter the employee id to delete:");
                    id=sc.nextInt();
                    ad.delete(id);
                    break;
                case 6:
                    flag=1;
                    break;
            }
        }
    }
}