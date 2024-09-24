package com.hospital.docappoint.controller;

import com.hospital.docappoint.dto.AppointmentDTO;
import com.hospital.docappoint.dto.AppointmentResponseDTO;
import com.hospital.docappoint.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // GET A APPOINTMENT
    @PostMapping("/appointment")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public AppointmentResponseDTO getAppoint(@RequestBody AppointmentDTO appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    // FIND APPOINTMENT BY ID
    @GetMapping("/appointment/{id}")
    public AppointmentResponseDTO  findAppoint(@PathVariable("id") Integer id) {
        return appointmentService.findAppointmentById(id);
    }

    // FIND APPOINTMENT BY PATIENT
    @GetMapping("/appointment/patient-{name}")
    public List<AppointmentResponseDTO > findAppointByPatient(@PathVariable("name") String name) {
        return appointmentService.findAppointmentByPatient(name);
    }

    // FIND APPOINTMENT BY DOCTOR
    @GetMapping("/appointment/doctor-{name}")
    public List<AppointmentResponseDTO > findAppointByDoctor(@PathVariable("name") String name) {
        return appointmentService.findAppointmentByDoctor(name);
    }

    // FIND APPOINTMENT BY DATE
    @GetMapping("/appointment/{year}-{month}-{day}")
    public List<AppointmentResponseDTO > findAppointByDate(
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month,
            @PathVariable("day") Integer day
    ) {
        return appointmentService.findAppointmentByDate(year, month, day);
    }

    // FIND ALL APPOINTMENTS
    @GetMapping("/appointment")
    public List<AppointmentResponseDTO > findAllAppoint() {
        return appointmentService.findAllAppointments();
    }

    // DELETE APPOINTMENT
    @DeleteMapping("/appointment/{id}")
    public void deleteAppoint(@PathVariable("id") Integer id) {
        appointmentService.deleteAppointmentById(id);
    }
}
