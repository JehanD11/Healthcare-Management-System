package com.example.healthcare_management_system.models;

import java.sql.Timestamp;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String specialization;
    private int phone;
    private String address;
    private String medical_history;
    private Timestamp created_at;
    private Timestamp updated_at;

    public User(String username, String password, String email, String role, String specialization, int phone, String address , String medical_history) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.specialization = specialization;
        this.phone = phone;
        this.address = address;
        this.medical_history = medical_history;
    }

    public void setId(int id) {this.id = id;}

    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword(){return this.password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return this.email;};
    public void setEmail(String email) {this.email = email;}

    public String getRole() {return this.role;}
    public void setRole(String role) {this.role = role;}

    public String getSpecialization() {return this.specialization;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}

    public int getPhone() {return this.phone;}
    public void setPhone(int phone) {this.phone = phone;}

    public String getAddress() {return this.address;}
    public void setAddress(String address) {this.address = address;}

    public String getMedical_history() {return this.medical_history;}
    public void setMedical_history(String medical_history) {this.medical_history = medical_history;}
}
