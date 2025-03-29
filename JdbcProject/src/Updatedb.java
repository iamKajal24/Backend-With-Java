import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Updatedb {
    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");

        // query image
        String query = "update student set name=?, city=? where id=?";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter new name :");
        String name = br.readLine();
        System.out.println("Enter new city :");
        String city = br.readLine();
        System.out.println("Enter id :");
        int id = Integer.parseInt(br.readLine());

        // create a prepared statement
        PreparedStatement pstmt = con.prepareStatement(query);
        // set the values for the placeholders
        pstmt.setString(1, name);
        pstmt.setString(2, city);
        pstmt.setInt(3, id);

        // execute the query
        int rowsAffected = pstmt.executeUpdate();
        System.out.println("Rows affected : " + rowsAffected);
        System.out.println("Record updated successfully");
        
        // close resources
        pstmt.close();
        con.close();
        System.out.println("Connection closed successfully");
        
        
       
    }
}
