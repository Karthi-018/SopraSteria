package edu.steria;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.lang.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CollegeBO co = new CollegeBO();
        Scanner sc = new Scanner(System.in);
        List<String> nameList = new ArrayList<String>();
        System.out.println("Enter the no. of colleges should be added..");
        int n = sc.nextInt();
        List<College> college1 = new ArrayList<>();
        nameList=co.addname(n, nameList);
        System.out.println("Enter the method to search");
        System.out.println("1.search by name\n2.search by date\n3.search by location");
        int search=sc.nextInt();
        switch(search) {
            case 1:
                college1 = co.findCollege(nameList);
                college1=co.sort(college1);
                for (College i : college1) {
                    System.out.println(i);
                }
                break;
            case 2:
                System.out.println("Enter the date (YYYY-MM-DD) :  ");
                String reqDate = sc.next();
                college1 = co.findCollege(reqDate);
                college1=co.sort(college1);
                for (College i : college1) {
                    System.out.println(i);
                }
                break;
            case 3:
                System.out.println("Enter the location :  ");
                String loc = sc.next();
                college1 = co.findCollege1(loc);
                college1 = co.sort(college1);
                if (college1.isEmpty()) {
                    System.out.println("No colleges found at the specified location.");
                } else {
                    for (College i : college1) {
                        System.out.println(i);
                    }
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }











    }
    }
