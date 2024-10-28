
class ThreadChild extends Thread {

    public void run() {

        System.out.println("Shutdown Hook");
    }
}

record Person(String name, String address) {
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

public class ShutdownHook {
    public static void main(String[] args) {
        // Runtime.getRuntime().addShutdownHook(new Thread() {
        // public void run() {
        // System.out.println("Shutdown Hook is running!");
        // }
        // });

        // System.out.println("App Terminating ... ");

        Runtime current = Runtime.getRuntime();
        current.addShutdownHook(new ThreadChild());
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " * 2 = " + 2 * i);
        }
    }
}
