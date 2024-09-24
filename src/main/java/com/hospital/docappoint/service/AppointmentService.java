package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.AppointmentDTO;
import com.hospital.docappoint.dto.AppointmentResponseDTO;
import com.hospital.docappoint.model.Appointment;
import com.hospital.docappoint.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    // GET APPOINTMENT
    public AppointmentResponseDTO bookAppointment(AppointmentDTO appointment) {
        Appointment apt = appointmentRepository.save(appointmentMapper.toAppointment(appointment));
        return appointmentMapper.toAppointmentResponseDTO(apt);
    }

    // FIND APPOINTMENT BY ID
    public AppointmentResponseDTO  findAppointmentById(Integer id) {
        Appointment apt = appointmentRepository.findById(id).orElse(new Appointment());
        return appointmentMapper.toAppointmentResponseDTO (apt);
    }

    // FIND APPOINTMENT BY PATIENT
    public List<AppointmentResponseDTO > findAppointmentByPatient(String pname) {
        List<Appointment> apts = appointmentRepository.findAppointmentsByPatient_Firstname(pname);
        List<AppointmentResponseDTO > adto = new ArrayList<>();
        for (Appointment apt : apts) {
            adto.add(appointmentMapper.toAppointmentResponseDTO (apt));
        }
        return adto;
    }

    // FIND APPOINTMENT BY DOCTOR
    public List<AppointmentResponseDTO > findAppointmentByDoctor(String dname) {
        List<Appointment> apts = appointmentRepository.findAppointmentsByDoctor_Firstname(dname);
        List<AppointmentResponseDTO > adto = new ArrayList<>();
        for (Appointment apt : apts) {
            adto.add(appointmentMapper.toAppointmentResponseDTO (apt));
        }
        return adto;
    }

    // FIND APPOINTMENT BY APPOINTMENT_DATE
    public List<AppointmentResponseDTO > findAppointmentByDate(Integer year, Integer month, Integer day) {
        LocalDate date = LocalDate.of(year, month, day);
        List<Appointment> apts = appointmentRepository.findAppointmentsByDate(date);
        List<AppointmentResponseDTO > adto = new ArrayList<>();
        for (Appointment apt : apts) {
            adto.add(appointmentMapper.toAppointmentResponseDTO (apt));
        }
        return adto;
    }

    // FIND ALL APPOINTMENTS
    public List<AppointmentResponseDTO > findAllAppointments() {
        List<Appointment> apts = appointmentRepository.findAll();
        List<AppointmentResponseDTO > adto = new ArrayList<>();
        for (Appointment apt : apts) {
            adto.add(appointmentMapper.toAppointmentResponseDTO (apt));
        }
        return adto;
    }

    // DELETE APPOINTMENT
    public void deleteAppointmentById(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
