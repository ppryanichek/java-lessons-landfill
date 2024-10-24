import java.util.Scanner;

public class HighestScoringWord {
    public static void main(String[] args) {
        System.out.println("Enter your text: ");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println("The highest word in the line: " + high(string));
    }
    
    public static String high(String s) {
        String[] words = s.split(" ");

        int lower_case = 96;
        String highest_word = words[0];
        int prev_sum = 0;
        char[] ch = highest_word.toCharArray();
        for(char c : ch){
            prev_sum += (int)c - lower_case;
        }

        for (int i = 1; i < words.length; i++) {
            ch = words[i].toCharArray();
            int sum = 0; 
            for (char c : ch) {
                sum += (int) c - lower_case;
            }
            if (prev_sum < sum) {
                prev_sum = sum;
                highest_word = words[i];
            }
        }
        
        return highest_word;

    }
}
