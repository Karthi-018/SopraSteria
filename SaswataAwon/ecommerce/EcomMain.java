package edu.steria.branch.ecommerce;

import java.util.Scanner;

public class EcomMain {
    public static void main(String[] args) {
        Scanner p=new Scanner(System.in);
        Login log=new Login();
        Ecommerce ecom=new Ecommerce();
        EcomCust cust=new EcomCust();

          while(true){
              int dec=log.check();
              boolean exitloop=false;
              if(dec==1) {
                  while (!exitloop) {
                      System.out.println("1) 1 for adding \n2) 2 for editing \n3) 3 for deleting \n4) 4 for see the list \n5) 5 to log out \n6) 6 to exit");
                      System.out.print("Enter choice : ");
                      int choice = p.nextInt();
                      System.out.println("----------------------------------------");
                      switch (choice) {
                          case 1:
                              ecom.addItem();
                              break;
                          case 2:
                              ecom.edit();
                              break;
                          case 3:
                              ecom.delete();
                              break;
                          case 4:
                              ecom.list();
                              break;
                          case 5:
                              exitloop = true;
                              break;
                          case 6:
                              System.exit(0);
                          default:
                              System.out.println("Invalid Input");
                              break;
                      }
                  }
              }
              else if(dec==2){
                  while (!exitloop) {
                      System.out.println("1) 1 to see the list \n2) 2 for searching \n3) 3 for buying \n4) 4 to log out \n5) 5 to exit");
                      System.out.print("Enter choice : ");
                      int choice = p.nextInt();
                      System.out.println("----------------------------------------");
                      switch (choice) {
                          case 1:
                              cust.show();
                              break;
                          case 2:
                              cust.search();
                              break;
                          case 3:
                              cust.buy();
                              break;
                          case 4:
                              exitloop = true;
                              break;
                          case 5:
                              System.exit(0);
                          default:
                              System.out.println("Invalid Input");
                              break;
                      }
                  }
              }
          }







    }
}
