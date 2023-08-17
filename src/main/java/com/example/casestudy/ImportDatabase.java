package com.example.casestudy;
import java.sql.*;

public class ImportDatabase {
    private static String hostName = "localhost:3306";
    private static String dbName = "Message";
    private static String username = "root";
    private static String password = "Duykhanh123@";
    private static String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public static Connection connection () throws SQLException {
        Connection connection = DriverManager.getConnection(connectionURL, username,password);
        return connection;
    }
    public void addToDatabase(String name, String message) throws SQLException {
        Connection connection = ImportDatabase.connection();

        String query = "INSERT INTO DataMessage (name, message) VALUES  (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,message);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void getData() throws SQLException {
        Connection connection = ImportDatabase.connection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM DataMessage";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getString("message"));
        }
    }
    public void deleteData() throws SQLException {
        Connection connection = ImportDatabase.connection();
        String query = "TRUNCATE TABLE DataMessage";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

}
