package edu.sopra;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemDao iD=new ItemDao();
        Scanner sc=new Scanner(System.in);
        List<Item> li=new ArrayList<>();
        while(true)
        {
            System.out.println("Press 1 to add item");
            System.out.println("Press 2 to exit the add method");
            System.out.println();
            int entry=sc.nextInt();
            if(entry==1)
            {
                System.out.println("enter the values in (name,price,type) format : ");
                String s=sc.next();
                String[] arr=s.split(",",0);
                double d=Double.parseDouble(arr[1]);

                li.add(new Item(arr[0],d,arr[2]));

            }
            else
            {
                    break;
            }
        }

        iD.bulkCopy(li);

        while(true)
        {

            System.out.println("------------------------------------------------");
            System.out.println("Press 1 to search items based on type");
            System.out.println("Press 2 to search items based on price");
            System.out.println("Press 3 to exit from the program");
            int entry=sc.nextInt();
            if(entry==1)
            {
                System.out.println("enter the items to be found based on type :");
                String s=sc.next();
                List list1=iD.findItem(s);

                if(list1.size()==0)
                {
                    System.out.println("no such item is present");
                }
                else
                {
//                    for(int i=0;i<list1.size();i++)
//                    {
////                        System.out.format("%-20s %-5s %s\n","name","price","type");
//
//                    }
//
                }

            } else if (entry==2)
            {
                System.out.println("enter the items to be found based on price :");
                double dd=sc.nextDouble();
                List list2=iD.findItem(dd);
                if(list2.size()==0)
                {
                    System.out.println("no such item is present");
                }
                else
                {
//                    for(int i=0;i<list2.size();i++)
//                    {
////                        System.out.format("%-20s %-5s %s\n","i.getName()","i.getPrice","i.getType");
//
//                    }

                }
            } else if (entry==3)
            {
                break;
            }
        }



    }
}