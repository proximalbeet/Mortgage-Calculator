import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        final byte MonthsInYear = 12;
        final byte Percent = 100;
        double principal = 0;
        double monthlyInterest = 0;
        double payments = 0;
        double numberOfPayments = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Principal ($1k - $1m): ");
                principal = scanner.nextDouble();
                if (principal >= 1_000 && principal <= 1_000_000) 
                    break;
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            }

            while (true) {
                System.out.print("Interest Rate: ");
                double interest = scanner.nextDouble();
                if (interest >= 1 && interest <= 30) {
                    monthlyInterest = interest / Percent / MonthsInYear;
                    break;
                }
                System.out.println("Enter a number between 1 and 30.");
            }

            while (true) {
                System.out.print("Period (Years): ");
                payments = scanner.nextDouble();
                if (payments >= 1 && payments <= 30){
                    numberOfPayments = payments * MonthsInYear;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }
            
            double MonthlyPayments = (principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1)));
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String result = currency.format(MonthlyPayments);
            System.out.println("Mortgage: " + result);
        }
    }
}
