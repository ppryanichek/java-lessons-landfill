
public class NarcissisticNumber {
    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));
    }

    public static boolean isNarcissistic(int number) {
        long sum = 0;
        String stringNum = Integer.toString(number);

        for (int i = 0; i < stringNum.length(); i++) {
            sum += Math.pow(Character.getNumericValue(stringNum.charAt(i)), stringNum.length());
        }
        return sum == number;
    }
}