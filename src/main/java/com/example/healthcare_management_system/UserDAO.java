package com.example.healthcare_management_system;

import java.sql.*;

import com.example.healthcare_management_system.User;

public class UserDAO {
    public void addUser(User user) throws SQLException{
        String query = "insert into users(username, email, password, role, specialization, phone, address, medical_history) values(?,?,?,?,?,?,?,?)";
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getSpecialization());
            preparedStatement.setInt(6, user.getPhone());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getMedical_history());
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " +e.getMessage());
        }
    }
}
