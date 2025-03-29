package BankingSystem;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountManager {

    private Connection conn;
    private BufferedReader br;

    public AccountManager(Connection conn, BufferedReader br) {
        this.conn = conn;
        this.br = br;
    }

    public void creditMoney(long accountNumber) throws Exception {
        System.out.println("Enter amount to credit: ");
        double amount = Double.parseDouble(br.readLine());
        System.out.println("Enter your security pin: ");
        String securityPin = br.readLine();

        try {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("SELECT balance FROM account WHERE account_number = ? AND security_pin = ?");
            pstmt.setLong(1, accountNumber);
            pstmt.setString(2, securityPin);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double newBalance = rs.getDouble("balance") + amount;
                PreparedStatement creditStmt = conn.prepareStatement("UPDATE account SET balance = ? WHERE account_number = ?");
                creditStmt.setDouble(1, newBalance);
                creditStmt.setLong(2, accountNumber);
                creditStmt.executeUpdate();
                conn.commit();
                System.out.println("Amount credited successfully. New balance: " + newBalance);
            } else {
                System.out.println("Invalid account number or security pin.");
                conn.rollback();
            }
        } catch (Exception e) {
            System.out.println("Error in crediting money: " + e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
