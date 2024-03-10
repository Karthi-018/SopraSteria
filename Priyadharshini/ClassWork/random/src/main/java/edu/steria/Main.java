package edu.steria;
import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(2, 3, 4, 5, 6, 7, 7, 18, 9);
        Stream<Integer> s = li.stream();
//       s.forEach(i -> System.out.println(i));


        Predicate<Integer> p=new Predicate<Integer>()
        {
            public boolean test(Integer i)
            {
                return i%2==0;
            }
        };
        Stream s1=s.filter(p);

       Function <Integer,Integer> f=new Function<Integer,Integer>()
       {
           public Integer apply(Integer i) {
               return i * 2;
           }

       };
        Stream<Integer>s2=s1.map(f);
        int sum=s2.reduce(0,(c,e)->c+e);
        System.out.println(sum);

    }
}