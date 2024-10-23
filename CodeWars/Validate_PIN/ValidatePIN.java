import java.util.Scanner;

public class ValidatePIN {
    public static void main(String[] args) {
        System.out.println("\nPIN code codes cannot contain anything but exactly 4 digits or exactly 6 digits! ");
        System.out.println("Ener your PIN: ");

        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        String PIN = read.nextLine();

        if(validatePin(PIN)){
            System.out.println("Yup, your PIN is correct! :)");
        }
        else {
            System.out.println("Your PIN is incorrect! :(");
        }
    }
    
    public static boolean validatePin(String pin) {
        return pin.matches("^[0-9]{4}|[0-9]{6}$");
    }
}
