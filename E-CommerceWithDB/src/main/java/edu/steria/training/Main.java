package edu.steria.training;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("\n            Welcome to Ecommerce website\n");
        User user=new User();
        while(true)
        {
            System.out.println("********** HOME PAGE **********\n");
            System.out.println("1.Admin \n2.Customer\n3.Exit");
            int ch=sc.nextInt();
            int n=0;
            while(ch!=3&&n==0)
            {
                System.out.println("\n1.Log in\n2.Sign Up\n3.Exit\nEnter your choice:");
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
                        n=1;
                        break;
                    default:
                        System.out.println("Invalid choice!!");
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