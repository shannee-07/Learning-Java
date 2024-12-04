package jdbc;

import java.sql.*;

public class ExecutingSingleQuery {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "D@tabase123";

    public static void executeSelectQueryUsingStatement(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // .next() checks if there is data in resultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void executeInsertQueryUsingStatement(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("row successfully added in table");
            } else {
                System.out.println("row not inserted!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdateQueryUsingStatement(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("Data not updated!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeInsertQueryUsingPreparedStatement(Connection connection, String name, int age) {
//        Using PreparedStatement will avoid compiling the same query again and again. It will just complile once and different values will be passed into it dynamically
        try {
            String query = "INSERT INTO person(name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data not inserted");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void executeSelectQueryUsingPreparedStatement(Connection connection, int personId) {
        try {
            String query = "SELECT * FROM person WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, personId);

            ResultSet resultSet = preparedStatement.executeQuery();
            // .next() checks if there is data in resultSet
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("age"));
            }else{
                System.out.println("Person not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "";

//            query = String.format("INSERT INTO person(name, age) VALUES ('%s', %o)","Bruce Banner",45);
//            executeInsertQueryUsingStatement(connection, query);
//            query = String.format("UPDATE person SET age = %d WHERE id = %d", 1504, 1);
//            executeUpdateQueryUsingStatement(connection, query);
//            Delete query works the same way

//            executeInsertQueryUsingPreparedStatement(connection, "Natasha Romanoff", 40);
//            executeSelectQueryUsingStatement(connection, "select * from person");
            executeSelectQueryUsingPreparedStatement(connection,9);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
