import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandlingdb {

    public static void main(String[] args) throws Exception {
        
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        
        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");
        System.out.println("Connection established successfully");

        // Set auto-commit to false
        con.setAutoCommit(false);
        System.out.println("Auto-commit set to false");

        //create a query
        String WithdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String DepositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        //create a prepared statement
        PreparedStatement withdrawStmt = con.prepareStatement(WithdrawQuery);
        PreparedStatement depositStmt = con.prepareStatement(DepositQuery);

        //set the parameters for the withdraw statement
        withdrawStmt.setDouble(1, 1000.00); // Amount to withdraw
        withdrawStmt.setString(2, "account1233"); // Account number to withdraw from

        //set the parameters for the deposit statement
        depositStmt.setDouble(1, 1000.00); // Amount to deposit
        depositStmt.setString(2, "account24986"); // Account number to deposit to

       int rowsAffectedwithdraw = withdrawStmt.executeUpdate();
        System.out.println("Withdraw operation executed successfully");
        int rowsAffecteddeposit= depositStmt.executeUpdate();
        System.out.println("Deposit operation executed successfully");
         
        // Check if the rows were affected successfully
        if (rowsAffectedwithdraw > 0 && rowsAffecteddeposit > 0) {
            System.out.println("Transaction successful: Withdraw and Deposit operations completed successfully");
        } else {
            System.out.println("Transaction failed: One or more operations did not affect any rows");
        }
        // Commit the transaction -> commit means that the transaction is successful and all the changes made in the transaction are saved to the database.
        con.commit();
        System.out.println("Transaction committed successfully");

        // Rollback the transaction -> rollback means that the transaction is not successful and all the changes made in the transaction are undone and the database is restored to its previous state.
        // In this case, we are not rolling back the transaction, but if we want to roll back the transaction, we can do it like this:
         con.rollback();
        System.out.println("Transaction rolled back successfully");
    }
    
}
