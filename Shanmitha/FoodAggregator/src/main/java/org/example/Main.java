package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        ItemDAO item = new ItemDAO();

        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your choice:\n1.Add Item\n2.Bulk Copy\n3.Find Item type\n4.Find Item with Price\n5.Exit");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter item details as (product name, price, type):");
                    String itemString = scan.nextLine();
                    item.addItem(itemString);
                    break;

                case 2:
                    ArrayList<String> list = new ArrayList<String>();
                    System.out.println("Enter the number of items to add:");
                    int n = scan.nextInt();
                    scan.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Enter Item "+(i+1)+":");
                        String element = scan.nextLine();
                        list.add(element);
                    }
                    item.bulkCopy(list);
                    break;

                case 3:
                    System.out.println("Enter the type you want to select");
                    String type = scan.next();
                    item.findItem(type);
                    break;

                case 4:
                    System.out.println("Enter the price you want to select");
                    double price = scan.nextDouble();
                    item.findItem(price);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}