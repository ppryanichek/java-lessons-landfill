import java.util.*;
import java.util.function.Predicate;

interface Converter<T, N> {
    N convert(T t);
    
    static <T> boolean isNotNull(T t) {
        return t != null;
    }

    default void writeToConsole(T t) {
        System.out.println("Obj: " + t);
    }

    public boolean equals(Object obj);
}

class Dog {
    String name;
    int age, weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Cat {
    String name;
    int age, weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

public class FunctionalInterfaces
{
    public static void main(String[] args) {
        //Converter
        Dog dog = new Dog("Doggie", 7, 10);
        Converter<Dog, Cat> converter = x -> new Cat(x.name, x.age, x.weight);

        Cat cat = converter.convert(dog);
        
        System.out.println("Cat name: " + cat.name + "\nCat age: " + cat.age + "\nCat weight: " + cat.weight + '\n');

        System.out.println(res);
        //Predicate
        List<String> names = Arrays.asList("Big", "Bigger", "boss", "bool");        
        Predicate<String> predicate = (s) -> s.startsWith("B");

        for (String el : names) {
            if(predicate.test(el)){
                System.out.println(el);
            }
        }
    }
}