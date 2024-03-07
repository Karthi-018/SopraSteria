package edu.steria;
import java.util.*;
public class Quiz  {
    Scanner sc = new Scanner(System.in);
    String optionarray[];
    public void setlength(int length) {
        optionarray = new String[length];
    }
    public int firstquestion(int k, String choice) {
        System.out.println("1.next\n2.edit");
        int opt = sc.nextInt();

        if (opt == 1) {
                optionarray[k] = choice;
                return k=k+1;
        }
        else {
            return k;
        }

    }

    public int lastquestion(int k, String choice,boolean n,String[]answerarray) {
        System.out.println("1.edit\n2.previous\n3.submit");
        int opt = sc.nextInt();
        int count=0;
        if (opt == 1)
        {
            optionarray[k] = choice;
        }
        else if (opt == 2) {
             k--;
        }
        else
        {
            optionarray[k] = choice;
           k++;
           int score=testanswer(answerarray,count);
           System.out.println("your score is: "+score);

        }
        return k;
    }

    public int otherquestion(int k,String choice)
    {
        System.out.println("1.edit\n2.previous\n3.next");
        int opt = sc.nextInt();
        if (opt == 1) {
            optionarray[k] = choice;
        }
        else if (opt == 2)
        {
            k--;
        }
        else
        {
            optionarray[k]=choice;
            k=k+1;

        }
        return k;
    }

    public int testanswer(String[]answerarray,int count) {
        for(int i=0;i< answerarray.length;i++)
        {
            if(optionarray[i].equals(answerarray[i]))
            {
                count++;
            }
        }
        return count;
    }

    }



