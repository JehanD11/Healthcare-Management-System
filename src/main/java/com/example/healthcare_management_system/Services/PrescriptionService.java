package com.example.healthcare_management_system.Services;

import com.example.healthcare_management_system.DAO.*;
import com.example.healthcare_management_system.models.*;
import java.util.*;
import java.sql.*;

public class PrescriptionService {
    private PrescriptionDAO prescriptionDAO;

    public boolean addPrescription(Prescription prescription) throws SQLException {return prescriptionDAO.addPrescription(prescription);}

    public Prescription getPrescriptionById(int id) throws SQLException {return prescriptionDAO.getPrescriptionById(id);}

    public boolean updatePrescription(Prescription prescription) throws SQLException {return prescriptionDAO.updatePrescription(prescription);}

    public boolean deletePrescription(int id) throws SQLException {return prescriptionDAO.deletePrescription(id);}

    public List<Prescription> getAllPrescription() throws SQLException {return prescriptionDAO.getAllPrescription();}

    public Prescription getPrescriptionByPatientId(int id) throws SQLException {return prescriptionDAO.getPrescriptionByPatientId(id);}

    public Prescription getPrescriptionByDoctorId(int id) throws SQLException {return prescriptionDAO.getPrescriptionByDoctorId(id);}
}
