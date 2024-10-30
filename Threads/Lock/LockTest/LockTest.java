import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        TestResource test = new TestResource();
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 5; i++) {
            thread[i] = new Thread(new DisplayJob(test), "Thread " + i);
        }
        for (int i = 5; i < 10; i++) {
            thread[i] = new Thread(new ReadJob(test), "Thread " + i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}

class DisplayJob implements Runnable {
    private final TestResource test;

    public DisplayJob(TestResource test) {
        this.test = test;
    }

    @Override
    public void run() {
        System.out.println("Display Job");
        test.dispalyRecord(new Object());
    }

}

class ReadJob implements Runnable {
    private final TestResource test;

    public ReadJob(TestResource test) {
        this.test = test;
    }

    @Override
    public void run() {
        System.out.println("Read Job");
        test.readRecord(new Object());
    }

}

class TestResource {
    private final Lock displayQueueLock = new ReentrantLock();

    private final Lock readQueueLock = new ReentrantLock();

    public void dispalyRecord(Object document) {
        final Lock displayLock = this.displayQueueLock;
        displayLock.lock();

        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() +
                    ": TestResource: display a Job during " + (duration / 1000) +
                    " seconds :: Time - " + new Date());
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            System.out.println("$s: The document has been displayed: " + Thread.currentThread().getName());
            displayLock.unlock();
        }
    }

    public void readRecord(Object document) {
        final Lock readLock = this.readQueueLock;
        readLock.lock();

        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() +
                    ": TestResource: reading a Job during " + (duration / 1000) +
                    " seconds :: Time - " + new Date());
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            System.out.println("$s: The document has been read: " + Thread.currentThread().getName());
            readLock.unlock();
        }
    }
}