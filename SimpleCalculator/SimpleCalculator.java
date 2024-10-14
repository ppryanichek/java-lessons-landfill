import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        double num1, num2, res = 0;
        int operator;

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number: ");

        num1 = reader.nextDouble();

        System.err.println("\nEnter an operator from (<1> +, <2> -, <3> *, <4> /, <5> sqr, <6> sqrt):");
        operator = reader.nextInt();

        switch (operator) {
            case 1:
                System.out.println("Enter the second number: ");
                num2 = reader.nextDouble();
                res = num1 + num2;
                break;
            case 2:
                System.out.println("Enter the second number: ");
                num2 = reader.nextDouble();
                res = num1 - num2;
                break;
            case 3:
                System.out.println("Enter the second number: ");
                num2 = reader.nextDouble();
                res = num1 * num2;
                break;
            case 4:
                System.out.println("Enter the second number: ");
                num2 = reader.nextDouble();
                res = num1 / num2;
                break;
            case 5:
                res = num1 * num1;
                break;
            case 6:
                res = Math.sqrt(num1);
                break;

            default:
                System.err.println("There`s no such operator!");
                reader.close();
                return;
        }

        reader.close();

        System.out.println("\nThe result is:\t" + res);

    }

}
