package edu.steria.train;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.*;
 public class College  {
    static List<CollegePojo> collegeList = new ArrayList<CollegePojo>();
    static Scanner sc=new Scanner(System.in);
    public void add() throws ParseException {
        System.out.println("Enter String in Given Format");
        String detail=sc.nextLine();
        CollegePojo c = CollegePojo.createCollege(detail);
        collegeList.add(c);
    }

        static public void display() {
            System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",
                    "Name", "Website", "Mobile", "Founder", "No of departments", "Location", "Starting date");

            for (CollegePojo college : collegeList) {
                System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",
                        college.getName(), college.getWebsite(), college.getMobile(),
                        college.getFounder(), college.getNumberOfDept(), college.getLocation(),
                        college.getStartingDate());
            }

        }
    public void sorting() {
        System.out.println("Enter Sorting Mode");
        System.out.println("1.Sort by Name");
        System.out.println("2.Sort by Number Of Departments");
        System.out.println("3.Sort by Starting Date");
        System.out.println();
        System.out.println("Enter your Choice");
        int i = sc.nextInt();
        sc.nextLine();
        switch (i) {
            case 1:Collections.sort(collegeList, (i1, i2) -> (i1.getName().compareTo(i2.getName())));
                display();
                break;

            case 2:Collections.sort(collegeList, (i1, i2) -> (i1.getNumberOfDept() > i2.getNumberOfDept() ? 1 : -1));
                display();

                    break;

            case 3:Collections.sort(collegeList, (i1, i2) -> (i1.getStartingDate().compareTo(i2.getStartingDate())));
                 display();
                break;

        }
    }


}



