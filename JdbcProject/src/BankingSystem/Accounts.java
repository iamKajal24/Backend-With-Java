package BankingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Accounts {

    private Connection conn;
    private BufferedReader br;

    public Accounts(Connection conn, BufferedReader br) {
        this.conn = conn;
        this.br = br;
    }

    public long openAccount(String email) throws IOException {
        if (!accountExists(email)) {
            System.out.println("Enter your full name: ");
            String fullName = br.readLine();
            System.out.println("Enter Initial Amount: ");
            double balance = Double.parseDouble(br.readLine());
            System.out.println("Enter your security pin: ");
            String securityPin = br.readLine();

            long accountNumber = generateAccountNumber();
            String openAccountQuery = "INSERT INTO account (account_number, full_name, email, balance, security_pin) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(openAccountQuery)) {
                pstmt.setLong(1, accountNumber);
                pstmt.setString(2, fullName);
                pstmt.setString(3, email);
                pstmt.setDouble(4, balance);
                pstmt.setString(5, securityPin);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Account opened successfully with account number: " + accountNumber);
                    return accountNumber;
                } else {
                    System.out.println("Account opening failed.");
                }
            } catch (Exception e) {
                System.out.println("Error in opening account: " + e.getMessage());
            }
        } else {
            System.out.println("Account already exists.");
        }
        return 0;
    }

    public long getAccountNumber(String email) {
        String query = "SELECT account_number FROM account WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getLong("account_number");
            }
        } catch (Exception e) {
            System.out.println("Error in fetching account number: " + e.getMessage());
        }
        return 0;
    }

    private long generateAccountNumber() {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT account_number FROM account ORDER BY account_number DESC LIMIT 1")) {
            if (rs.next()) {
                return rs.getLong("account_number") + 1;
            }
        } catch (Exception e) {
            System.out.println("Error in generating account number: " + e.getMessage());
        }
        return 1000000000L; // Default account number
    }

    private boolean accountExists(String email) {
        String query = "SELECT account_number FROM account WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Error in checking account existence: " + e.getMessage());
        }
        return false;
    }
}
