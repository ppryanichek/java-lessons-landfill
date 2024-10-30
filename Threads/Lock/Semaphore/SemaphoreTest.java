
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);
        new Person(s, "Alex").start();
        new Person(s, "Oleg").start();
        new Person(s, "Eugene").start();
        new Person(s, "Peter").start();

    }
}

class Person extends Thread {
    private final Semaphore semaphore;

    private boolean full = false;
    private final String name;

    public Person(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!full) {
                semaphore.acquire();
                System.out.println(name + " doing something");
                try {
                    Thread.sleep(1000);
                    full = true;
                    System.out.println(name + " done");
                    semaphore.release();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
