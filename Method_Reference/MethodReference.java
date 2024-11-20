
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(1);

        // Using an anonymous class
        transformAndAdd(list, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return OpsUtil.doHalf(i);
            }
        });

        // Using a lambda expression
        transformAndAdd(list, i -> OpsUtil.doHalf(i));

        // Using a method reference
        transformAndAdd(list, OpsUtil::doHalf);

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("roberto", 55));
        personList.add(new Person("nick", 30));
        personList.add(new Person("bora", 47));
        personList.add(new Person("hella", 21));

        System.out.println("\nUnsorted list: ");
        personList.stream().map(i -> i.getAge()).forEach(System.out::println);

        // Using method reference
        Collections.sort(personList, Comparator.comparingInt(Person::getAge));

        System.out.println("\nSorted by age: ");
        personList.stream().map(i -> i.getAge()).forEach(System.out::println);

        // Using lambda expression
        Collections.sort(personList, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("\nSorted by name: ");
        personList.stream().map(i -> i.getAge()).forEach(System.out::println);
    }

    public static int transformAndAdd(List<Integer> l, Function<Integer, Integer> ops) {
        int res = 0;
        for (Integer s : l)
            res += ops.apply(s);

        return res;
    }

    class OpsUtil {
        public static Integer doHalf(Integer x) {
            return x / 2;
        }

        public static Integer doSquare(Integer x) {
            return x * x;
        }
    }

}

class Person {
    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}