package edu.steria.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Empl> empList=new ArrayList<>();
        empList.add(new Empl(706645,"Tharun","plm",49999));
        empList.add(new Empl(706646,"Saswata","plm",54000));
        empList.add(new Empl(706649,"Chandu","plm",33900));
        empList.add(new Empl(706642,"Nivas","plm",51000));
        empList.add(new Empl(706643,"Harsha","plm",45000));
       // System.out.println(empList);
//        Stream<Empl> s1= empList.stream().filter(i->i.getSalary()<50000);
//        s1.forEach(System.out::println);
        Stream<Empl>  s= empList.stream().filter(i->i.getSalary()<50000).map(i->{i.setSalary(i.getSalary()+(i.getSalary()*0.1)); return i;});
//      Collections.sort(s.toList(),);
//        #to sort the stream;
//        s.sorted((n1,n2)->n1.getSalary()>n2.getSalary()?1:-1).forEach(System.out::println);
//        System.out.println();
        Collections.sort(empList,(n1,n2)->n1.getSalary()<n2.getSalary()?1:-1);
        empList.forEach(System.out::println);
        System.out.println();

        System.out.println(empList.stream().filter(e->e.getEName().equals("Tharun")).findAny().orElse(new Empl()));
    }
}