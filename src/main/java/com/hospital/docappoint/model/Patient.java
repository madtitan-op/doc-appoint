package com.hospital.docappoint.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient {

//    DATA MEMBERS

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 20)
    private String firstname;

    @Column(length = 20)
    private String lastname;

    @Column(length = 6)
    private String gender;
    private int age;

    @OneToMany( mappedBy = "patient")
    @JsonManagedReference("patient-appointment")
    private List<Appointment> appointment;

//    CONSTRUCTORS

    public Patient() {
    }

    public Patient(String firstname, String lastname, String gender, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
