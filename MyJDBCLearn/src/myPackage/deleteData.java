package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteData {

	public static void main(String[] args) {
//		driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//			connection 
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kajal", "root", "root");

			System.out.println("connection successfully...");

			Statement statement = connection.createStatement();

			String query = String.format("delete from students where student_id=%d", 7);

			int rowAffected = statement.executeUpdate(query);

			if (rowAffected > 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("delete not successfully");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
