import java.rmi.Naming;
import java.util.Scanner;

public class TaxClient {
    public static void main(String[] args) {
        try {
            tax taxServant = (tax) Naming.lookup("rmi://localhost:1100/NamingMethod");
            Scanner scanner = new Scanner(System.in);
            String s = "y";
            while ((s.equals("Y")) || (s.equals("y"))) {
                System.out.println("Enter Your income: ");
                double income = scanner.nextDouble();
                double tax = taxServant.calculateTax(income);
                System.out.println("Your income tax is: " + tax);
                System.out.println("Do you want to continue? (Y/N)");
                s = scanner.next();
            }
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}