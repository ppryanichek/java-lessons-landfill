import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleClock {
    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            while (true) {

                Date date = Calendar.getInstance().getTime();
                DateFormat formatter = new SimpleDateFormat("EEEEE, dd MMM yyyy, HH:mm:ss");
                String today = formatter.format(date);
                System.out.print("Today: " + today + "\r");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    System.out.println(e);
                }
            }
        });
        th.start();
    }
}
