package org.example;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        MainAdmin admin = new MainAdmin();
        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("1.Add Employee");
//            System.out.println("2.Edit Employee");
//            System.out.println("3.Search Employee");
//            System.out.println("4.Delete Employee");
//            System.out.println("5.View Employees");
//            System.out.println("6.Exit");
//            System.out.print("Enter your choice: ");
//            int choice = sc.nextInt();
//            if(choice == 6)break;
//            if(choice<0 && choice>6){
//                System.out.println("------------");
//                System.out.println("Wrong Entry");
//                System.out.println("------------");
//                continue;
//            }
//            switch (choice){
//                case 1:{
//                    admin.add();
//                    break;
//                }
//                case 2:{
//                    admin.edit();
//                    break;
//                }
//                case 3:{
//                    admin.search();
//                    break;
//                }
//                case 4:{
//                    admin.delete();
//                    break;
//                }
//                case 5:{
//                    admin.view();
//                }
//
//            }
//        }

        List<Employee> emp = new ArrayList<>();
        Comparator<Employee> sort = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary>o2.salary?1:-1;
            }
        };
        emp.add(new Employee(123,"eyey","ie",28282));
        emp.add(new Employee(123,"eyey","ie",12));
        emp.add(new Employee(123,"eyey","ie",82));
        emp.add(new Employee(123,"eyey","ie",2));
        Collections.sort(emp,(o1,o2)->o1.salary<o2.salary?1:-1 );
        for(Employee e:emp){
            System.out.println(e);
        }
    }

}