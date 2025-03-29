import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BachProccessing {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/jdbcex";
        String user = "root";
        String password = "root";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");

            conn.setAutoCommit(false); // Disable auto-commit mode

            Statement stmt = conn.createStatement();
            // Add multiple SQL statements to the batch
            stmt.addBatch("INSERT INTO student (id, name, city ) values (1, 'John', 'New York')");
            stmt.addBatch("INSERT INTO student (id, name, city ) values (5, 'Jane', 'Los Angeles')");
            stmt.addBatch("INSERT INTO student (id, name, city ) values (6, 'Mike', 'Chicago')");
            stmt.addBatch("INSERT INTO student (id, name, city ) values (7, 'Sara', 'Houston')"); 
            

            int[] batchResult =stmt.executeBatch();
            conn.commit();
            System.out.println("Batch executed successfully. Number of rows affected: " + batchResult.length);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
