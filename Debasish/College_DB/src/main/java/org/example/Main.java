package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CollegeBo college=new CollegeBo();
        while(true){
            System.out.println("enter 1 for add college\nenter 2 for search college\nenter 3 for location search\nenter 4 for date search");
            int input=sc.nextInt();
            switch (input)
            {
                case 1:
                    college.add();
                    break;
                case 2:
                    System.out.print("enter no of college you want to search : ");
                    int num=sc.nextInt();
                    List<String> namelist=new ArrayList<>();
                    for(int i=0;i<num;i++){
                        System.out.print("Enter college name:");
                        String collegeName=sc.next();
                        namelist.add(collegeName);
                    }

                    List<College> col=college.findCollege(namelist);
                    System.out.println("1.Sort by name");
                    System.out.println("2.Sort by Date");
                    System.out.println("3.Sort by DEPT NO");
                    System.out.print("Enter your choice : ");
                    int ch1 = sc.nextInt();
                    switch (ch1){
                        case 1:{
                            Collections.sort(col,(o1, o2)->o1.getName().compareTo(o2.getName()));
                            break;
                        }
                        case 2:{
                            Collections.sort(col,(o1,o2)->o1.getStartingDate().compareTo(o2.getStartingDate()));
                            break;
                        }
                        case 3:{
                            Collections.sort(col,(o1,o2)->o1.getNumberOfDept()>o2.getNumberOfDept()?1:-1);
                            break;
                        }
                        default:{
                            System.out.println("Wrong Entry");
                        }
                    }
                    for(College i:col){
                        System.out.println(i);
                    }
                    break;
                case 3:
                    System.out.print("Enter location for your College : ");
                    String loc= sc.next();
                    List<College> colByLocation=college.findCollege(loc);
                    for(College i:colByLocation){
                        System.out.println(i);
                    }
                case 4:
                    System.out.print("Enter year : ");
                    int year = sc.nextInt();
                    System.out.print("Enter Month : ");
                    int month = sc.nextInt();
                    System.out.print("Enter Day : ");
                    int day = sc.nextInt();
                    Date collegeDate = new Date(year,month,day);
                    List<College> list3 = new ArrayList<>();
                    list3 = college.findCollege(collegeDate);
                    for(College c:list3){
                        System.out.println(c);
                    }
                    if(list3.isEmpty()){
                        System.out.println("No colleges found");
                    }
                    break;

            }
        }

    }
}