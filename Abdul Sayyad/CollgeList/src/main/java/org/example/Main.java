package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CollegeBO college = new CollegeBO();
        while (true){
            System.out.println("1.Add College");
            System.out.println("2.Search Colleges");
            System.out.println("3.Search college Data by date");
            System.out.println("4.Search college data by location");
            System.out.println("5.Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            if(choice == 5) break;
            switch (choice){
                case 1:{
                    college.add();
                    break;
                }
                case 2:{
                    System.out.print("Enter No of colleges : ");
                    int n = sc.nextInt();
                    List<String> list = new ArrayList<>();
                    String collegeNam;
                    sc.nextLine();
                    for(int i=0;i<n;i++){
                        System.out.print("Enter College Name : ");
                        collegeNam = sc.nextLine();
                        list.add(collegeNam);
                        //sc.nextLine();
                    }
                    List<College> list1 = new ArrayList<>();
                    list1 = college.findCollege(list);
                    System.out.println(list);
                    System.out.println("1.Sort by name");
                    System.out.println("2.Sort by Date");
                    System.out.println("3.Sort by Department No");
                    System.out.print("Enter your choice : ");
                    int ch1 = sc.nextInt();
                    switch (ch1){
                        case 1:{
                            Collections.sort(list1,(o1,o2)->o1.getName().compareTo(o2.getName()));
                            break;
                        }
                        case 2:{
                            Collections.sort(list1,(o1,o2)->o1.getStartingDate().compareTo(o2.getStartingDate()));
                       break;
                        }
                        case 3:{
                            Collections.sort(list1,(o1,o2)->o1.getNumberOfDept()>o2.getNumberOfDept()?1:-1);
                             break;
                        }
                        default:{
                            System.out.println("Wrong Entry");
                        }
                    }
                    for(College c:list1){
                        System.out.println(c);
                    }
                    break;
                }
                case 3:{
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
                case 4:{
                    System.out.print("Enter location : ");
                    String collegeLocation = sc.next();
                    List<College> list4 = new ArrayList<>();
                    list4 = college.findCollege(collegeLocation);
                    for(College c:list4){
                        System.out.println(c);
                    }
                    if(list4.isEmpty()){
                        System.out.println("No colleges found");
                    }
                    break;
                }
                default:{
                    System.out.println("Wrong Entry");
                }

            }
        }
    }
}
