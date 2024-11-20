package com.example.healthcare_management_system.Services;

import com.example.healthcare_management_system.DAO.*;
import com.example.healthcare_management_system.models.*;
import java.sql.*;
import java.util.*;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean addUser(User user) throws SQLException {
        if (userDAO.getUserByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already registered!");
        }
        return userDAO.addUser(user);
    }

    public User getUserById(int id) throws SQLException {
        return userDAO.getUserById(id);
    }

    public boolean updateUser(User user) throws SQLException {
       return userDAO.updateUser(user);
    }

    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public boolean isEmailRegistered(String email) throws SQLException {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getAllDoctors() throws SQLException {
        return userDAO.getDoctors();
    }

    public List<User> gerAllPatients() throws SQLException {

    }
}
