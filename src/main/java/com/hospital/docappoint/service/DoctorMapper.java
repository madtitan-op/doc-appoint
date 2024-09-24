package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.DoctorDTO;
import com.hospital.docappoint.model.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorMapper {
    public Doctor toDoctor (DoctorDTO dto) {
        return new Doctor(
                dto.firstname(),
                dto.lastname(),
                dto.specialization()
        );
    }

    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getSpecialization()
        );
    }
}
