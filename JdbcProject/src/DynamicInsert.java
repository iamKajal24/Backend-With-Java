import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsert {

    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver loaded successfully");
         // Establish the connection
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");
        
         //create a query
        String query = "Insert into student(name,city) values(?,?)";

        //create a prepared statement
        PreparedStatement pstmt = con.prepareStatement(query);
        
        //get user input to insert into the table
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name:");
        String name = br.readLine();
        System.out.println("Enter city:");
        String city = br.readLine();
        
        //set the values for the placeholders
        pstmt.setString(1, name);
        pstmt.setString(2, city);

        //execute the query
        pstmt.executeUpdate();
        System.out.println("Record inserted successfully");

        //close the resources
        pstmt.close();
        con.close();
        System.out.println("Connection closed successfully");
    }
    
}
