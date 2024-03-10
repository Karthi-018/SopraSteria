package edu.steria.training;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static CollegeBO cb = new CollegeBO();
    public static void findColleges()
    {

        boolean flag = false;

        while(true)
        {
            System.out.println("1.Find college using name list\n2.Find college using starting date\n3.Find college using location\n4.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    List<String> clist = new ArrayList<>();
                    System.out.print("Enter num of colleges to search: ");
                    int n = sc.nextInt();
                    System.out.println("Enter colleges: ");
                    for (int i = 0; i < n; i++) {
                        clist.add(sc.next());
                    }
                    List<College> clg = cb.findCollege(clist);
                    for(College c: clg)
                    {
                        System.out.println(c);
                    }
                    if(clg.isEmpty())
                    {
                        System.out.println("No colleges are found.......");
                    }
                    else if((clg.size()!=0) && (n>clg.size()))
                    {
                        System.out.println("Other colleges are not found........");
                    }
                    break;

                case 2:
                    System.out.print("Enter college starting date: ");
                    String sDate = sc.next();
                    Date date = Date.valueOf(sDate);
                    List<College> clg2 = cb.findCollege(date);
                    for(College c: clg2)
                    {
                        System.out.println(c);
                    }
                    if(clg2.isEmpty())
                    {
                        System.out.println("No college is found.......");
                    }
                    break;

                case 3:
                    System.out.print("Enter location to search: ");
                    String loc = sc.next();
                    List<College> clg3 = cb.findCollege(loc);
                    for(College c: clg3)
                    {
                        System.out.println(c);
                    }
                    if(clg3.isEmpty())
                    {
                        System.out.println("No college is found.......");
                    }
                    break;

                case 4:
                    System.out.println("Leaving..........");
                    flag = true;
                    break;

                default:
                    System.out.println("Improper Option........");
                    break;
            }
            if(flag)
            {
                break;
            }
        }

    }

    public static void sortColleges()
    {
        List<College> cl = cb.getCollegeList();

        while(true)
        {
            System.out.println("Sort by:\n1.Name\n2.Starting Date\n3.Number of Dept\n4.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();


            if(ch==1)
            {
                cl.sort((cl1,cl2) -> cl1.getName().compareTo(cl2.getName())>0 ? 1 : -1);
                for(College c: cl)
                {
                    System.out.println(c);
                }
            }
            else if (ch==2)
            {
                cl.sort((cl1,cl2)->(cl1.getStartingDate()).compareTo(cl2.getStartingDate())>0? 1: -1);
                for(College c: cl)
                {
                    System.out.println(c);
                }
            }
            else if (ch==3)
            {
                cl.sort((cl1,cl2)->(cl1.getNumberOfDept()>cl2.getNumberOfDept()?1:-1));
                for(College c: cl)
                {
                    System.out.println(c);
                }
            }
            else if (ch==4)
            {
                System.out.println("Leaving.....");
                break;
            }
            else
            {
                System.out.println("Improper option.....");
            }
        }
    }


    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("1.Find Colleges\n2.Sort Colleges\n3.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            if(ch==1)
            {
                findColleges();
            }
            else if (ch==2)
            {
                sortColleges();
            }
            else if (ch==3)
            {
                System.out.println("Leaving Application..........");
                break;
            }
            else
            {
                System.out.println("Improper choice..............");
            }
        }
    }
}
