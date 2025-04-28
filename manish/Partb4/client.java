import java.rmi.Naming;
import java.util.Scanner;
public class client {
    public static void main(String[] args) {
        try {
            simpleinterest si = (simpleinterest) Naming.lookup("rmi://localhost:1100/NamingMethod");
            Scanner scanner = new Scanner(System.in);
            String choice = "y";
            while (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the Principle: ");
                double principle = scanner.nextDouble();
                System.out.println("Enter the number of Years: ");
                int noOfYears = scanner.nextInt();
                System.out.println("Enter the Rate: ");
                double rate = scanner.nextDouble();
                double interest = si.getIntrest(principle, noOfYears, rate);
                System.out.println("Simple Interest: " + interest);
                System.out.println("Do you want to continue (y/n)?");
                choice = scanner.next();
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}