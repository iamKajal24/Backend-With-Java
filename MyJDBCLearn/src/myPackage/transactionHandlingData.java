package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class transactionHandlingData {

    private static final String URL = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {

        // load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection
        Connection connection = DriverManager.getConnection(
                URL,
                username,
                password
        );

        String debit_query =
                "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";

        String credit_Query =
                "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        PreparedStatement debitPreparedStatement =
                connection.prepareStatement(debit_query);

        PreparedStatement creditPreparedStatement =
                connection.prepareStatement(credit_Query);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount : ");
        int amount = scanner.nextInt();

        debitPreparedStatement.setInt(1, amount);
        debitPreparedStatement.setInt(2, 1001);

        creditPreparedStatement.setInt(1, amount);
        creditPreparedStatement.setInt(2, 1002);
//
//        if (isSufficient(connection, 1001, amount)) {
//
//            int affectedRows1 =
//                    debitPreparedStatement.executeUpdate();
//
//            int affectedRows2 =
//                    creditPreparedStatement.executeUpdate();
//
//            System.out.println("Transaction successful.");
//
//        } else {
//
//            System.out.println("Insufficient Balance!!");
//        }
        
        
    }

    static boolean isSufficient(
            Connection connection,
            int account_number,
            int amount)
            throws SQLException {

        String query =
                "SELECT balance FROM accounts WHERE account_number = ?";

        PreparedStatement preparedStatement =
                connection.prepareStatement(query);

        preparedStatement.setInt(1, account_number);

        ResultSet resultSet =
                preparedStatement.executeQuery();

        if (resultSet.next()) {

            int current_balance =
                    resultSet.getInt("balance");

            if (amount > current_balance) {

                return false;

            } else {

                return true;
            }
        }

        return false;
    }
}