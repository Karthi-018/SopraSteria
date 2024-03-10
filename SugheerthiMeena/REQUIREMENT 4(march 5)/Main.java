package edu.steria.training;
import java.util.*;
import java.text.*;

public class Main
{
    public static void main(String[] args)
    {

        boolean choice = true;
        int option;
        String ans = "";
        String name;
        String website;
        String mobile;
        String founder;
        int numberOfDept;
        String location;
        String strDate;
        Date startingDate;

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<College> collegeList = new ArrayList<>();

        try {
            while (choice) {
                System.out.println("Enter College Details");
                System.out.println("Name : ");
                name = scanner.nextLine();
                System.out.println("Website: ");
                website = scanner.nextLine();
                System.out.println("Mobile : ");
                mobile = scanner.nextLine();
                System.out.println("Founder : ");
                founder = scanner.nextLine();
                System.out.println("Total Departments : ");
                numberOfDept = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Location : ");
                location = scanner.nextLine();
                System.out.println("Starting Date(DD/MM/YYYY) : ");
                strDate = scanner.next();
                startingDate = simpleDateFormat.parse(strDate);

                collegeList.add(College.createCollege(name, website, mobile, founder, numberOfDept, location, startingDate));

                System.out.println("Want to add more colleges ? ");
                ans = scanner.next();
                if (ans.equals("y")) {
                    choice = true;
                } else {
                    choice = false;
                    break;
                }
            }

            System.out.println("List of colleges ");
            for (College college : collegeList) {
                System.out.println(college);
            }

            System.out.println("View colleges based on \n1.Name \n2.Date \n3.Department");
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Sorting based on name");
                    Collections.sort(collegeList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
                    for (College college : collegeList) {
                        System.out.format("%-15s %-20s %-15s %-15s %-20d %-15s %s\n",
                                college.getName(), college.getWebsite(), college.getMobile(),
                                college.getFounder(), college.getNumberOfDept(), college.getLocation(),
                                college.getStartingDate());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Sorting based on date");
                    Collections.sort(collegeList, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));
                    for (College college : collegeList) {
                        System.out.format("%-15s %-20s %-15s %-15s %-20d %-15s %s\n",
                                college.getName(), college.getWebsite(), college.getMobile(),
                                college.getFounder(), college.getNumberOfDept(), college.getLocation(),
                                college.getStartingDate());
                    }
                    break;
                }
                case 3: {

                    System.out.println("Sorting based on departments");
                    Collections.sort(collegeList, (c1, c2) -> c1.getNumberOfDept().compareTo(c2.getNumberOfDept()));
                    for (College college : collegeList) {
                        System.out.format("%-15s %-20s %-15s %-15s %-20d %-15s %s\n",
                                college.getName(), college.getWebsite(), college.getMobile(),
                                college.getFounder(), college.getNumberOfDept(), college.getLocation(),
                                college.getStartingDate());
                    }
                    break;
                }
                default: {
                    System.out.println("exiting....");
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}