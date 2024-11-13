package com.example.healthcare_management_system.DAO;

import com.example.healthcare_management_system.models.Appointment;
import com.example.healthcare_management_system.databaseConnection;
import com.example.healthcare_management_system.models.User;
import java.sql.*;
import java.util.*;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appointment) throws SQLException {
        String query = "insert into appointment(patient_id, doctor_id, appointment_date, reason_for_visit, status) values (?,?,?,?,?)";
        int rowsAffected = 0;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, appointment.getPatientID());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setTimestamp(3, appointment.getAppointmentDate());
            preparedStatement.setString(4, appointment.getReasonForVisit());
            preparedStatement.setString(5, appointment.getStatus());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected > 0;
    }

    public Appointment getAppointmentById(int id) throws SQLException {
        String query = "select * from appointment where appointment_id = ?";
        Appointment appointment = null;
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getTimestamp("appointmentDate"),
                        rs.getString("reasonForVisit"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appointment;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        String query = "select * form appointment";
        List<Appointment> appointments = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getTimestamp("appointmentDate"),
                        rs.getString("reasonForVisit"),
                        rs.getString("status")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appointments;
    }

}
