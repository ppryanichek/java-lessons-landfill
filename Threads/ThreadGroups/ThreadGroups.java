
class NewThread extends Thread {

    NewThread(String threadName, ThreadGroup threadGroup) throws IllegalThreadStateException {
        super(threadGroup, threadName);
        start();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Exception encounterted");
            }
        }
        System.out.println(Thread.currentThread().getName() +
                " finished executing");
    }
}

public class ThreadGroups {
    @SuppressWarnings("removal")
    public static void main(String[] args) throws InterruptedException {
        // thread grups
        ThreadGroup threadGroup = new ThreadGroup("Parent thread group");

        ThreadGroup thg_child = new ThreadGroup(threadGroup, "Child1 thread group");

        ThreadGroup thg_child2 = new ThreadGroup(thg_child, "Child2 thread group");

        System.out.println("Parent of \"Parent thread\": " + threadGroup.getParent().getName());
        System.out.println("Parent of \"Child1 thread group\": " + thg_child.getParent().getName());
        System.out.println("Parent of \"Child2 thread group\": " + thg_child2.getParent().getName());

        thg_child2.setDaemon(true);
        NewThread th1 = new NewThread("Thread one", thg_child);
        System.out.println("Starting thread #1");

        NewThread th2 = new NewThread("Thread two", threadGroup);
        System.out.println("Starting thread #2");

        NewThread th3 = new NewThread("Thread three", threadGroup);
        System.out.println("Starting thread #1");

        NewThread th4 = new NewThread("Thread four", thg_child2);
        System.out.println("Starting thread #2");

        System.out.println("Number of active thread: " + threadGroup.activeCount());

        System.out.println("Number of active thread groups: " + threadGroup.activeGroupCount());

        // enumerate
        Thread[] group = new Thread[threadGroup.activeCount()];
        int count = threadGroup.enumerate(group, true);
        for (int i = 0; i < count; i++) {
            System.out.println("Thread " + group[i].getName());
        }

        thg_child.interrupt();

    }
}
