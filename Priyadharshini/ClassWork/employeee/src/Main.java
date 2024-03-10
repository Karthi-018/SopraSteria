import java.util.*;
import java.util.stream.Stream;
import java.util.function.Function;
public class Main {
    public static void main(String[] args) {
       ArrayList <Emp> li=new ArrayList<>();
        li.add(new Emp(10,"priya","hr",20000));
        li.add(new Emp(101,"pri","tech",10000));
        li.add(new Emp(102,"priyathama","ed",60000));
//        Stream <Emp>s1=li.stream();
//        Stream<Emp> s2 = s1.filter(i -> i.getSalary() < 50000);
//        Function <Emp,Emp> f=new Function<Emp,Emp>()
//        {
//            public Emp apply(Emp i) {
//               int incsalary=(int)(i.getSalary()+i.getSalary()*0.1);
//               i.setSalary(incsalary);
//               return i;
//            }
//
//        };
//        Stream<Emp>s3=s2.map(f);
//        Stream<Emp>s4=s3.sorted((e1,e2)->e1.getSalary()>e2.getSalary()?1:-1);
        Emp e1=li.stream().filter(e->(e.getName().equals("priya"))).findFirst().orElse(new Emp());
//        s5.forEach(i->System.out.println(i));
        System.out.println(e1);
    }
}