
import java.util.*;
import java.util.stream.Stream;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(2, 3, 4, 5, 6, 7, 7, 18, 9);
        Stream s = li.stream();
        s.forEach(i -> System.out.println(i));
    }
}