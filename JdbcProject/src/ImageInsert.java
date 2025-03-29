import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ImageInsert {

    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver loaded successfully");
         // Establish the connection
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcex", "root", "root");
        
        // create table image(id int primary key auto_increment,pic blob);

        //query image
        String query = "Insert into image(pic) values(?)";

        //create a prepared statement
        PreparedStatement pstmt = con.prepareStatement(query);
        //set the values for the placeholders
        FileInputStream fis = new FileInputStream("C:\\Users\\intel\\Downloads\\rose.jpeg");
        pstmt.setBinaryStream(1, fis, fis.available());

        //execute the query
        pstmt.executeUpdate();
        System.out.println("Image inserted successfully");

        //close the resources
        pstmt.close();
        con.close();
        System.out.println("Connection closed successfully");

       


    }
    
}
