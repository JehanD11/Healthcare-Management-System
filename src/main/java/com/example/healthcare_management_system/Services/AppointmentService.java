package com.example.healthcare_management_system.Services;

import com.example.healthcare_management_system.DAO.*;
import com.example.healthcare_management_system.models.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService() {this.appointmentDAO = new AppointmentDAO();}

    public boolean addAppointment(Appointment appointment) throws SQLException {return appointmentDAO.addAppointment(appointment);}

    public Appointment getAppointmentById(int id) throws SQLException {return appointmentDAO.getAppointmentById(id);}

    public boolean updateAppointment(Appointment appointment) throws SQLException {return appointmentDAO.updateAppointment(appointment);}

    public boolean deleteAppointment(int id) throws SQLException {return appointmentDAO.deleteAppointment(id);}

    public List<Appointment> getAppointmentByPatientId(int id) throws SQLException {return appointmentDAO.getAppointmentsByPatientId(id);}

    public List<Appointment> getPendingAppointmentsByDoctorId(int id) throws SQLException {return appointmentDAO.getAllPendingAppointmentsByDoctorId(id);}

    public List<Appointment> getAllAppointments() throws SQLException {return appointmentDAO.getAllAppointments();}
}
