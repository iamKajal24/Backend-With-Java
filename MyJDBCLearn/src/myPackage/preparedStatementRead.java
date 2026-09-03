package myPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class preparedStatementRead {

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

			String query = "select * from students where student_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 7);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("student_id");
				String fname = resultSet.getString("first_name");
				String lname = resultSet.getString("last_name");
				Date dob = resultSet.getDate("date_of_birth");
				String email = resultSet.getString("email");
				Date enrollment = resultSet.getDate("enrollment_date");
				System.out.println("ID: " + id + " | Fname: " + fname + " | Lname: " + lname + " | DOB: " + dob
						+ " | Email: " + email + " | Enrollment: " + enrollment);

				System.out.println("data successfully read");
			} else {
				System.out.println("data not found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
