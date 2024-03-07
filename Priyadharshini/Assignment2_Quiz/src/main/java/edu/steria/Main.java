package edu.steria;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz q=new Quiz();
        System.out.println("Enter your name..");
        String username = sc.next();
        System.out.println("Enter your password...");
        String password = sc.next();
        if(password.equals("Reset@123")) {
            System.out.println("Enter the option...");
            System.out.println("1->Start\n2->Stop");
            int option = sc.nextInt();
            int k = 0;
            boolean n = true;
            String questionarray[] = {"1.Which is used to find and fix bugs in the java program?", "2.Which package contains random class?", "3.Which of the following is not a feauture of java?"};
            String choicearray[] = {"a)JVM,b)JRE,c)JDK,d)JDB", "a)java.util.package,b)java.lang.package,c)java.awt.package,d)java.io.package", "a)Dynamic,b)Architecture Neutral,c)use of pointers,d)OOPS"};
            String answerarray[] = {"d", "a", "c"};
            int length = questionarray.length;
            q.setlength(length);
            if (option == 1) {
                while (n) {
                    System.out.println(questionarray[k]);
                    System.out.println(choicearray[k]);
                    String choice = sc.next();
                    if (k == 0) {
                        k = q.firstquestion(k, choice);
                    } else if (k == (questionarray.length) - 1) {
                        k = q.lastquestion(k, choice, n, answerarray);
                        if (k == questionarray.length) {
                            n = false;
                            break;
                        }
                    } else {
                        k = q.otherquestion(k, choice);
                    }

                }

            } else {
                System.out.println("**************end******************");
            }
        }
        else {
            System.out.println("Your password doesn't match ...try again");
        }

    }

}