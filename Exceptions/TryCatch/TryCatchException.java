
public class TryCatchException {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[4];

        try {
            int a = arr[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught 1 in main!");
        }

        try {
            fun();
        } catch (IllegalAccessException e) {
            System.out.println("Caught fun() in main!");
        }
        System.out.println("Other code outside try-catch!");
    }

    public static void fun() throws IllegalAccessException {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }
}