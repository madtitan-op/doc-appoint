package com.hospital.docappoint.repository;

import com.hospital.docappoint.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    List<Appointment> findAppointmentsByAppointment_date(Date date);
//    List<Appointment> findAppointmentsByPatientName(String pname);
//    List<Appointment> findAppointmentsByDoctorName(String dname);
    List<Appointment> findAppointmentsByDate(LocalDate date);
    List<Appointment> findAppointmentsByDoctor_Firstname(String dname);
    List<Appointment> findAppointmentsByPatient_Firstname(String pname);
}
