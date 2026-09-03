package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class preparedStatementInsert {

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

			String query = "INSERT INTO students(student_id,first_name,last_name,date_of_birth,email,enrollment_date) values (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 7);

			preparedStatement.setString(2, "Shubham");

			preparedStatement.setString(3, "Chauhan");

			preparedStatement.setDate(4, java.sql.Date.valueOf("1999-09-13"));

			preparedStatement.setString(5, "shubhamchauhan@gmail.com");

			preparedStatement.setDate(6, java.sql.Date.valueOf("2026-08-25"));

			int rowAffected = preparedStatement.executeUpdate();

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
