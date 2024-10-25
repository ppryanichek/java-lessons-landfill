
class MultithreadingDemo implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class TAR {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread obj = new Thread(new MultithreadingDemo());
            obj.start();
        }
    }

}
