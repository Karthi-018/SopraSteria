import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<Integer> list  = new ArrayList<Integer>();
        for(int i = 0;i<5;i++) list.add(i+1);
        Predicate<Integer> filt = new Predicate<>(){
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };
        Function<Integer,Integer> ma = new Function() {
            @Override
            public Integer apply(Object o) {
                return 2*(int) o;
            }
        };
      //for(int i = 0;i<5;i++) list.add(new Random().nextInt(100));
        Stream<Integer> s = list.stream();
        Stream<Integer> s1 = s.filter(filt);
        //s1.forEach(i-> System.out.println(i));
        Stream<Integer> s2 = s1.map(ma);
       // s2.forEach(i-> System.out.println(i));
        int sum = s2.reduce(0,(n1,n2)->n1+n2);
        System.out.println(sum);
        ArrayList<Employee> li = new ArrayList<>();

     // list.forEach(i -> System.out.println(i));
//        int sum = 0;
//        System.out.println(list);
//        List<Integer> list1 = new ArrayList<Integer>();
//        for(Integer num: list){
//            if(num%2 == 0){
//                list1.add(2*num);
//            }
//        }
//        System.out.println(list1);
//        for(Integer num:list1){
//            sum+=num;
//        }
//        System.out.println(sum);
    }

}
