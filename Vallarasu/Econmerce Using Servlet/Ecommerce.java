import java.util.*;
class ecommerce{

    int adminLogin()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the User Name:");
        if(in.nextLine().equals("Vallarasu"))
        {
            System.out.println("Enter the Password:");
            if(in.nextLine().equals("Marvel@123"))
                return 1;
            else
            {
                System.out.println("\nInvalid Credentials\n");
                return 0;
            }
        }
        else
        {
            System.out.println("\nInvalid Credentials\n");
            return 0;
        }
                
    }
    int customerLogin()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the User Name:");
        if(in.nextLine().equals("Vallarasu"))
        {
            System.out.println("Enter the Password:");
            if(in.nextLine().equals("Marvel@123"))
                return 1;
            else
            {
                System.out.println("\nInvalid Credentials\n");
                return 0;
            }
        }
        else
        {
            System.out.println("\nInvalid Credentials\n");
            return 0;
        }
    }
    public static void main(String args[])
    {
        ecommerce e=new ecommerce();
        Scanner in=new Scanner(System.in);
        Set<String> list=new TreeSet<String>();
        int n=1;
        while(n!=0)
        {
            if(n==1)
            {
                System.out.println("Enter the User Type:");
                System.out.println("1.Admin");
                System.out.println("2.Customer");
                System.out.println("3.Exit\n");
                switch(in.nextInt())
                {
                    case 1:
                        if(e.adminLogin()==1)
                        n=2;
                        break;
                    case 2:
                        if(e.customerLogin()==1)
                        n=3;  
                        break;  
                    case 3:
                        n=0;
                        break;
                }
            }
            if(n==2)
            {
                System.out.println("\nAdminHomePage");
                System.out.println("1.Add Product");
                System.out.println("2.Edit Product");
                System.out.println("3.List Product");
                System.out.println("4.Delete Product");
                System.out.println("5.Exit");
                switch(in.nextInt())
                {
                    case 1:
                        System.out.println("Enter the Mobile Name: ");
                        list.add(in.next());
                        System.out.println("Successfully Added...");
                        break;
                    case 2:
                        System.out.println("\n"+list);
                        System.out.println("Choose the Product to Edit Product Name");
                        list.remove(in.next());
                        System.out.println("Enter the Product Name to Update");
                        list.add(in.next());
                        System.out.println("Successfully Updated...");                        
                        break;
                    case 3:
                        System.out.println("\nList of Products:");
                        Iterator<String>it=list.iterator();
                        while(it.hasNext())
                            System.out.println(it.next());
                        break;
                    case 4:
                        System.out.println("\n"+list);
                        System.out.println("Enter the Product Name to delete");
                        list.remove(in.next());
                        System.out.println("Successfully Deleted...");
                        break;
                    case 5:
                        n=1;
                        break;
                }
            }
            if(n==3)
            {
                System.out.println("\nCustomerHomePage");
                System.out.println("1.List Product");
                System.out.println("2.Search Product");
                System.out.println("3.Exit");
                switch(in.nextInt())
                {
                    case 1:
                        System.out.println("\nList of Products:");
                        Iterator<String>it=list.iterator();
                        while(it.hasNext())
                            System.out.println(it.next());
                        break;
                    case 2:
                        System.out.println("Enter the Product Name to Search");
                        if(list.contains(in.next()))
                            System.out.println("The Product is Available");
                        else 
                            System.out.println("The Product is Not Available");
                        break;
                    case 3:
                        System.out.println("Thanks for Using Ecommerce Website...");
                        n=1;
                        break;
                }
            }
        }
    }
}