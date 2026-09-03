package myPackage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	private static final String URL = "jdbc:mysql://localhost:3306/kajal";

	private static final String username = "root";

	private static final String password = "root";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Program starting....");

		// driver load
		Class.forName("com.mysql.cj.jdbc.Driver");

		// connection
//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/kajal",
//						"root","root");

//   or

		Connection connection = DriverManager.getConnection(URL, username, password);
		System.out.println("connection successfully");

		// create database and retrive data

		Statement statement = connection.createStatement();
		String query = "Select * from students";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int id = resultSet.getInt("student_id");
			String fname = resultSet.getString("first_name");
			String lname = resultSet.getString("last_name");
			Date dob = resultSet.getDate("date_of_birth");
			String email = resultSet.getString("email");
			Date enrollment = resultSet.getDate("enrollment_date");

//			System.out.println("id : " + id);
//			System.out.println("fname : " + fname);
//			System.out.println("lname : "+ lname);
//			System.out.println("dob : " + dob);
//			System.out.println("email : " + email );
//			System.out.println("enrollment : "+ enrollment);

			System.out.println("ID: " + id + " | Name: " + fname + " " + lname + " | DOB: " + dob + " | Email: " + email
					+ " | Enrollment: " + enrollment);
		}
		connection.close();
	}

}
