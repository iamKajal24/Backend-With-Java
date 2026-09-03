package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class preparedStatementDelete {

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

			String query = "DELETE from students where student_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 2);

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("data deleted successfully");
			} else {
				System.out.println("data not deleted");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
