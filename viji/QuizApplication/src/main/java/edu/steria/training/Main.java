package edu.steria.training;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc=new Scanner(System.in);
    static String ques[] = {"1. Who invented Java Programming?\na) Guido van Rossum\n b) James Gosling\n c) Dennis Ritchie\n d) Bjarne Stroustrup" ,
            "2. Which component is used to compile, debug and execute the java programs?\na) JRE\n" + "b) JIT\n" +"c) JDK\n" + "d) JVM",
            "3. Which one of the following is not a Java feature?\n"+"a) Object-oriented\n" + "b) Use of pointers\n" + "c) Portable\n" + "d) Dynamic and Extensible",
            "4. Which of these cannot be used for a variable name in Java?\n"+"a) identifier & keyword\n" + "b) identifier\n" + "c) keyword\n" + "d) none of the mentioned",
            "5. What is the extension of java code files?\n"+"a) .js\n" + "b) .txt\n" + "c) .class\n" + "d) .java"};
    static String ans[] = {"b","c","b","c","d"};
    static String userAns[] = new String[5];
    static int flag[]=new int[5];
    static int score=0;
    public void displayQuestions(int i)
    {
        System.out.println(ques[i]);
    }
    public void getAnswer(int i)
    {
        System.out.println("Enter your answer: ");
        userAns[i]=sc.next();
        flag[i]=1;
    }
    public void choices(int i)
    {
        if(i==0)
        {
            System.out.println("Enter 0 to visit next question or 1 to edit answers: ");
        }
        else if(i== (ques.length-1))
        {
            System.out.println("Enter 2 to visit previous question or 3 to submit answers: ");
        }
        else {
            System.out.println("Enter 2 to visit previous question or 0 to visit next question or 1 to edit answers: ");
        }

    }
    public static void score() {
        for (int i = 0; i < ans.length; i++) {
            if (ans[i].equals(userAns[i])) {
                score++;
            }
        }

    }

    public static void main(String[] args) {
        Main m=new Main();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("********Welcome to Quiz*********");
    System.out.println("Enter 1 to continue or 0 to exit");
    int ch=sc.nextInt();
    if(ch==1)
    {
        for(int i=0;i< ques.length;) {
            m.displayQuestions(i);
            if(flag[i]==1)
            {
                System.out.println(userAns[i]);
            }
            if(flag[i]==0) {
                m.getAnswer(i);
            }
            m.choices(i);
            switch (sc.nextInt()) {
                case 0:
                    i++;
                    break;
                case 2:
                    i--;
                    break;
                case 1:
                    flag[i]=0;
                    break;
                case 3:
                    Main.score();
                    i++;
                    break;
            }
        }
        }
        else if(ch==0)
    {
        System.out.println("fuyifgioisop");
    }

        else {
            System.out.println("Invalid choice");
        }
        System.out.println("Your Score is:"+score);
        System.out.println("Thank you for taking the Quiz");
    }
}