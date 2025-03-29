import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchProccessingUsingPrepared {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/jdbcex";
        String user = "root";
        String password = "root";

        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection(url, user, password)){
            System.out.println("Connection established successfully");
            con.setAutoCommit(false);
            
            String query = "INSERT INTO student (name, city) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            Scanner sc = new Scanner(System.in);
            while(true){

                System.out.println("Enter Student Name");
                String name = sc.nextLine();
                System.out.println("Enter Student City");
                String city = sc.nextLine();

                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.addBatch(); // Add the current parameters to the batch
                
                System.out.println("Do you want to add more records? (yes/no)");
                String choice = sc.nextLine();
                if(!choice.equalsIgnoreCase("yes")){
                    break;
                }
            }

            int[] batchResult = pstmt.executeBatch(); // Execute the batch
            con.commit(); // Commit the transaction
            System.out.println("Batch executed successfully. Number of rows affected: " + batchResult.length);
    }
    catch(Exception e){
            e.printStackTrace();
        }
    }
}
