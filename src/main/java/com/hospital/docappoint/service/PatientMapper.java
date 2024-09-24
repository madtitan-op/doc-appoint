package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.PatientDTO;
import com.hospital.docappoint.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {
    public Patient toPatient (PatientDTO dto) {
        return new Patient(
                dto.firstname(),
                dto.lastname(),
                dto.gender(),
                dto.age()
        );
    }

    public PatientDTO toPatientDTO (Patient patient) {
        return new PatientDTO(
                patient.getFirstname(),
                patient.getLastname(),
                patient.getGender(),
                patient.getAge()
        );
    }
}
