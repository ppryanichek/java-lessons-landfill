import java.util.Scanner;

public class palindrome
{
    public static void main(String[] args) {
        System.out.println("Enter your text: ");


        try (Scanner in = new Scanner(System.in)) {
            String myString = in.nextLine();
            System.out.println(isPalindrome(myString));
        }
    }
    
    public static boolean isPalindrome(String text) {
        String newString = text.replaceAll("[^a-zA-Z]", "");

        StringBuilder sb = new StringBuilder(newString);
        return newString.equalsIgnoreCase((sb.reverse().toString()));
    }
}