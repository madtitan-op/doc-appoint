package com.hospital.docappoint.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

//    DATA MEMBERS

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 20)
    private String firstname;

    @Column(length = 20)
    private String lastname;

    private String specialization;

    @OneToMany( mappedBy = "doctor")
    @JsonManagedReference("doctor-appointment")
    private List<Appointment> appointment;

//    CONSTRUCTORS

    public Doctor() {
    }

    public Doctor(String firstname, String lastname, String specialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
    }

//    METHODS

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
