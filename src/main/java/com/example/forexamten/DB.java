package com.example.forexamten;
import java.sql.*;
public class DB {

    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/mydb?userSSL=false";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "1234";
    public static final String SELECT_QUERY = "SELECT role FROM `users` where login = ? and password = ?";

    public boolean validate (String login, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME,DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        System.out.println(preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            Profile.post = resultSet.getInt(1);
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

}
