import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class OnesAndZeroes {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

        System.out.println("Enter binary value: ");
        Scanner scanner = new Scanner(System.in);
        
        int size = 4;
        Integer[] binaryArr = new Integer[size];
        for (int i = 0; i < size; i++) { binaryArr[i] = scanner.nextInt(); }

        List<Integer> binaryList = Arrays.asList(binaryArr);
        System.out.println("RESULT is: " + ConvertBinaryArrayToInt(binaryList));
    }
    
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int res = 0;
        int index = 0;
        for (int i = binary.size() - 1; i >= 0; i--) {
            if (binary.get(i) == 1)
                res += Math.pow(2, index);
            index++;
        }
        return res;
        
        //Best solution 
        // return binary.stream().reduce(0,(x, y) -> x * 2 + y);
    }
}