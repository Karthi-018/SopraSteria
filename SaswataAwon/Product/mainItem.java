package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainItem {
    public static void main(String[] args) {
        ItemDAO it=new ItemDAO();
        Scanner s=new Scanner(System.in);
        List<Item> li=new ArrayList<>();

        while(true){
            boolean exitloop=false;
            System.out.println("-----------------------------------------------------");
            System.out.print("Enter 1 to add items or Enter 2 to search : ");
            int choice=s.nextInt();
            System.out.println("-----------------------------------------------------");
            switch (choice){
                case 1:
                    while(!exitloop){
                        System.out.println("-----------------------------------------------------");
                        System.out.print("1 to add item and 2 to exit : ");
                        int ch=s.nextInt();
                        switch (ch){
                            case 1:
                                System.out.print("Enter the item details (Format : name,price,type): ");
                                String details=s.next();
                                String[] arr=details.split(",",0);
                                double d=Double.parseDouble(arr[1]);

                                li.add(new Item(arr[0],d,arr[2]));
                                System.out.println("-----------------------------------------------------");

                                break;
                            case 2:
                                it.bulkCopy(li);
                                exitloop=true;
                                break;
                            default:
                                System.out.println("Invalid choice !!!!");
                                System.out.println("-----------------------------------------------------");
                                break;
                        }
                    }
                case 2:
                    while(!exitloop) {
                        System.out.println("1 to search item by type");
                        System.out.println("2 to search item by price");
                        System.out.println("3 to exit");
                        System.out.print("Enter choice : ");
                        int dec = s.nextInt();
                        System.out.println("-----------------------------------------------------");

                        switch (dec){
                            case 1:
                                System.out.println("To search by type, ");
                                System.out.print("  Enter the type : ");
                                String find=s.next();
                                List<Item> l1=it.findItem(find);

                                if(l1.isEmpty())
                                {
                                    System.out.println("no such item is present");
                                    System.out.println("-----------------------------------------------------");
                                }
                                else
                                {
                                    for(int i=0;i<l1.size();i++)
                                    {
                                         System.out.format("%-20s %-5s %s\n","name","price","type");
                                         System.out.println("---------------------------------");


                                    }

                                }
                                break;
                            case 2:
                                System.out.println("To search by price, ");
                                System.out.print("  Enter the price :");
                                double pr=s.nextDouble();
                                List<Item> l2=it.findItem(pr);
                                if(l2.isEmpty())
                                {
                                    System.out.println("no such item is present");
                                    System.out.println("-----------------------------------------------------");
                                }
                                else
                                {
                                     for(int i=0;i<l2.size();i++)
                                    {
                                        System.out.format("%-20s %-5s %s\n","i.getName()","i.getPrice","i.getType");
                                        System.out.println("---------------------------------");

                                    }
                                }
                                break;
                            case 3:
                                exitloop=true;
                                break;
                            default:
                                System.out.println("Invalid choice !!!!");
                                System.out.println("-----------------------------------------------------");
                        }
                    }

            }
        }
    }
}
