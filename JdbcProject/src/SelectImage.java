import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectImage {

    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");

        String query = "select * from image";
        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(query);
        while(set.next()){
            // Access column values by column index
            int id = set.getInt(1);
            byte[] image = set.getBytes(2);
            System.out.println("ID: " + id + " Image: " + image);
        }    
        con.close();
        statement.close();
        set.close();
        System.out.println("Connection closed successfully");    
    }
    
}
