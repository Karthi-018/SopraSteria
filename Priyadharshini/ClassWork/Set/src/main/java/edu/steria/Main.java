package edu.steria;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       List<Student> l=new ArrayList<>();
       l.add(new Student(1,"priya",100));
       l.add(new Student(2,"varun",50));

       Collections.sort(l);
        for(Student i:l)
        {
            System.out.println(i);
        }

    }
}