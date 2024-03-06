package org.example;
import java.util.ArrayList;
import java.text.*;
import java.util.Collections;
import java.util.List;
import java.util.Date;

public class Main53 {
    public static void main(String[] args) throws ParseException{

        List<College> collegeList = new ArrayList<>();
        College obj1 = College.createCollege("GMR", "www.gmr.com", "912345", "G M Rao", 7, "Hyderabad", new SimpleDateFormat("dd-MM-yyyy").parse("07-07-1999"));
        College obj2 = College.createCollege("VIT", "www.vit.com", "912346", "V I Tarak", 10, "Chennai", new SimpleDateFormat("dd-MM-yyyy").parse("15-08-2007"));
        College obj3 = College.createCollege("SRM", "www.srm.com", "912347", "S Rao", 15, "Mumbai", new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2000"));
        College obj4 = College.createCollege("MIT", "www.mit.com", "912348", "G Rao", 6, "Kolkata", new SimpleDateFormat("dd-MM-yyyy").parse("28-04-2002"));
        College obj5 = College.createCollege("CIT", "www.cit.com", "912349", "M Rao", 13, "Bangalore", new SimpleDateFormat("dd-MM-yyyy").parse("04-10-2001"));
        collegeList.add(obj1);
        collegeList.add(obj2);
        collegeList.add(obj3);
        collegeList.add(obj4);
        collegeList.add(obj5);
        for(College i: collegeList)
        {
            System.out.println(i);
        }

        System.out.println("\n The above the is the original list \n");

        Collections.sort(collegeList, (c1, c2) -> c1.getName().compareTo(c2.getName()));

        for(College i: collegeList)
        {
            System.out.println(i);
        }

        System.out.println("\n The above the is the list after first sorting \n");

        Collections.sort(collegeList, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));

        for(College i: collegeList)
        {
            System.out.println(i);
        }

        System.out.println("\n The above the is the list after second sorting \n");

        Collections.sort(collegeList, (c1, c2) -> c1.getNumberOfDept().compareTo(c2.getNumberOfDept()));

        for(College i: collegeList)
        {
            System.out.println(i);
        }

        System.out.println("\n The above the is the list after third sorting \n");

        System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n", "Name", "Website", "Mobile", "Founder", "No of departments", "Location", "Starting date");
        for (College college : collegeList) {
            System.out.format("%-15s %-20s %-15s %-15s %-20d %-15s %s\n",
                    college.getName(), college.getWebsite(), college.getMobile(),
                    college.getFounder(), college.getNumberOfDept(), college.getLocation(),
                    college.getStartingDate());
        }
    }
}
