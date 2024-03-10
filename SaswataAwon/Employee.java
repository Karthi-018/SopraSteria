package sopra.training;

import java.util.Scanner;

public class Employee {

    String empID;
    String empName;
    String dept;
    String empSalary;

    static String[][] empDetails= new String[10][4];

    public Employee(){
    }

    public Employee(String empID) {
        this();
        this.empID = empID;
        System.out.println("ID is : " + empID);
    }

    public Employee(String empID, String empName) {
        this(empID);
        this.empID = empID;
        this.empName = empName;
        System.out.println("Name is : " + empName);
    }

    public Employee(String empID, String empName, String dept) {
        this(empID,empName);
        this.empID = empID;
        this.empName = empName;
        this.dept = dept;
        System.out.println("Department is : " + dept);
    }

    public Employee(String empID, String empName, String dept, String empSalary) {
        this(empID,empName,dept);
        this.empID = empID;
        this.empName = empName;
        this.dept = dept;
        this.empSalary = empSalary;
        System.out.println("Salary is : " + empSalary);
    }

    void empView(){
        System.out.println("Employee details in the list are: ");
        for(int i=0;i<10;i++){
            if(empDetails[i][0]!=null){
                Employee e=new Employee(empDetails[i][0],empDetails[i][1],empDetails[i][2],empDetails[i][3]);
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    void empAdd(){
        Scanner s=new Scanner(System.in);

        for(int i=0;i<10;i++){

            System.out.print("Add Employee Details ? (Y/N) : ");
            String choice=s.nextLine();

            if(choice.equals("Y")) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) {
                        System.out.print("Enter Employee ID : ");
                        empDetails[i][j] = s.nextLine();
                    } else if (j == 1) {
                        System.out.print("Enter Employee Name : ");
                        empDetails[i][j] = s.nextLine();
                    } else if (j == 2) {
                        System.out.print("Enter Employee Department : ");
                        empDetails[i][j] = s.nextLine();
                    } else {
                        System.out.print("Enter Employee Salary : ");
                        empDetails[i][j] = s.nextLine();
                    }

                }
                System.out.println(empDetails[i][1] + "'s details of Employee ID : " + empDetails[i][0] + " is added. ");
                System.out.println(("---------------------------------------------"));


            }
            else{
                break;
            }
        }
    }

    void empEdit(){
        Scanner t=new Scanner(System.in);
        System.out.print("Enter the Employee Id whose you want to edit : ");
        String id=t.nextLine();
        int pos=10;

        for(int i=0;i<10;i++){

            if(empDetails[i][0]!=null){
                if(id.equals(empDetails[i][0])) {
                    pos = i;
                    break;
                }
            }
        }
        if(pos==10){
            System.out.println("Employee ID not found");
        }
        else{
            System.out.println("Update the details : ");
            System.out.print(" Update Name : ");
            empDetails[pos][1]=t.nextLine();
            System.out.print(" Update Dept : ");
            empDetails[pos][2]=t.nextLine();
            System.out.print(" Update Salary : ");
            empDetails[pos][3]=t.nextLine();
        }
        System.out.println("-----------------------------------------------");
    }

    void empSearch(){
        Scanner u=new Scanner(System.in);
        System.out.print("Enter the Employee Id whose you want to search : ");
        String id=u.nextLine();
        int pos=10;

        for(int i=0;i<10;i++){

            if(empDetails[i][0]!=null){
                if(id.equals(empDetails[i][0])) {
                    pos = i;
                    break;
                }
            }
        }
        if(pos==10){
            System.out.println("Employee ID not found");
            System.out.println("-----------------------------------------------");
        }
        else{
            System.out.println("Employee details found : \n" + "Name : " + empDetails[pos][1] + "\n" + "Dept : " + empDetails[pos][2] + "\n" + "Salary : " + empDetails[pos][3]);
            System.out.println("-----------------------------------------------");
        }
    }

    void empDelete(){
        Scanner o=new Scanner(System.in);
        System.out.print("Enter the Employee Id whose you want to delete : ");
        String id=o.nextLine();
        int pos=10;

        for(int i=0;i<10;i++){

            if(empDetails[i][0]!=null){
                if(id.equals(empDetails[i][0])) {
                    pos = i;
                    break;
                }
            }
        }
        for(int i=pos;i<10;i++){
            if(empDetails[pos][0]!=null){
                System.arraycopy(empDetails[i + 1], 0, empDetails[i], 0, 4);
            }
        }


    }



    public static void main(String[] args) {
        Employee w=new Employee();
        Scanner s=new Scanner(System.in);

        System.out.println("WELCOME TO EMPLOYEE SYSTEM DATABASE");
        System.out.println(("---------------------------------------------"));

        while(true){
            System.out.println("1) Select 1 to Add \n2) Select 2 to view the list \n3) Select 3 to edit \n4) Select 4 to search \n5) Select 5 to delete \n6) Select 6 to exit");
            System.out.print("Your Choice : ");
            int ch=s.nextInt();

            switch(ch){
                case 1: w.empAdd(); break;
                case 2: w.empView(); break;
                case 3: w.empEdit(); break;
                case 4: w.empSearch(); break;
                case 5: w.empDelete(); break;
                case 6: System.exit(0); break;
            }
        }


    }
}
