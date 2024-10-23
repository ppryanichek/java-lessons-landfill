import java.util.Scanner;

public class SumOddNumbers {
    public static void main(String[] args) {
        System.out.println("Enter the number of steps: ");
        
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        System.out.println();
        int[][] arr = new int[size][];
        int number = 1;

        for (int i = 0; i < size; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = number;
                number += 2;
            }
        }

        oddPyramid(arr, size);

        int row = 4;
        System.out.println("\nResult of summ in row \"" + row + "\": " + sumPyramidRow(arr, row));
        sumPyramidWithoutArray(row);
    }

    public static void oddPyramid(int[][] array, int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sumPyramidRow(int[][] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr[n - 1].length; i++) {
            sum += arr[n - 1][i];
        }
        return sum;
    }

    public static void sumPyramidWithoutArray(int n)
    {
        System.out.println("\nResult of summ in row  \"" + n + "\" (without array): " + (n * n * n));
    }
}
