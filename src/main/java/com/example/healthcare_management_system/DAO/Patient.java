package com.example.healthcare_management_system.DAO;

import java.sql.Timestamp;

class Patient {
    private int id;
    private String name;
    private String email;
    private int phone;
    private String address;
    private String medical_history;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Patient(String name, String email, int phone, String address, String medical_history) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.medical_history = medical_history;
    }

    public Patient(int id, String name, String email, int phone, String address, String medical_history) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.medical_history = medical_history;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void steAddress(String address) {
        this.address = address;
    }

    public String getMedicalHistory() {
        return this.medical_history;
    }

    public void setMedicalHistory(String medical_history) {
        this.medical_history = medical_history;
    }

}
