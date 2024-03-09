import java.util.Scanner;
class ECommerce
{
 public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);
 System.out.println("           Welcome to E-Commerce Website");
 int flag1=0;
 while(flag1!=1)
{
  Admin ad=new Admin();
 System.out.println("\n\n1.Admin login\n2.Customer login\n3.Exit\n");
 System.out.println("Enter your choice:");
 int ch=sc.nextInt();
 switch(ch)
{ 
 case 1:
 {
      System.out.print("\nEnter your USERNAME:");
      String user=sc.next();
      System.out.print("\nEnter your PASSWORD:");
      String pass=sc.next();
      if(ad.userName.equals(user)&&ad.password.equals(pass))
      {
           System.out.println("\nLogged In Successfully\n");
           int flag=0;
           while(flag==0)
           {
               System.out.println("\n1.Add Product\n2.Edit Product\n3.List Product\n4.Remove Product\n5.Exit");
               System.out.println("Enter your choice: ");
               int choice=sc.nextInt();
               switch(choice)
               {
                   case 1:
                       ad.addProduct();
                       break;
                   case 2:
                       ad.editProduct();
                       break;
                   case 3:
                       ad.listProduct();
                       break;
                   case 4:
                       ad.removeProduct();
                       break;
                   case 5:
                       flag=1;
                       break;
                }
           }
       }
       else
       { 
               System.out.println("\nInvalid Username or Password");
       }
       break;
  }
  case 2:
  {
        Admin.Customer cus=new Admin.Customer();
        int flag2=0;
        while(flag2!=1)
        {
        System.out.println("1.Sign Up\n2.Log In\n3.Exit");
        System.out.println("Enter your Choice:");
        int ch1=sc.nextInt();
        switch(ch1)
        {
        case 1:
        {
             cus.signUp();
        }
        case 2:
        {
     
             System.out.print("\nEnter your USERNAME:");
             String cuser=sc.next();
             System.out.print("\nEnter your PASSWORD:");
             String cpass=sc.next();
             if(cus.cuserName.equals(cuser)&&cus.cpassword.equals(cpass))
             {
                    System.out.println("\nLogged In Successfully\n");
                    int flag=0;
                    while(flag==0)
                    {
                           System.out.println("\n1.List Product\n2.Search Product\n3.Exit\n\n");
                           System.out.println("Enter your choice:");
                           int choice=sc.nextInt();
                           switch(choice)
                           {
                                 case 1:
                                     ad.listProduct();
                                     break;
                                 case 2:
                                     cus.searchProduct();
                                     break;
                                 case 3:
                                     flag=1;
                                     break;
                            }
                    }
              }
          }
          case 3:
          {  
             flag2=1;
             break;
          }
          default:
          { 
                System.out.println("\nInvalid username or Password\n");
                break;
          }
      }
     }
  }
  case 3:
  {
      flag1=1;
      break;
  }
  default:
  {
          System.out.println("\nInvalid Choice!!\n");
          break;
  }
 }
}
}
}

//*****ADMIN CLASS*****

class Admin
{
 Scanner sc=new Scanner(System.in);
 String userName="Admin",password="reset@123";
 static String product[]=new String[20];

 static class Customer
 {  
   static String cuserName;
   static String cpassword;
   Scanner sc=new Scanner(System.in);
     
   void signUp()
   {
      System.out.print("Set your username: ");
      cuserName =sc.next();
      System.out.print("Set your Password: ");
      cpassword =sc.next();
   }
   void searchProduct()
   {
       if(product.length==0)
       {
           System.out.println("\nNo Items in the List\n");

       }
       else
       {
           System.out.println("\nEnter the product to search:");
           String search=sc.next();
           for(String i:product)
           {
              if(i!=null)
              {
                 if(i.equals(search))
                 {
                      System.out.println("\nProduct is Available\n");
                      break;
                 }
                 else
                 {
                      System.out.println("\nProduct is not Available\n");
                 }
              }
           }
       }
   }
     
 
// ***ADD METHOD***

void addProduct()
{
 System.out.println("\nHow many product do you want to add? ");
 int ch=sc.nextInt();
 int cnt=0,index=0;
 for(int i=0;i<product.length;i++)
{
 if(product[i]==null)
 {
   cnt=product.length-i;
   index=i;
   break;
 }
 
}
if(ch<=cnt)
{
  for(int i=index;i<(index+ch);i++)
  {
  System.out.println("\nEnter the product to add:");
  product[i]=sc.next();
  }
}
else
{
  System.out.println("\nYou can add only "+cnt+" product\n");
}
}

//***EDIT METHOD***

void editProduct()
{
  System.out.println("\nEnter the product to edit:");
  String pro=sc.next();
  int flag=0;
  for(int i=0;product[i]!=null;i++)
  {
    if(product[i].equals(pro))
    {
      System.out.println("\nEnter the new product: ");
      product[i]=sc.next();
      flag=1;
    }
  }
  if(flag==0)
    {
      System.out.println("Product not found!\n");
    }
}


// ***LIST METHOD***

void listProduct()
{
    if(product.length==0)
    { 
      System.out.println("\nNo products in the List\n");
    }
  for(int i=0;i<product.length;i++)
  { 
    if(product[i]==null)
	break;
    System.out.println("\n*"+product[i]+"*\n");
  }
}


//***REMOVE METHOD*** 

void removeProduct()
{
  System.out.println("\nEnter the product to remove from the list: ");
  String pro=sc.next();
  int index=0,flag=0;
  for(int i=0;product[i]!=null;i++)
  {
    if(product[i].equals(pro))
    {
        flag=1;
        for(int j=i;j< product.length-1;j++)
        {
            product[j]=product[j+1];
            index=j;
        }
    }
  }
  if(flag==1) {

      product[index + 1] = null;
      for (int i = 0; product[i] != null; i++) {
          System.out.println("\n*" + product[i] + "*\n");
      }
  }
  else {
      System.out.println("Product not found! !");
  }
}
}
  


 


    

 
 
 




