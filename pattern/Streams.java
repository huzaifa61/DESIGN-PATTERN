import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String args[]){
        List<Integer> l = new ArrayList<>();
        List<Integer> list = Stream.of(12, 6, 5, 3, 1, 11).filter(integer -> integer.toString().startsWith("1")).toList();

        Integer num = Stream.of(12, 6, 5, 3, 1, 11).max(Integer::compare).get();
      //  list.forEach(System.out::println);
      //  System.out.println(num);
        Optional<Integer> var = Stream.of(12, 6, 5, 3, 1, 11).max(Comparator.naturalOrder());
        if (var.isPresent()) {
            System.out.println(var.get());
        }
        else {
            System.out.println("-1");
        }
    }
}

 class TestClass {
    public TestClass() {
        TestClass t = new TestClass();
    }
}

class Test {
    public static void main(String... args) {
        Test test = null;
        test.greeting(); // call with null reference
        test.greeting(); // call with null reference

    }
    public static void greeting() {
        System.out.println("Hello World");
    }
}
