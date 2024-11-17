public class Multiplication {
    public static void main(String[] args) {
        int[][] table = multiplicationTable(4);

        for (int[] table1 : table) {
            for (int j = 0; j < table1.length; j++) {
                System.out.print(table1[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicationTable(int n) {
        int[][] arr = new int[n][n];
        int row = 1;
        for (int[] el : arr) {
            for (int i = 0; i < el.length; i++) {
                el[i] = (i + 1) * row;
            }
            ++row;
        }

        return arr;
    }
}