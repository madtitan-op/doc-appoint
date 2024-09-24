package com.hospital.docappoint.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {

//    DATA MEMBERS

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonBackReference("patient-appointment")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference("doctor-appointment")
    private Doctor doctor;

    private LocalDate date;

//    CONSTRUCTORS

    public Appointment() {
    }

    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

//    METHODS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
