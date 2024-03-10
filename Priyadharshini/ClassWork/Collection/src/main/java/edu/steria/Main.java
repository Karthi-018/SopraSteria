package edu.steria;

import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List list = new ArrayList();
        list.add(8);
        list.add(5);
        list.add("2");
        list.add(10);
        list.add(0);
        list.add(8);
        Iterator i = list.iterator();
        System.out.println(list);
        list.set(2,50);
        System.out.println(list);
//        while(i.hasNext())
//        {
//
//        }



    }
}