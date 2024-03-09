import java.util.Scanner;
class EcomSite
{
	static Scanner sc=new Scanner(System.in);
	static String products[]=new String[50];
        static int lastIndex = 0;
	String userName;
	String passwrd;

        public void login()
	{
		System.out.println("Welcome to EcomSite");
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("1.Admin");
		System.out.println("2.Customer");
		System.out.println("Enter Your Login Method");
                int choice=sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
			case 1:System.out.print("Enter Your UserName : ");
			       this.userName=sc.nextLine();
			       System.out.println();
			       System.out.print("Enter Your Password : ");
			       this.passwrd=sc.nextLine();
			       System.out.println();
		               if((this.userName=="Admin")&&(this.passwrd=="Reset@123"))
			       {
					admin();
			       }
			       else
			       {
					System.out.println("Please Try to login again...");
					login();
			       }
			       break;
	
			case 2:System.out.print("Enter Your UserName : ");
			       this.userName=sc.nextLine();
			       System.out.println();
			       System.out.print("Enter Your Password : ");
			       this.passwrd=sc.nextLine();		
		               System.out.println();			      
			       if((this.userName=="Customer")&&(this.passwrd=="Reset@123"))
			       {
					customer();
			       }
			       else
			       {
					System.out.println("Please Try to login again...");
					login();
			       }
			       break;
			default:System.out.println("Please Try to login again...");
				login();
		}
                                        	
				

	}
	public void admin()
	{
		System.out.println("Welcome Admin.Enter Your Purpose");
		System.out.println("1.Add Products");
		System.out.println("2.Edit Products");
		System.out.println("3.List Products");
		System.out.println("4.Delete Product");
		System.out.print("Enter your Choice : ");
		int ch=sc.nextInt();
                sc.nextLine();
		System.out.println();
		switch(ch)
		{
		case 1:addProduct();
		       break;
		case 2:editProduct();
		       break;
		case 3:listProduct();
		       break;
		case 4:deleteProduct();
		       break;
		default:System.out.println("Enter Valid choice");
			admin();
		}
	}
	public void customer()
	{
		System.out.println("Welcome Customer.Enter Your Purpose");
		System.out.println("1.Search Products");
		System.out.println("2.List Products");
		System.out.print("Enter your Choice : ");
		int ch=sc.nextInt();
		System.out.println();
		switch(ch)
		{
		case 1:searchProduct();
		       break;
		case 2:listProduct();
		       break;
		default:System.out.println("Enter Valid choice");
			customer();
		}
	}

   	public void addProduct() 
	{
       		 System.out.println("Enter product to add:");
        	 String product = sc.nextLine();
        	 products[lastIndex++] = product;
		 admin();
   	}
 
        public void deleteProduct() 
        {
             System.out.println("Enter product to remove:");
             String product = sc.nextLine();
             boolean flag = false;
             for (int i=0; i<lastIndex; i++) {
              if (products[i].equals(product)) {
                flag = true;
                while (i < lastIndex - 1) {
                    products[i] = products[i + 1];
                    i++;
                }
                lastIndex--;
            }
        }
            if (flag==false) {
            System.out.println("Product not found");
        }
	admin();
        }



	public void editProduct()
	{
       		System.out.println("Enter product to edit:");
        	String product = sc.nextLine();
        	boolean flag = false;
        	for (int i=0; i<lastIndex; i++)
		{
            	if (products[i].equals(product))
		{
                	System.out.println("Enter new product:");
               		String newProduct = sc.nextLine();
                	flag = true;
                	products[i] = newProduct;
           	}
                }
        	if (flag==false) 
		{
            		System.out.println("Product not found");
       		}
		admin();
   	}
 
    	public void listProduct()
	{
        	System.out.println("PRODUCTS:");
        	for (int i = 0; i < lastIndex; i++) 
		{
            		System.out.println(products[i]);
        	}
   	}
	
	public void searchProduct()
	{
       		System.out.println("Enter product:");
        	String product = sc.nextLine();
        	for (int i=0; i<lastIndex; i++)
		{
		if (products[i].equals(product))
		{
                	System.out.print("Product found!!  - ");
			System.out.println(product);
			customer();
		}
		}
	        System.out.println("Product found!!");
		customer();
		}


	public static void main(String args[])
	{
		EcomSite obj=new EcomSite();
		obj.login();
	}
}
		