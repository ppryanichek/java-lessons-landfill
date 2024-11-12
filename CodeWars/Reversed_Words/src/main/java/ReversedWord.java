package main.java;

public class ReversedWord {
    public static void main(String[] args) {
        String line = "Hey wollef sroirraw";
        System.out.println(spinWords(line));
    }

    public static String spinWords(String sentence) {
        String result = "";
        for (String word : sentence.split(" ")) {
            if (word.length() >= 5) {
                result += new StringBuilder(word).reverse().toString() + " ";
                continue;
            }
            result += word + " ";
        }
        return result.strip();
    }

    // Shortest solution

    // public static String spinWords(String sentence) {

    // return Arrays.stream(sentence.split(" "))
    // .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
    // .collect(Collectors.joining(" "));
    // }
}