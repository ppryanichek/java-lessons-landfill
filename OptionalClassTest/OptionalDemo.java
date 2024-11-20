
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];

        // Using Oprional to avoid NullPointerException
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5];
            System.out.println(word);
        } else {
            System.out.println("word is null!");
        }

        // or shorter
        words[5] = "hola";

        System.out.println(Optional.ofNullable(words[5]).orElse("word is null!"));
    }
}