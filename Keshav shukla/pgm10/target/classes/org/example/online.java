import java.util.*;
public class onlineapp{
  Scanner sc=new Scanner(System.in);
    static int flag=0;
  public static void main(string[] args){
    System.out.println("welcome to shuklakart");
    System.out.println("please you want to login as admin or customer");
    String login=sc.nextLine();
    if(login.equals("admin")){
             admin(flag);
      }             
  }
    static void admin(int flag){
        while(true){
        System.out.println("enter the username");
        String username=sc.nextLine();
        System.out.println("enter the password");
        String password=sc.nextLine();
        if(username.equals("admin") && password.equals("Reset@123")){
                System.out.println("enter 1 to add product");
		System.out.println("enter 2 to edit product");
		System.out.println("enter 3 to list of product");
		System.out.println("enter 4 to delete product");
                System.out.println("enetr 5 to exit.");
                int ans=sc.nextInt();
                String[] product=new String[30];
                if(ans==1){
			System.out.println("enter the productname");
			product[flag]=sc.nextLine();
                }
                if(ans==2){
			System.out.println("enter the product to edit");
                        String editproduct=sc.nextLine();
			for(int i=0;i<=flag;i++){
                               if(editproduct.equals(product[i])){
                               System.out.println("enter the new product in place of edit");
				String newproduct=sc.nextLine();
				product[i]=newproduct;			
                              }        
                        }	
                }
                if(ans==3){
			System.out.println("The list of product are");
                        for(int i=0;i<=flag;i++){
				System.out.println(Arrays.toString(product[i]));
                        }
                     }
                if(ans==4){
                      System.out.println("enter the item to be deleted");
		      String delitem=sc.nextLine();
                      int k=0;	
                      for(int i=0;i<=flag;i++){
                             if(product[i].equals(delitem)){
                                  k=i;
				  
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
}
}
    		
                   

 
