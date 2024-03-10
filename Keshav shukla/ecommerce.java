import java.util.*;
import java.util.Arrays; 
public class onlineapp{
  static Scanner sc=new Scanner(System.in);
  static String[] product=new String[20];  
   static int flag=4 ;

  
  public static void main(String[] args){
    System.out.println("welcome to shuklakart");
    product[0]="samsung";
    product[1]="apple";
    product[2]="nokia";
    product[3]="oneplus";	
    
    while(true){
    System.out.println("Hello!you want to login as admin or customer");
    String login=sc.nextLine();
    if(login.equals("admin")){
             admin();
      }
    else if(login.equals("customer")){ 
         customer();
         break;
     }
}               
  }
    static void admin(){
       
        System.out.println("enter the username");
        String username=sc.nextLine();
        System.out.println("enter the password");
        String password=sc.nextLine();
        
        if(username.equals("admin") && password.equals("Reset@123")){
        while(true){
                System.out.println("enter 1 to add product");
		System.out.println("enter 2 to edit product");
		System.out.println("enter 3 to list of product");
		System.out.println("enter 4 to delete product");
                System.out.println("enetr 5 to exit.");
                int ans=sc.nextInt();
               
                if(ans==1){
			System.out.println("enter the productname");
			product[flag]=sc.next();
                        flag++;
                        }
                if(ans==2){
			System.out.println("enter the product to edit");
                        String editproduct=sc.next();
			for(int i=0;i<=flag;i++){
                               if(editproduct.equals(product[i])){
                               System.out.println("enter the new product in place of edit");
				String newproduct=sc.next();
				product[i]=newproduct;			
                              }        
                        }	
                }
                if(ans==3){
			System.out.println("The list of product are");
                        for(int i=0;i<flag;i++){
				System.out.println(product[i]);
                        }
                     }
                if(ans==4){
                      System.out.println("enter the item to be deleted");
		      String delitem=sc.next();
                      int k=0;	
                      for(int i=0;i<=flag;i++){
                             if(product[i].equals(delitem)){
                                  k=i;
                                  flag--;
				  
                              }
                       }
                       for(int l=k;l<=flag-1;l++){
                            product[l]=product[l+1];
                          }
                     
			
                       }
                  if(ans==5){
                         break;
                  } 
               

       }
}
   else{
        System.out.println("enter the correct username and password");
      }
}
public static void customer(){
        System.out.println("enter the loginid");
        String username=sc.nextLine();
        System.out.println("enter the password");
        String password=sc.nextLine();
        if(username.equals("login") && password.equals("Keshav@123")){
                while(true){
                System.out.println("enter 1 for the list of items");
		System.out.println("enter 2 for the search the items");
                System.out.println("enter 3 for exit");
                 
                 int ans=sc.nextInt();
                 if(ans==1){
			System.out.println("the list items are");
			for(int i=0;i<product.length;i++){
				System.out.println(product[i]);
                        }
                 }
                 if(ans==2){
                           System.out.println("enter the item to be search");
                           String item=sc.next();
                           for(int i=0;i<product.length;i++){
			     if(product[i].equals(item)){
                               System.out.println(item + "is present in the list");
				break;
                             }
			else if(product[i].equals("null")){
                                 System.out.println(item + "is not present in the list");
				 break;	
					}
                              else{
					continue;
                                   }
                             
                             
                             }
                        }
                if(ans==3){
                          break;
                        } 
                else{
                   System.out.println("enter the correct loginid and password");
                   }
}
             }
              
        }
}
    		
                   

 
