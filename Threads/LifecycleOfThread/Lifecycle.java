
class thread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out
                .println("State of thread1 while it called join() methon on -thread2- " + Lifecycle.thread1.getState());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Lifecycle implements Runnable {
    public static Thread thread1;
    public static Lifecycle obj;

    public static void main(String[] args) {
        obj = new Lifecycle();
        thread1 = new Thread(obj);

        System.out.println("State of thread1 after creating " + thread1.getState());
        thread1.start();

        System.out.println("State of thread1 after calling .start() methon on it " + thread1.getState());
    }

    @Override
    public void run() {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);
        System.out.println("State of -thread2- after creating " + thread2.getState());
        thread2.start();

        System.out.println("State of -thread2- after calling .start() methon on it " + thread2.getState());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("State of -thread2- after calling method sleep() on it " + thread2.getState());

        try {
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 when it has finished it's execution - " + thread2.getState());
    }
}