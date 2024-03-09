package edu.steria.train;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("\n****************Welcome to Ecommerce*************\n");
        User user=new User();
        while(true)
        {
            System.out.println("********** HOME PAGE **********\n");
            System.out.println("1.Admin \n2.Customer\n3.Exit");
            int ch=sc.nextInt();
            int flag=0;
            while(ch<3&&flag==0)
            {
                System.out.println("\n1.log in\n2.sign up\n3.exit\nEnter your choice:");
                switch(sc.nextInt())
                {
                    case 1:
                        if(ch==1) {
                            user.logIn("admin");
                        }
                        else {
                            user.logIn("customer");
                        }
                        break;
                    case 2:
                        if(ch==1) {
                            user.signUp("admin");
                        }
                        else {
                            user.signUp("customer");
                        }
                        break;
                    case 3:
                        flag=1;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            if(ch==3)
            {
                System.exit(0);
            }
        }
    }
}