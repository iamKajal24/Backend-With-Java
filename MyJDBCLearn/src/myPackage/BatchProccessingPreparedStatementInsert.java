package myPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProccessingPreparedStatementInsert {

	public static void main(String[] args) {

		// Driver load
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connection
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kajal", "root", "root");

			System.out.println("connection successfully...");

			String query = String.format("INSERT INTO students "
					+ "(student_id, first_name, last_name, date_of_birth, email, enrollment_date) "
					+ "VALUES (?,?,?,?,?,?)");

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			Scanner scanner = new Scanner(System.in);

			while (true) {

				System.out.println("enter id : ");
				int id = scanner.nextInt();

				System.out.println("enter first name : ");
				String fname = scanner.next();

				System.out.println("enter last name : ");
				String lname = scanner.next();

				System.out.println("enter dob : ");
				String dobIn = scanner.next();
				Date dob = Date.valueOf(dobIn);

				System.out.println("enter your email : ");
				String email = scanner.next();

				System.out.println("enter enrollment date : ");
				String enrollIn = scanner.next();
				Date enrolldate = Date.valueOf(enrollIn);

				preparedStatement.setInt(1, id);

				preparedStatement.setString(2, fname);

				preparedStatement.setString(3, lname);

				preparedStatement.setDate(4, dob);

				preparedStatement.setString(5, email);

				preparedStatement.setDate(6, enrolldate);
				
				preparedStatement.addBatch();

				System.out.println("Enter more data (Y/N) : ");
				String choice = scanner.next();

				if (choice.toUpperCase().equals("N")) {
					break;
				}
			}

			int[] arr = preparedStatement.executeBatch();

			System.out.println("Batch executed successfully.");
			System.out.println("Total queries executed: " + arr.length);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
