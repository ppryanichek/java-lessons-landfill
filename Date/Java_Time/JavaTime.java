import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date is: " + currentDate);

        LocalDateTime currentDTime = LocalDateTime.now();
        System.out.println("Current date and time is: " + currentDTime);

        String currentDTimeFormatted = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("Current date and time is: " + currentDTimeFormatted);

        Clock systemClock = Clock.systemDefaultZone();
        System.out.println("Current instant: " + systemClock.instant());

        System.out.println("Is before: \t" + currentDate.isBefore(LocalDate.now()));
        System.out.println("Is now: \t" + currentDate.isEqual(LocalDate.now()));
        System.out.println("Is after: \t" + currentDate.isAfter(LocalDate.now()));
    }
}
