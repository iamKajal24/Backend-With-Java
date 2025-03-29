package BankingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private Connection conn;
    private BufferedReader br;

    public User(Connection conn, BufferedReader br) {
        this.conn = conn;
        this.br = br;
    }

    // Create a registered user
    public void register() throws IOException {
        System.out.println("Enter your name: ");
        String full_name = br.readLine();
        System.out.println("Enter your email: ");
        String email = br.readLine();
        System.out.println("Enter password: ");
        String password = br.readLine();

        if (userExists(email)) {
            System.out.println("User already exists with this email.");
            return;
        }

        String registerQuery = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(registerQuery)) {
            pstmt.setString(1, full_name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("User registration failed.");
            }
        } catch (Exception e) {
            System.out.println("Error in registration: " + e.getMessage());
        }
    }

    // Login user
    public String login() throws IOException {
        System.out.println("Enter your email: ");
        String email = br.readLine();
        System.out.println("Enter password: ");
        String password = br.readLine();

        String loginQuery = "SELECT email FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(loginQuery)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User logged in successfully.");
                return email;
            } else {
                System.out.println("Invalid email or password.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error in login: " + e.getMessage());
        }
        return null;
    }

    // Check if user exists
    private boolean userExists(String email) {
        String checkUserQuery = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(checkUserQuery)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Error checking user existence: " + e.getMessage());
        }
        return false;
    }
}
