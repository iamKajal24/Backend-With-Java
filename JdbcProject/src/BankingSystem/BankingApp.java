package BankingSystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class BankingApp {
    public static void main(String[] args) {
        try {
            // Database Connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankingsystem", "root", "root");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            User user = new User(conn, br);
            Accounts account = new Accounts(conn, br);
            AccountManager accountManager = new AccountManager(conn, br);

            String loggedInEmail = null;
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\n===== Banking Application =====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Open Account");
                System.out.println("4. Check Balance");
                System.out.println("5. Credit Money");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        user.register();
                        break;

                    case 2:
                        loggedInEmail = user.login();
                        break;

                    case 3:
                        if (loggedInEmail != null) {
                            account.openAccount(loggedInEmail);
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;

                    case 4:
                        if (loggedInEmail != null) {
                            long accNumber = account.getAccountNumber(loggedInEmail);
                            if (accNumber > 0) {
                                System.out.println("Your Account Number: " + accNumber);
                            } else {
                                System.out.println("No account found.");
                            }
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;

                    case 5:
                        if (loggedInEmail != null) {
                            long accNumber = account.getAccountNumber(loggedInEmail);
                            if (accNumber > 0) {
                                accountManager.creditMoney(accNumber);
                            } else {
                                System.out.println("No account found.");
                            }
                        } else {
                            System.out.println("You need to log in first.");
                        }
                        break;

                    case 6:
                        isRunning = false;
                        System.out.println("Exiting the banking system. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            br.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in BankingApp: " + e.getMessage());
        }
    }
}
