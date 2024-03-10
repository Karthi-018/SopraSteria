package edu.steria.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //static List<String> list=new ArrayList<>();
    static List<Item> item_list=new ArrayList<>();

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner sc=new Scanner(System.in);
        ItemDAO item=new ItemDAO();

        System.out.println("          Food Aggregator");
        while(true)
        {
            System.out.println("\nEnter your choice:\n1.add items\n2.serach item by type\n3.search item by price\n4.Exit");
            switch (sc.nextInt())
            {
                case 1:
                    System.out.println("Enter no of items to add:");
                    int ch=sc.nextInt();
                    for(int i=0;i<ch;i++)
                    {
                        System.out.println("Enter item name,item price and type: ");
                        String s=sc.next();
                        String[] st=s.split(",");
                        List<String> list= Arrays.asList(st);
                        Item it=new Item(list.get(0),Double.parseDouble(list.get(1)), list.get(2));
                        item_list.add(it);
                    }
                    item.bulkCopy(item_list);
                    System.out.println("Added successfully!!!");
                    break;
                case 2:
                    System.out.println("Enter the type of item to serach:");
                    item.findItem(sc.next());
                    break;
                case 3:
                    System.out.println("Enter the price of the item to serach:");
                    item.findItem1(sc.nextDouble());
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}