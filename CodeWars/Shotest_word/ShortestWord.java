import java.util.Scanner;

class ShortestWord {
    public static void main(String[] args) {
        System.out.println("Enter your text: ");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println("Length of the shortest(s) word(s) in the line: " + findShort(string));

    }
    
    public static int findShort(String s) {
        String[] words = s.split(" ");
        String shortest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
        }
        return shortest.length();
    }
}