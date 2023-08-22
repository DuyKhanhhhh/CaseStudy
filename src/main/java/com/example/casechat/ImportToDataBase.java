package com.example.casechat;
import java.sql.*;
public class ImportToDataBase {
    private static String hostName = "localhost:3306";
    private static String dbName = "Message";
    private static String userName = "root";
    private static String password = "Duykhanh123@";
    private static String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public static Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionURL,userName,password);
        return connection;
    }
    public void addDatabase(String name, String message) throws SQLException {
        Connection connection = ImportToDataBase.connection();
        String query = "INSERT INTO DataMessage (name, message) VALUES  (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, message);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
    public StringBuilder ReadMessageToDatabase() throws SQLException {
        Connection connection = ImportToDataBase.connection();
        String query = "SELECT * FROM DataMessage";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        StringBuilder stringBuilder = new StringBuilder();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String message = resultSet.getString("Message");
            stringBuilder.append(name + ": " + message + "\n");
        }
        return stringBuilder;
    }
    public void deleteData() throws SQLException {
        Connection connection = ImportToDataBase.connection();
        String query = "TRUNCATE TABLE DataMessage";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

}
