package org.example;
import java.util.*;

public class MainAdmin implements Admin{
    Employee[] empArray = new Employee[10];
    int lastIndex = -1;
    Scanner sc = new Scanner(System.in);
   public void add(){
        if(lastIndex==9){
            System.out.println("Database Full");
            return;
        }
        empArray[lastIndex+1] = new Employee();

        System.out.print("Enter Employee ID:");
        empArray[lastIndex+1].eId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name:");
        empArray[lastIndex+1].eName =sc.nextLine();
        System.out.print("Enter Employee Dept:");
        empArray[lastIndex+1].eDept = sc.nextLine();
        System.out.print("Enter Employee Salary:");
        empArray[lastIndex+1].salary = sc.nextInt();
        System.out.println("");
        System.out.println("Employee added");
        lastIndex++;
    }
    public void view(){
        if(lastIndex == -1){
            System.out.println("--------------------");

            System.out.println("No Records");
            System.out.println("--------------------");

            return;
        }
        System.out.println("Employees data:");
        System.out.println("------------");
        for(int i=0;i<10;i++){
            if(empArray[i] == null){
                continue;
            }
            System.out.println("--------------------");
            System.out.println("Employee ID: "+empArray[i].eId);
            System.out.println("Employee Name: "+empArray[i].eName);
            System.out.println("Employee Department: "+empArray[i].eDept);
            System.out.println("Employee Salary: "+empArray[i].salary);
            System.out.println("--------------------");
        }
    }
    public void search(){
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        for(int i=0;i<10;i++){
            if(empArray[i] == null){
                return;
            }
            if(empArray[i].eId==id){
                System.out.println("--------------------");
                System.out.println("Employee ID: "+empArray[i].eId);
                System.out.println("Employee Name: "+empArray[i].eName);
                System.out.println("Employee Department: "+empArray[i].eDept);
                System.out.println("Employee Salary: "+empArray[i].salary);
                System.out.println("--------------------");
                return;
            }
        }
        System.out.println("--------------------");
        System.out.println("No records found");
        System.out.println("--------------------");

    }
    public void edit(){
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        for(int i=0;i<10;i++){
            if(empArray[i] == null){
                return;
            }
            if(empArray[i].eId==id){

                sc.nextLine();
                System.out.print("Enter Employee Name:");
                empArray[i].eName =sc.nextLine();
                System.out.print("Enter Employee Dept:");
                empArray[i].eDept = sc.nextLine();
                System.out.print("Enter Employee Salary:");
                empArray[i].salary = sc.nextInt();
                System.out.println("Employee Data Changed");
                return;
            }
        }
        System.out.println("--------------------");
        System.out.println("No records found");
        System.out.println("--------------------");
    }
    public void delete(){
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.println("Employee Data Deleted");
        for(int i=0;i<10;i++){
            if(empArray[i] == null){
                return;
            }
            if(empArray[i].eId==id){
               for(int j=i;j<9;j++){
                   if(empArray[j+1]!=null) {
                      empArray[j] = empArray[j+1];
                   }
                   else{
                       empArray[j]=null;
                       break;
                   }
               }
               lastIndex--;
               return;
            }
        }
        System.out.println("--------------------");
        System.out.println("No records found");
        System.out.println("--------------------");
    }

}
