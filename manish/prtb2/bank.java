import java.io.*;
import java.sql.*;

public class bank {

    public static void main(String[] args) throws Exception {
        DataInputStream db = new DataInputStream((System.in));
        Connection con;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Bankdb", "", "");
            while (true) {
                System.out.println("\nBank Managment System");
                System.out.println("1. Add New Account Holder Information");
                System.out.println("2. Deposit Money");
                System.out.println("3. Amount Withdrawal(Maintain Minimum Balance 500 Rs)");
                System.out.println("4. Display All Information");
                System.out.println("5. Exit");
                System.out.print("Enter Your Choice: ");
                int choice = Integer.parseInt(db.readLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Holder Details: ");
                        System.out.println("Account Number");
                        String accountNumber1 = db.readLine();
                        System.out.println("Account Holder Name");
                        String name1 = db.readLine();
                        System.out.println("Account Holder Address");
                        String address1 = db.readLine();
                        System.out.println("Balance");
                        double balance1 = Double.parseDouble(db.readLine());
                        PreparedStatement statement1 = con.prepareStatement(
                                "INSERT INTO Bank (ACC_NO,ACC_NAME,ACC_ADDRESS,BALANCE) VALUES(?,?,?,?)");
                        statement1.setString(1, accountNumber1);
                        statement1.setString(2, name1);
                        statement1.setString(3, address1);
                        statement1.setDouble(4, balance1);
                        int rowsInserted1 = statement1.executeUpdate();
                        if (rowsInserted1 > 0) {
                            System.out.println("Account Holder Information Added Successfully");
                        } else {
                            System.out.println("Account Holder Information Not Added");
                        }
                        break;
                    case 2:
                        System.out.print("Enter Account Number: ");
                        String accountNumber2 = db.readLine();
                        System.out.print("Enter Amount to Deposit: ");
                        double amount2 = Double.parseDouble(db.readLine());
                        PreparedStatement statement2 = con
                                .prepareStatement("UPDATE Bank SET BALANCE = BALANCE + ? WHERE ACC_NO = ?");
                        statement2.setDouble(1, amount2);
                        statement2.setString(2, accountNumber2);
                        int rowsUpdated2 = statement2.executeUpdate();
                        if (rowsUpdated2 > 0) {
                            System.out.println("Amount Deposited Successfully");
                        } else {
                            System.out.println("Amount Not Deposited");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Account Number: ");
                        String accountNumber3 = db.readLine();
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount3 = Double.parseDouble(db.readLine());
                        PreparedStatement statement3 = con.prepareStatement(
                                "UPDATE Bank SET BALANCE = BALANCE - ? WHERE ACC_NO = ? AND BALANCE - ? >=500");
                        statement3.setDouble(1, amount3);
                        statement3.setString(2, accountNumber3);
                        statement3.setDouble(3, amount3);
                        int rowsUpdated3 = statement3.executeUpdate();
                        if (rowsUpdated3 > 0) {
                            System.out.println("Amount Withdrawn Successfully");
                        } else {
                            System.out.println("Amount Not Withdrawn");
                        }
                        break;
                    case 4:
                        Statement statement4 = con.createStatement();
                        ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM Bank");
                        System.out.println("\nAccount Holder Details:");
                        while (resultSet4.next()) {
                            System.out.println("Account Number: " + resultSet4.getString("ACC_NO"));
                            System.out.println("Account Holder Name: " + resultSet4.getString("ACC_NAME"));
                            System.out.println("Account Holder Address: " + resultSet4.getString("ACC_ADDRESS"));
                            System.out.println("Account Holder Balance: " + resultSet4.getDouble("BALANCE"));
                            System.out.println("");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}