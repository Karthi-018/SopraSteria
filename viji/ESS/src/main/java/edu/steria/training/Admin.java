package edu.steria.training;

import java.util.*;


public class Admin {
    List<Employee> empl = new ArrayList<>();

    int i = 0, cnt = 0;
    Scanner sc = new Scanner(System.in);

    public void add() {
        System.out.println("Enter no of employees to add: ");
        int n=sc.nextInt(),i=0;
        while(i++<n) {
            Employee emp = new Employee();
            System.out.println("Enter Employee Name:");
            String name = sc.next();

            System.out.println("Enter Employee ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Employee Dept:");
            String dept = sc.nextLine();
            System.out.println("Enter the salary:");
            int salary = sc.nextInt();
            System.out.println("\n");
            emp.setEmpName(name);
            emp.setDept(dept);
            emp.setEmpId(id);
            emp.setSalary(salary);
            cnt++;
            empl.add(emp);
        }
        System.out.println("\n ****Added Successfully****");
    }

    public void search(int id) {
        int flag=0;
        for (i = 0; i < empl.size(); i++) {
            if (id == empl.get(i).getEmpId()) {
                flag=1;
                System.out.println(empl.get(i));
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("Employee not found! ! !");
        }
    }

    public void edit(int id) {
        int flag=0;
        for (i = 0; i < empl.size(); i++) {
            if (id == empl.get(i).getEmpId()) {
                flag=1;
                System.out.println("Enter the choice to edit: ");
                System.out.println("1.Employee Id\n2.Employee name\n3.Department\n4.Salary");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter new ID:");
                        empl.get(i).setEmpId(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Enter new Name:");
                        empl.get(i).setEmpName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter new Department:");
                        empl.get(i).setDept(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter new Salary:");
                        empl.get(i).setSalary(sc.nextInt());
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                System.out.println("\n Updated successfully! ! !");
            }
        }
        if(flag==0)
        {
            System.out.println("Employee not found! ! !");
        }
    }

    public void view() {
        for (i = 0; i < empl.size(); i++) {

            if (empl.get(i) != null) {
                System.out.println(empl.get(i));

            }

        }
    }

    public void delete(int id) {
        int flag=0;
        for (i = 0; i < empl.size(); i++) {
            System.out.println(empl.get(i).getEmpId());
            if (id == empl.get(i).getEmpId()) {
                empl.remove(i);
                flag=1;
                System.out.println("\nRecord removed from the list");
            }
            this.view();
        }
        if(flag==0)
        {
            System.out.println("Employee not found!!");
        }

    }
}

