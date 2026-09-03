package myPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProccessingInsert {

    public static void main(String[] args) {

        // Driver load
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connection
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kajal",
                    "root",
                    "root"
            );

            System.out.println("connection successfully...");

            Statement statement = connection.createStatement();

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

                String query = String.format(
                        "INSERT INTO students " +
                        "(student_id, first_name, last_name, date_of_birth, email, enrollment_date) " +
                        "VALUES (%d, '%s', '%s', '%s', '%s', '%s')",
                        id, fname, lname, dob, email, enrolldate
                );

                statement.addBatch(query);

                System.out.println("Enter more data (Y/N) : ");
                String choice = scanner.next();

                if (choice.toUpperCase().equals("N")) {
                    break;
                }
            }

            int[] arr = statement.executeBatch();

            System.out.println("Batch executed successfully.");
            System.out.println("Total queries executed: " + arr.length);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
