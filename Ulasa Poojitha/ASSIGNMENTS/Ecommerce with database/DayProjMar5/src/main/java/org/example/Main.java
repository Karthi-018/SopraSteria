package org.example;

import java.sql.*;
import java.util.Scanner;


public class Main
{
 // static Connection conn=null;

 public static void main(String[] args)throws SQLException {
     Ecomm ec = new Ecomm();
     Scanner sc = new Scanner(System.in);
     System.out.println("Admin or Customer");
     String iam = sc.next();
         if (iam.equals("Admin")) {
         System.out.println("Enter 1 : add \n Enter 2 : show \n Enter 3 : update \n Enter 4 : delete \n Enter 5 : search \n Enter 6 : Exit");
         while (true) {
             boolean flag = false;
             System.out.println("Enter ur choice:");
             int choice = sc.nextInt();
             switch (choice) {
                 case 1:
                     ec.add();
                     break;
                 case 2:
                     ec.show();
                     break;
                 case 3:
                     ec.update();
                     break;
                 case 4:
                     ec.delete();
                     break;
                 case 5:
                     ec.search();
                     break;
                 case 6:
                     flag = true;
                     break;
             }
         }

         }
         if (iam.equals("Customer"))
         {
             Scanner s = new Scanner(System.in);
             System.out.println("Login or Register");
             String sig = s.next();
             if (sig.equals("Register"))
             {
                 ec.addcus();
                 System.out.println("Enter 1 : show \n Enter 2: search \n Enter 3 : buy \n Enter 4: Exit");
                 while (true) {
                     boolean flag = false;
                     System.out.println("Enter ur choice:");
                     int choice = sc.nextInt();
                     switch (choice) {
                         case 1:
                             ec.show();
                             break;
                         case 2:
                             ec.search();
                             break;
                         case 3:
                             ec.buy();
                             break;

                         case 4:
                             flag = true;
                             break;
                     }
                     if (flag) {
                         break;
                     }

                 }

             }
             if (sig.equals("Login")) {
                 System.out.println("Enter username: ");
                 String cusname = s.next();
                 System.out.println("Enter  password: ");
                 String cuspwd = s.next();
                 if (ec.cuslog(cusname, cuspwd)) {
                     System.out.println("Enter 1 : show \n Enter 2: search \n Enter 3 : buy \n Enter 4: Exit");
                     while (true) {
                         boolean flag = false;
                         System.out.println("Enter ur choice:");
                         int choice = sc.nextInt();
                         switch (choice) {
                             case 1:
                                 ec.show();
                                 break;
                             case 2:
                                 ec.search();
                                 break;
                             case 3:
                                 ec.buy();
                                 break;

                             case 4:
                                 flag = true;
                                 break;
                         }
                         if (flag) {
                             break;
                         }

                     }
                 }

             }


         }
     }

 }
