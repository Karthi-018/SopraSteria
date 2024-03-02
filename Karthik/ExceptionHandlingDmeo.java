package org.example.exception.demo;

import java.util.Scanner;

public class ExceptionHandlingDmeo {

    public void throwsFunctionDemo(int n1,int n2, String str,int arr[]) throws ArithmeticException,NullPointerException,ArrayIndexOutOfBoundsException
    {
        System.out.println("The division of two number is : "+(n1/n2));
        throwsFunctionDemo(str,arr);
    }
    public void throwsFunctionDemo(String str,int arr[]) throws NullPointerException,ArrayIndexOutOfBoundsException
    {
        System.out.println("The Length of the str is : "+str.length());
        throwsFunctionDemo(arr);
    }

    public void throwsFunctionDemo(int arr[]) throws ArrayIndexOutOfBoundsException
    {
        for(int i=0;i<=5;i++)
            System.out.print(arr[i]);
    }

    public static void main(String[] args)  {



        Scanner s = new Scanner(System.in);
        System.out.println("Enter N1 value");
        int n1 = s.nextInt();
        System.out.println("Enter N2 value");
        int n2 = s.nextInt();
        String str="null";
        int arr[] = {1,2,3,4,5};
        try {
            new ExceptionHandlingDmeo().throwsFunctionDemo(n1, n2, str, arr);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
}
