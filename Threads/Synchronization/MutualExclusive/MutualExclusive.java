
class Sender {
    public void send(String msg) {
        System.out.println("Sending:\t" + msg);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Thread interrupted!");
        }

        System.out.println(msg + " sent");
    }
}

class ThreadedSend extends Thread {
    private final String msg;
    final Sender sender;

    public ThreadedSend(String m, Sender s) {
        msg = m;
        sender = s;
    }

    @Override
    public void run() {
        synchronized (sender) {
            sender.send(msg);
        }
    }
}

class Test {
    synchronized void testFunction(int n) {
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + " * " + n + " = " + n * (i + 1));

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class MutualExclusive {
    public static void main(String[] args) {
        Sender send = new Sender();
        ThreadedSend s1 = new ThreadedSend(" Hi ", send);
        ThreadedSend s2 = new ThreadedSend(" Bye ", send);

        final Test obj = new Test();

        Thread one = new Thread() {
            public void run() {
                obj.testFunction(15);
            }
        };

        Thread two = new Thread() {
            public void run() {
                obj.testFunction(15);
            }
        };
        one.start();
        two.start();

        s1.start();
        s2.start();

        try {
            one.join();
            two.join();

            s1.join();
            s2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }

    }
}
