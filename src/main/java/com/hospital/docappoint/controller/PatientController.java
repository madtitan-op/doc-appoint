package com.hospital.docappoint.controller;

import com.hospital.docappoint.dto.PatientDTO;
import com.hospital.docappoint.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // ADMIT A PATIENT
//    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/patient")
    public PatientDTO addPatient(@RequestBody PatientDTO patient) {
        return patientService.admitPatient(patient);
    }

    // FIND A PATIENT BY ID
    @GetMapping("/patient/{id}")
    public PatientDTO findPatient(@PathVariable("id") Integer id) {
        return patientService.findPatientById(id);
    }

    // FIND A PATIENT BY THEIR NAME
    @GetMapping("/patient/search/{name}")
    public List<PatientDTO> findPatientByName(@PathVariable("name") String name) {
        return patientService.findPatientByName(name);
    }

    // FIND ALL PATIENTS
    @GetMapping("/patient")
    public List<PatientDTO> findAll() {
        return patientService.findAllPatients();
    }

    // REMOVE PATIENT
    @DeleteMapping("/patient/{id}")
    public void delete(@PathVariable("id") Integer id) {
        patientService.removePatientById(id);
    }

}
