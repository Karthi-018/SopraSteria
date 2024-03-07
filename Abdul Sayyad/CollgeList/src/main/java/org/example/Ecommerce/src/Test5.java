import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Demo implements Runnable{
    int count = 0;

    @Override
    public synchronized void run() {
        for(int i=0;i<=10000;i++) count++;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Demo d = new Demo();
        Thread t1= new Thread(d);
        Thread t2= new Thread(d);
        //forEach
        Consumer<Employee> con = new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {

            }

        };
        //map
        Function<Employee,Employee> emp = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }

        };
        //filter
        Predicate<Employee> pre = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return false;
            }
        };

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(d.count);
//        ArrayList<Employee> empa  = new ArrayList<>();
//        empa.add(new Employee(12,"ddd","it",5000));
//        empa.add(new Employee(123,"dhdh","it",2000));
//        empa.add(new Employee(1,"daha","it",5000));
//        empa.add(new Employee(144,"ysgs","it",10000));
//        Employee e1  = empa.stream().filter(e->(e.geteName().equals("ddd"))).findFirst().orElse(new Employee("Not found"));
//        System.out.println(e1);
//        Stream<Employee> s = empa.stream();
//
//        Stream<Employee> s1 = s.filter((e)->e.getSalary()<50000);
//        Stream<Employee> s3 = s1.map((e)->{e.setSalary(e.getSalary()*0.1+e.getSalary()); return e;});
//        Stream<Employee> s4 = s3.sorted((e1,e2)->e1.getSalary()>e2.getSalary()?1:-1);
//        System.out.println("after increase");
//        s4.forEach((e)-> System.out.println(e.getSalary()));
    }
}

