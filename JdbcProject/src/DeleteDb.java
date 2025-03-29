import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDb {
    public static void main(String[] args)  throws Exception {
      // Load the MySQL JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver loaded successfully");
      // Establish the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");
      System.out.println("Connection established successfully");
       
      // create a query
        String query = "DELETE FROM student WHERE id = 1";
        // create a statement
        Statement stmt = con.createStatement();
        // execute the query
        int rowsAffected = stmt.executeUpdate(query);
        // print the number of rows affected
        System.out.println("Rows affected: " + rowsAffected);
        // check if the row was deleted successfully
        if (rowsAffected > 0) {
            System.out.println("Row deleted successfully");
        } else {
            System.out.println("No row found with the given id");
        }

        // close the connection
        stmt.close();
        con.close();
        System.out.println("Connection closed successfully");

        
    }
}