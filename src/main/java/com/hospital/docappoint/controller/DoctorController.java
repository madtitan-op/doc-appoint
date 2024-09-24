package com.hospital.docappoint.controller;

import com.hospital.docappoint.dto.DoctorDTO;
import com.hospital.docappoint.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // REGISTER A DOCTOR
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/doctor")
    public DoctorDTO addDoctor(@RequestBody DoctorDTO doctor) {
        return doctorService.registerDoctor(doctor);
    }

    // FIND A DOCTOR BY ID
    @GetMapping("/doctor/{id}")
    public DoctorDTO findDoctor(@PathVariable("id") Integer id) {
        return doctorService.findDoctorById(id);
    }

    // FIND A DOCTOR BY THEIR NAME
    @GetMapping("/doctor/search/{name}")
    public List<DoctorDTO> findDoctorByName(@PathVariable("name") String name) {
        return doctorService.findDoctorByFirstname(name);
    }

    // FIND A DOCTOR BY SPECIALIZATION
    @GetMapping("/doctor/specialization-{specialization}")
    public List<DoctorDTO> findDocBySpec(@PathVariable("specialization") String spec) {
        return doctorService.findDoctorBySpecialization(spec);
    }

    // FIND ALL DOCTORS
    @GetMapping("/doctor")
    public List<DoctorDTO> findAll() {
        return doctorService.findAllDoctors();
    }

    // REMOVE DOCTOR
    @DeleteMapping("/doctor/{id}")
    public void delete(@PathVariable("id") Integer id) {
        doctorService.removeDoctorById(id);
    }
}
