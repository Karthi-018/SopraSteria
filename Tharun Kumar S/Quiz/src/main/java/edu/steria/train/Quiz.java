package edu.steria.train;

import java.util.Scanner;

//import static jdk.internal.vm.vector.VectorSupport.test;

public class Quiz {
    Scanner sc=new Scanner(System.in);
    private String arr[]={"1.What was the score in the Euro 2012 final?\nA.2-0\nB.3-0\nC.4-0\nD.1-0","2.What was the score in the Euro 2016 final?\nA.2-0\nB.3-0\nC.4-0\nD.1-0","3.What was the score in the WC 2010 final?\nA.2-0\nB.3-0\nC.4-0\nD.1-0","4.What was the score in the WC 2018 final?\nA.4-2\nB.3-1\nC.2-0\nD.1-0","3.Who won the WC 2022?\nA.Argentina\nB.France\nC.Brasil\nD.Germany"};
    private String crtAns[]={"C","D","D","A","A"};
    String ans[]=new String[5];
    public static int index=0;
    int marks=0;

    public void takeTest(){
        System.out.println("******************************************************************");
        System.out.println("Click Enter to Take Test");
        System.out.println("Click 0 to Abort Test");
        switch (sc.nextLine()) {
            case "0":
                System.out.println("Better luck next time");
                     break;
            default:
                System.out.println("******************************************************************");
                test();
                break;


    }
    }
    public void show(int i)
    {
                System.out.println(arr[i]);
                System.out.println();


    }
    public void displayAns(){
        for(int i=0;i<=index;i++){

            System.out.println(i+1+"."+ans[i]);
        }
        System.out.println("Click Enter to Submit Answers");
        System.out.println("Click 0 to Edit Answers");
        switch (sc.nextLine()) {
            case "0":System.out.println("Enter Question number of 5 to Edit");
                     int i=sc.nextInt();
                     sc.nextLine();
                     edit(i);
                     break;
            default:
                     score();
        }
    }
    public void score(){
        for(int i=0;i<=index;i++)
        {
            if(crtAns[i].equals(ans[i]))
            {
                this.marks+=1;
            }
        }
        System.out.println();
        System.out.println("Your Score is "+this.marks+"/"+(5));;

    }
    public void edit(int i){
        show(i-1);
        System.out.print("Enter the Choice :");
        ans[i-1]=sc.nextLine();
        System.out.println();
        displayAns();
    }
    public void test()
    {
            show(index);
            System.out.print("Enter the Choice :");
            ans[index]=sc.nextLine();
            System.out.println();
            if (index==0)
            {
                System.out.println("Click Enter for Next Question");
                sc.nextLine();
                index++;
                test();
            }
            else if(index<4) {
                System.out.println("Click enter for Next Question");
                System.out.println("Click 0 for Previous Question");
                switch (sc.nextLine()) {
                    case "0":
                        index--;
                        test();
                        break;
                    default:
                        index++;
                        test();
                }
            }
            else
                {
                    System.out.println();
                    System.out.println("Your Answers");
                    System.out.println();
                    displayAns();

                }


    }
}





