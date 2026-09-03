package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertData {

	public static void main(String[] args) {

//		driver load
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

			// insert query

			int id = 7;
			String fname = "Kajal";
			String lname = "sharma";
			String dob = "2001-05-10";
			String email = "kajalsharma@gmail.com";
			String enrollment = "2024-07-15";

			String query = String.format(
					"INSERT INTO students (student_id, first_name, last_name, date_of_birth, email, enrollment_date) "
							+ "VALUES (%d, '%s', '%s', '%s', '%s', '%s')",
					id, fname, lname, dob, email, enrollment);

			int rowAffected = statement.executeUpdate(query);

			if (rowAffected > 0) {
				System.out.println("data inserted successfully");
			} else {
				System.out.println("data not inserted");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
