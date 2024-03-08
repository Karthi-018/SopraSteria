import java.util.*;

public class Main {

    static String item[]=new String[100];
    static int index=4;

    //take int input
    public static int takeIntInput() {
        Scanner sc=new Scanner(System.in);
        int input= sc.nextInt();
        return input;
    }
    //take String Input
    public static String takeStringInput() {
        Scanner sc=new Scanner(System.in);
        String input= sc.nextLine();
        return input;
    }
    //print login
    public static void welcome() {
        System.out.println("Welcome to Just_By\npress 1 for Admin Log in\npress 2 for User Login");
    }
    //login page
    public static void login() {
        welcome();
        int input=takeIntInput();
        //check credential
        if(input==1)
        {
            System.out.println("Enter id ");
            String id=takeStringInput();
            System.out.println("Enter Password");
            String pass=takeStringInput();
            if(id.equals("admin") && pass.equals("admin@123")) {
                adminpage();
            }
            else {
                System.out.println("Invalid User Id");
                login();
            }
        }
        else if(input==2) {
            System.out.println("Enter id ");
            String id=takeStringInput();
            System.out.println("Enter Password");
            String pass=takeStringInput();
            userpage();
        }

    }

    //admin methods
    //load item
    public static void load() {
        item[0]="Samsung";
        item[1]="iPhone";
        item[2]="OnePlus";
        item[3]="Nothing";
    }
    //list  item
    public static void listAll() {
        for(int i=0;i<index ;i++) {
            System.out.println((i+1)+". "+item[i]);
        }
        adminpage();
    }
    //add item
    public static void addItem() {
        System.out.println("Enter Item Name :");
        String product=takeStringInput();
        item[index]=product;
        System.out.println("Product added Successfully");
        index++;
        listAll();
        adminpage();
    }
    //remove item
    public static void remove() {
        System.out.println("enter the Number you want to delete");
        int num=takeIntInput();
        for(int i=num-1;i<index-1;i++) {
            item[i]=item[i+1];
        }
        index--;
        listAll();
        adminpage();
    }
    //update item
    public static void update() {
        System.out.println("enter the Number you want to update");
        int num=takeIntInput();
        System.out.println("Enter the product name");
        String updated=takeStringInput();
        if(num > index) {
            System.out.println("is your brain not braining!!!");
            update();
        }
        else {
            item[num-1]=updated;
            System.out.println("Updated Successfully");
            listAll();
            adminpage();
        }
    }
    //admin page
    public static void adminpage() {
        //System.out.println("inside admin page");
        System.out.println("press 1 for List All Item\npress 2 for add product\npress 3 for update product\npress 4 for remove a product\npress 0 for Log Out ");
        int input =takeIntInput();
        if(input==1)
            listAll();
        else if(input==2)
            addItem();
        else if(input==3)
            update();
        else if(input==4)
            remove();
        else if(input==0)
            login();
        else {
            System.out.println("you need some sleep");
            adminpage();
        }
    }
    //user method
    //list all
    public static void listAlluser() {
        for(int i=0;i<index ;i++) {
            System.out.println((i+1)+". "+item[i]);
        }
        userpage();
    }
    //search
    public static void search() {
        System.out.println("enter the product you want to search :");
        String product=takeStringInput();
        for(int i=0;i<index;i++) {
            if(product.equals(item[i])) {
                System.out.println("product "+product+" found  " + i+" position.");
                userpage();
            }
        }
        System.out.println("Sorry! we are out of stuck.");
        userpage();
    }
    //user page
    public static void userpage() {
        //System.out.println("inside user page");
        System.out.println("press 1 for List All item\npress 2 for search an item\npress 0 for Log Out");
        int input=takeIntInput();
        if(input==1)
            listAlluser();
        else if(input==2)
            search();
        else if(input==0)
            login();
        else {
            System.out.println("you need some sleep");
            userpage();
        }

    }

    public static void main(String[] args) {
        load();
        login();

    }

}
