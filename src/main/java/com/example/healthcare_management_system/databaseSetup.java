package com.example.healthcare_management_system;

import java.sql.*;

public class databaseSetup {
    private static final String url = "jdbc:mysql://localhost:3306/healthcare_management_system";
    private static final String username = "root";
    private static final String password = "root";

    private static void handleSqlException(SQLException e) {
        int errorCode = e.getErrorCode();
        String sqlState = e.getSQLState();
        String errorMessage = e.getMessage();

        System.out.println("Error code : " + errorCode);
        System.out.println("SQL State : " + sqlState);
        System.out.println("Error Message : " + errorMessage);
    }

    public static void main(String[] args) throws SQLException {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String createUserTable = """ 
                    create table if not exists User(
                        id int auto_increment primary key,
                        username varchar(50) not null unique,
                        email varchar(100) not null unique,
                        password varchar(100) not null,
                        role enum('Patient', 'Doctor') not null,
                        specialization varchar(100),
                        phone varchar(15),
                        address varchar(255),
                        medical_history text,
                        created_at timestamp default current_timestamp,
                        updated_at timestamp default current_timestamp on update current_timestamp
                    );
                    """;

            String createAppointmentTable = """
                    create table if not exists Appointment(
                        id int auto_increment primary key,
                        patient_id int,
                        doctor_id int,
                        appointment_date datetime not null,
                        reason_for_visit text,
                        status enum('Scheduled', 'Completed', 'Canceled') not null,
                        foreign key (patient_id) references User(id),
                        foreign key (doctor_id) references User(id)
                    );
                    """;

            String createPrescriptionTable = """
                    create table if not exists Prescription(
                        id int auto_increment primary key,
                        patient_id int,
                        doctor_id int,
                        medication text not null,
                        dosage text not null,
                        issued_date date not null,
                        foreign key (patient_id) references User(id),
                        foreign key (doctor_id) references User(id)
                    );
                    """;

            //Executing the statements to create the tables
            statement.executeUpdate(createUserTable);
            System.out.println("User table created");
            statement.executeUpdate(createAppointmentTable);
            System.out.println("Appointment table created");
            statement.executeUpdate(createPrescriptionTable);
            System.out.println("Prescription table created");

        } catch (SQLException e) {
            handleSqlException(e);
        }
    }
}
