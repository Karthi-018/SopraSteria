package edu.steria;
import java.util.*;
    public  class Customer extends Admin{

        void listproduct() {
            super.listproduct();
        }
        void searchproduct(String search)
        {
               if(search.equals(stringArray)) {
                   System.out.println("The product you searched for is found");
                   System.out.println(stringArray);
               }
               else {
                   System.out.println("the product is not found");
               }
          }
    

}


