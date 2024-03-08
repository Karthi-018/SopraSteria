package edu.sopra;

import java.util.Scanner;

public class EmployeeService {
    Scanner sc=new Scanner(System.in);
    Employee[] arr=new Employee[5];
//    static int i =0;
    int len=arr.length;

    public void add()
    {
        while(true)
        {
            System.out.println("Add a new Employee: (Y/N) ");
            char ch=sc.next().charAt(0);
            if(ch=='Y')
            {

                System.out.print("enter the enp.name:  ");
                String name=sc.next();
                System.out.print("enter the enp.id:  ");
                int id=sc.nextInt();
                System.out.print("enter the enp.dept:  ");
                String dept=sc.next();

                arr[i]=new Employee(name,id,dept);

                i++;

            }
            else
            {
                System.out.println("Came out of the add function");
                break;
            }
        }


    }
    public void list()
    {
        for(Employee temp:arr)
        {
            System.out.println(temp);
        }
    }

    public void Edit()
    {

        System.out.println("Enter the Id ");
        String ename=sc.next();
        for(Employee temp:arr)
        {
            if(temp.getName().equals(ename))
            {
                System.out.println("Enter the name : ");
                String nam=sc.next();
                temp.setName(nam);
            }
            else {
                System.out.println("no employee found");
                break;
            }
        }
    }

    public void Delete()
    {
        System.out.println("Enter the value to be deleted ");
        int eid=sc.nextInt();
        int index=0;
//        for(int i=0;i< arr.length;i++){
//            if(arr[i].getId()==eid){
//                index = i;
//                break;
//            }
//        }
//        for(int i=index;i<arr.length-1;i++)
//        {
//            if(arr[i]!=null)
//            {
//                arr[i]=arr[i+1];
//
//            }
//
//
//        }


        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=null && arr[i].getId()==eid)
            {
                index=i;
                break;
            }
        }
        for(int i=index;i<arr.length;i++)
        {
            arr[i]=arr[i+1];
        }
    }
}
