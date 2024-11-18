
import java.util.Arrays;
import java.util.Comparator;

public class Order {
    public static void main(String[] args) {
        String string = "4of Fo1r pe6ople g3ood th5e the2";

        System.out.println(order(string));
    }

    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(w -> Integer.valueOf(w.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}