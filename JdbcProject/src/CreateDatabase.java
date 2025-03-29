import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");

            // Create a query (Fixed syntax error: NOT NULL instead of notnull)
            String query = "CREATE TABLE student ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(255) NOT NULL, "
                    + "city VARCHAR(255))";

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the query
            stmt.executeUpdate(query);
            System.out.println("Table created successfully");

            // Close resources
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
