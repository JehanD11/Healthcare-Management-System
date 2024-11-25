package com.example.healthcare_management_system.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.healthcare_management_system.utils.databaseConnection;
import com.example.healthcare_management_system.models.User;

public class UserDAO {
    public boolean addUser(User user) throws SQLException{
        String query = "insert into users(username, email, password, role, specialization, phone, address, medical_history) values(?,?,?,?,?,?,?,?)";
        int rowsAffected = 0;
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
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " +e.getMessage());
        }
        return rowsAffected > 0;
    }

    public User getUserById(int id) throws SQLException{
        User userInfo = null;
        try {
            String query = "select * from users where id = ?";
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userInfo = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("specialization"),
                        rs.getInt("phone"),
                        rs.getString("address"),
                        rs.getString("medical_history")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " +e.getMessage());
        }
        return userInfo;
    }

    public boolean updateUser(User user) throws SQLException {
        int rowsAffected = 0;
        try {
            String query = "update user set username = ?, email = ?, password = ?, role = ?, specialization = ?, phone = ?, address = ?, medical_history = ?, updated_at = ? where id = ?";
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
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " +e.getMessage());
        }
        return rowsAffected > 0;
    }

    public boolean deleteUser(int id) throws SQLException {
        int rowsAffected = 0;
        try {
            Connection connection = databaseConnection.getConnection();
            String query = "delete from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        }
        return rowsAffected > 0;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<User>();
        try {
            String query = "select * from users";
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("specialization"),
                        rs.getInt("phone"),
                        rs.getString("address"),
                        rs.getString("medical_history")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        }
        return users;
    }

    public boolean getUserByEmail(String email) throws SQLException {
        boolean emailExists = false;
        String query = "select * from users where email = ?";
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {emailExists = true;}
        } catch (SQLException e) {System.out.println(e.getErrorCode() + " " + e.getMessage());}
        return emailExists;
    }

    public List<User> getDoctors() throws SQLException {
        List<User> doctors = new ArrayList<>();
        String query = "select * from users where role = 'doctor'";
        User doctor = null;

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                doctor = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("specialization"),
                        rs.getInt("phone"),
                        rs.getString("address"),
                        rs.getString("medical_history")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        }
        return doctors;
    }

    public List<User> getPatients() throws SQLException {
        List<User> patients = new ArrayList<>();
        String query = "select * from users where role = 'patient'";
        User patient = null;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                patient = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("specialization"),
                        rs.getInt("phone"),
                        rs.getString("address"),
                        rs.getString("medical_history")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
        }
        return patients;
    }
}
