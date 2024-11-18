
import java.util.*;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {

        { // multiplication table
            int number = 3;
            MultiplicationTable(number);
            System.out.println();
        }

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Bread", 0.69));
        productList.add(new Product("Milk", 2.19));
        productList.add(new Product("Tomatoes", 1.29));
        productList.add(new Product("Water", 0.29));

        System.out.println("Product with price over 1$: ");
        productList.stream().filter(product -> product.price > 1)
                .forEach(product -> System.out.println(product.name + ": " + product.price));

        System.out.println();
        System.out.println("max price in productList is: " +
                productList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1).get().price);
    }

    public static void MultiplicationTable(int n) {
        int[][] arr = IntStream.rangeClosed(1, n).mapToObj(i -> IntStream.rangeClosed(1, n).map(j -> i * j).toArray())
                .toArray(int[][]::new);

        // printing in console
        for (int[] el : arr) {
            for (int k = 0; k < el.length; k++) {
                System.out.print(el[k] + " ");
            }
            System.out.println();
        }
    }
}

class Product {
    double price;
    String name;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}