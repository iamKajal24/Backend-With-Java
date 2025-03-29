import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Selectdb {

    public static void main(String[] args)  throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");

        String query = "select * from student";

        Statement statement = con.createStatement();
        ResultSet set=statement.executeQuery(query);
        while(set.next()){
            // Access column values by column index
            int id = set.getInt(1);
            String name = set.getString(2);
            String city = set.getString(3);
            System.out.println("ID: " + id + " Name: " + name + " City: " + city);
        }

        con.close();
        statement.close();
        set.close();
        System.out.println("Connection closed successfully");
        
    }
    
}
