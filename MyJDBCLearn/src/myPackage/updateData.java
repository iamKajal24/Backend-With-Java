package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateData {

	public static void main(String[] args) {
		// driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		connection 
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kajal", "root", "root");

			System.out.println("connection successfully...");

			Statement statement = connection.createStatement();

			String query = String.format("UPDATE students set first_name ='%s' where student_id=%d", "riya", 7);

			int rowAffected = statement.executeUpdate(query);

			if (rowAffected > 0) {
				System.out.println("data updated successfully");
			} else {
				System.out.println("data not updated");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
