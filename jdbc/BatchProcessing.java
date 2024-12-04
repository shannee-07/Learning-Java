package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessing {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "D@tabase123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);
            String query = "INSERT INTO person(name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            while (true) {
                System.out.println("Enter name of the person");
                String name = sc.next();

                System.out.println("Enter age of the person");
                int age = sc.nextInt();
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.addBatch();
                System.out.println("Enter more data?(Y/N)");
                String input = sc.next();
                if ("N".equalsIgnoreCase(input)) {
                    break;
                }
            }

            int[] rowsAffected = preparedStatement.executeBatch();
            for (int i : rowsAffected) {
                System.out.print(i + " ");
            }


        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
