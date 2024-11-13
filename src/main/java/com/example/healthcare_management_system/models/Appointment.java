package com.example.healthcare_management_system.models;

import java.sql.*;

import com.example.healthcare_management_system.models.User;
import com.example.healthcare_management_system.databaseConnection;
import com.example.healthcare_management_system.DAO.UserDAO;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Timestamp appointmentDate;
    private String reasonForVisit;
    private String status;

    public Appointment(int patient_id, int doctor_id, Timestamp appointmentDate, String reasonForVisit, String status) {
        this.patientId = patient_id;
        this.doctorId = doctor_id;
        this.appointmentDate = appointmentDate;
        this.reasonForVisit = reasonForVisit;
        this.status = status;
    }

    public Appointment(int id, int patientId, int doctorId, Timestamp appointmentDate, String reasonForVisit, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.reasonForVisit = reasonForVisit;
        this.status = status;
    }

    public int getID() {return this.id;}
    public void setID(int id) {this.id = id;}

    public int getPatientID() {return this.patientId;}
    public void setPatientID(int patient_id) {this.patientId = patient_id;}

    public int getDoctorId() {return this.doctorId;}
    public void setDoctorID(int doctor_id) {this.doctorId = doctor_id;}

    public Timestamp getAppointmentDate() {return this.appointmentDate;}
    public void setAppointmentDate(Timestamp appointmentDate) {this.appointmentDate = appointmentDate;}

    public String getReasonForVisit() {return this.reasonForVisit;}
    public void setReasonForVisit(String reasonForVisit) {this.reasonForVisit = reasonForVisit;}

    public String getStatus() {return this.status;}
    public void setStatus(String status) {this.status = status;}
}
