package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {
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
            connection.setAutoCommit(false);
            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);

            debitPreparedStatement.setDouble(1,100);
            debitPreparedStatement.setInt(2,100);

            creditPreparedStatement.setDouble(1,101);
            creditPreparedStatement.setInt(2,100);

            connection.commit();  // connection.rollback() if fails

//            int affectedRowsD = debitPreparedStatement.executeUpdate();
//            int affectedRowsC = creditPreparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
