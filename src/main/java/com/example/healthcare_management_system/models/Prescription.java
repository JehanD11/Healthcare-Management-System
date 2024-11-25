package com.example.healthcare_management_system.models;

import java.sql.*;

public class Prescription {
    private int id;
    private int patientId;
    private int doctorId;
    private String medication;
    private String dosage;
    private Timestamp issuedDate;

    public Prescription(int patientId, int doctorId, String medication, String dosage, Timestamp issuedDate) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medication = medication;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
    }

    public Prescription(int id, int patientId, int doctorId, String medication, String dosage, Timestamp issuedDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medication = medication;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
    }

    public int getId() {return this.id;}

    public int getPatientId() {return this.patientId;}
    public void setPatientId(int patientId) {this.patientId = patientId;}

    public int getDoctorId() {return this.doctorId;}
    public void setDoctorId(int doctorId) {this.doctorId = doctorId;}

    public String getMedication() {return this.medication;}
    public void setMedication(String medication) {this.medication = medication;}

    public String getDosage() {return this.dosage;}
    public void setDosage(String dosage) {this.dosage = dosage;}

    public Timestamp getIssuedDate() {return this.issuedDate;}
    public void setIssuedDate(Timestamp issuedDate) {this.issuedDate = issuedDate;}
}
