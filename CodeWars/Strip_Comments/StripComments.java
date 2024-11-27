
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StripComments {
    public static void main(String[] args) {
        System.out.println(
                stripComments("apples, pears # and bananas\ngrapes\nbananas !apples\n     ",
                        new String[] { "#", "!" }));
        System.out.println(
                stripComments("a #b\nc\nd $e f g", new String[] { "#", "$" }));
        System.out.println(
                stripComments("a \n b \nc", new String[] { "#", "$" }));
    }

    public static String stripComments(String text, String[] commentSymbols) {

        return Stream.of(text.split("\n"))
                .map(word -> word
                        .replaceAll("[" + Stream.of(commentSymbols).collect(Collectors.joining("|")) + "].*$", " ")
                        .stripTrailing())
                .collect(Collectors.joining("\n"));
    }
}