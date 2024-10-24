import java.util.Scanner;

public class BreakCamelCase {
    public static void main(String[] args) {
        System.out.println("Enter your text: ");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println("Line With No Camel Case: " + camelCase(string));
    }
    
    public static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }
}
