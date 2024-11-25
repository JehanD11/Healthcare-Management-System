package com.example.healthcare_management_system.DAO;

import java.sql.*;
import java.util.*;

import com.example.healthcare_management_system.models.*;
import com.example.healthcare_management_system.utils.databaseConnection;

public class PrescriptionDAO {
    public boolean addPrescription(Prescription prescription) throws SQLException{
        String query = "insert into prescription values(?,?,?,?)";
        int rowsAffected = 0;

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, prescription.getPatientId());
            preparedStatement.setInt(2, prescription.getDoctorId());
            preparedStatement.setString(3, prescription.getMedication());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected > 0;
    }

    public Prescription getPrescriptionById(int id) throws SQLException {
        Prescription prescription = null;
        String query=  "select * from prescription where id = ?";

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               prescription = new Prescription (
                       rs.getInt("id"),
                       rs.getInt("patient_id"),
                       rs.getInt("doctor_id"),
                       rs.getString("medication"),
                       rs.getString("dosage"),
                       rs.getTimestamp("issued_date")
               );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prescription;
    }

    public boolean updatePrescription(Prescription prescription) throws SQLException {
        String query = "update prescription set patient_id = ?, doctor_id = ?, medication = ?, dosage = ?, issued_date = ? where id = ?";
        int rowsAffected = 0;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, prescription.getPatientId());
            preparedStatement.setInt(2, prescription.getDoctorId());
            preparedStatement.setString(3, prescription.getMedication());
            preparedStatement.setString(4, prescription.getDosage());
            preparedStatement.setTimestamp(5, prescription.getIssuedDate());
            preparedStatement.setInt(6, prescription.getId());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected > 0;
    }

    public boolean deletePrescription(int id) throws SQLException {
        String query = "delete from prescription where id = ?";
        int rowsAffected = 0;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected > 0;
    }

    public List<Prescription> getAllPrescription() throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        String query = "select * from prescription";
        Prescription prescription = null;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                prescription = new Prescription (
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("medication"),
                        rs.getString("dosage"),
                        rs.getTimestamp("issued_date")
                );
                prescriptions.add(prescription);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prescriptions;
    }

    public Prescription getPrescriptionByPatientId(int patient_id) throws SQLException {
        Prescription prescription = null;
        String query = "select * from prescription where patient_id = ?";

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, patient_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                prescription = new Prescription(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("medication"),
                        rs.getString("dosage"),
                        rs.getTimestamp("issued_date")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prescription;
    }

    public Prescription getPrescriptionByDoctorId(int doctor_id) throws SQLException {
        Prescription prescription = null;
        String query = "select * from prescription where doctor_id = ?";

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                prescription = new Prescription (
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("medication"),
                        rs.getString("dosage"),
                        rs.getTimestamp("issued_date")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prescription;
    }
}
