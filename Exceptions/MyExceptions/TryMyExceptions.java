
class MyException extends Exception {
    public MyException(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}

public class TryMyExceptions {
    public static void main(String[] args) {
        try {
            throw new MyException("Try exception");

        } catch (MyException ex) {
            System.out.println("Caught");
            System.out.println(ex.getMessage());
        }
    }
}
