package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.PatientDTO;
import com.hospital.docappoint.model.Patient;
import com.hospital.docappoint.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    // ADD A PATIENT
    public PatientDTO admitPatient(PatientDTO dto) {
        Patient patient = patientRepository.save(patientMapper.toPatient(dto));
        return patientMapper.toPatientDTO(patient);
    }

    // FIND A PATIENT BY ID
    public PatientDTO findPatientById(Integer id) {
        Patient patient = patientRepository.findById(id).orElse(new Patient());
        return patientMapper.toPatientDTO(patient);
    }

    // FIND A PATIENT BY THEIR FIRST NAME
    public List<PatientDTO> findPatientByName(String pname) {
        List<Patient> patients = patientRepository.findPatientsByFirstnameContaining(pname);
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(patientMapper.toPatientDTO(patient));
        }
        return patientDTOS;
    }

    // FIND ALL PATIENTS
    public List<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(patientMapper.toPatientDTO(patient));
        }
        return patientDTOS;
    }

    // DELETE A PATIENT
    public void removePatientById(Integer id) {
        patientRepository.deleteById(id);
    }

}
