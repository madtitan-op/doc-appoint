package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.AppointmentDTO;
import com.hospital.docappoint.dto.AppointmentResponseDTO;
import com.hospital.docappoint.model.Appointment;
import com.hospital.docappoint.model.Doctor;
import com.hospital.docappoint.model.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentDTO dto) {
        Patient patient = new Patient();
        patient.setId(dto.patient_id());

        Doctor doctor = new Doctor();
        doctor.setId(dto.doctor_id());

        LocalDate date = LocalDate.of(dto.year(), dto.month(), dto.day());

        return new Appointment(
                patient,
                doctor,
                date
        );
    }

    public AppointmentResponseDTO toAppointmentResponseDTO (Appointment appointment) {
        return new AppointmentResponseDTO(
                appointment.getPatient().getId(),
                appointment.getPatient().getFirstname() + " " + appointment.getPatient().getLastname(),
                appointment.getDoctor().getId(),
                appointment.getDoctor().getFirstname() + " " + appointment.getDoctor().getLastname(),
                appointment.getDate().getDayOfMonth(),
                appointment.getDate().getMonthValue(),
                appointment.getDate().getYear()
        );
    }
}
