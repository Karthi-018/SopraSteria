package edu.sopra;
import java.util.*;
public class Admin {

        int points=0;
        Scanner sc=new Scanner(System.in);
        String[] questions=new String[]{"what is the capital of India?","What is google mean?","OOP full form"};
        String[][] options=new String[][]{{"Chennai","Delhi","Mumbai","Vellore"},{"a web","a game","a search engine","a place"},{"Object oriented programming","Object based programming","Class Based programming","Object derived Progarmming"}};
        String[] answers={"Delhi","a search engine","Object oriented programming"};

        void quest()
        {
                int i=0;
                while(true)
                {


                        System.out.println(questions[i]);
                        System.out.println();
                        System.out.println("(1)  "+options[i][0]);
                        System.out.println("(2)  "+options[i][1]);
                        System.out.println("(3)  "+options[i][2]);
                        System.out.println("(4)  "+options[i][3]);
                        System.out.println();
                        System.out.print("Enter the correct option  ");
                        int ch=sc.nextInt();
                        System.out.println();
                        if(i==answers.length-1)
                        {
                                break;
                        }
                        System.out.println("Enter your choice :");
                        System.out.println("press 1 to go to previous question");
                        System.out.println("press 2 to go to next question");
                        int op=sc.nextInt();



                        if(i>=1 && op==1)
                        {
                                i--;
                                if(points>0)
                                        points--;
                        }
                        else if(i<1 && op==1)
                        {
                                System.out.println("There is no previous question");
                                System.out.println("press 2 to go to the next question");
                                op=sc.nextInt();
                        }
                        points=validate(options,answers,ch,i);
                        if(op==2)
                        {
                                i++;
                        }
                        else if(i>=answers.length && op==2)
                        {
                                System.out.println("There is no next question");
                                break;
                        }


                }
                System.out.println("Points :  "+points);
        }

        int validate(String[][] options,String[] answers,int ans,int temp)
        {

                System.out.println("options selected : "+options[temp][ans-1]);
                System.out.println("Answer option  "+answers[temp]);
                        if(options[temp][ans-1].equals(answers[temp]))
                        {
                                points++;
                        }
                return points;
        }
}
