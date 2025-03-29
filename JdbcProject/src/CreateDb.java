import java.sql.Connection;
import java.sql.DriverManager;

public class CreateDb {

    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");
        System.out.println("Connection established successfully");
        if(con.isClosed()){
            System.out.println("Connection is closed");
        }
        else{
            System.out.println("Connection is open");
        }
    }
    
}
