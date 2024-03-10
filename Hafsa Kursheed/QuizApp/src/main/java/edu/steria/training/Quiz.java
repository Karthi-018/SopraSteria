package edu.steria.training;

import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
public class Quiz
{
    Scanner sc = new Scanner(System.in);
    String[] ques = new String[10];
    String[] ans = new String[10];
    String[] subAns = new String[10];

    Quiz(String[] ques, String[] ans)
    {
        for(int i=0; i<5; i++)
        {
            this.ques[i] = ques[i];
            this.ans[i] = ans[i];
        }

    }

    public void fetchQues(int curr)
    {
        int ch;
        System.out.println(ques[curr]);
        if(subAns[curr]!=null)
        {
            System.out.println("Your answer: " + subAns[curr]);
        }
        else
        {
            System.out.print("Enter your choice: ");
            subAns[curr]= sc.next();
        }

        if(curr == 0)
        {
            System.out.println("1.Edit\t2.Next");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            if(ch==1)
            {
                editAns(curr);
            }
            else
            {
                fetchQues(curr+1);
            }
        }
        else if(curr==4)
        {
            System.out.println("1.Prev\t2.Edit\t3.Submit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            if(ch==1)
            {
                fetchQues(curr-1);
            }
            else if(ch==2)
            {
                editAns(curr);
            }
            else
            {
                findScore();
            }
        }
        else
        {
            System.out.println("1.Prev\t2.Edit\t3.Next");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            if(ch==1)
            {
                fetchQues(curr-1);
            }
            else if (ch==2)
            {
                editAns(curr);

            }
            else
            {
                fetchQues(curr+1);
            }

        }

    }

    public void findScore()
    {
        int result = 0;

        for(int i=0; i<5; i++)
        {
            if(subAns[i].equals(ans[i]))
            {
                result += 1;
            }
        }
        System.out.println("Your score: "+result+"/5");
    }


    public void editAns(int i)
    {
        System.out.println("Your answer: " +subAns[i]);
        System.out.print("Enter the answer: ");
        subAns[i] = sc.next();
        fetchQues(i);

    }


}
