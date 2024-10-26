
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThread extends Thread {
    String name;
    int i;

    public TestThread(String name, int i) {
        this.name = name;
        this.i = i;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        System.out.println("Current thread is: " + Thread.currentThread().getName());
        MyThread.SSS(2, i);

    }
}

public class MyThread {
    public static void main(String[] args) {

        new Thread(() -> {
            Thread.currentThread().setName("anon");
            MyThread.SSS(3, 5);
        }).start();

        Thread th1 = new TestThread("th1", 1);
        Thread th2 = new TestThread("th2", 2);
        Thread th3 = new TestThread("th3", 3);
        Thread th4 = new TestThread("th4", 4);
        Thread th5 = new TestThread("th5", 5);
        Thread th6 = new TestThread("th6", 6);

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(th1);
        pool.execute(th2);
        pool.execute(th3);
        pool.execute(th4);
        pool.execute(th5);
        pool.execute(th6);

        pool.shutdown();

    }

    public static void SSS(int a, int b) {
        int s = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s += a * b;
        }

        System.out.println(Thread.currentThread().getName() + " S = " + s);
    }
}
