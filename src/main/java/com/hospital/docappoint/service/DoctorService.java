package com.hospital.docappoint.service;

import com.hospital.docappoint.dto.DoctorDTO;
import com.hospital.docappoint.model.Doctor;
import com.hospital.docappoint.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    // ADD DOCTORS
    public DoctorDTO registerDoctor(DoctorDTO dto) {
        Doctor doctor = doctorRepository.save(doctorMapper.toDoctor(dto));
        return doctorMapper.toDoctorDTO(doctor);
    }

    // FIND A DOCTOR BY THEIR ID
    public DoctorDTO findDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElse(new Doctor());
        return doctorMapper.toDoctorDTO(doctor);
    }

    // FIND A DOCTOR BY THEIR FIRSTNAME
    public List<DoctorDTO> findDoctorByFirstname(String dname) {
        List<Doctor> doctors = doctorRepository.findDoctorsByFirstnameContaining(dname);
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOS.add(doctorMapper.toDoctorDTO(doctor));
        }
        return doctorDTOS;
    }

    // FIND DOCTORS BY THEIR SPECIALIZATION
    public List<DoctorDTO> findDoctorBySpecialization(String specialization) {
        List<Doctor> doctors = doctorRepository.findDoctorsBySpecialization(specialization);
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOS.add(doctorMapper.toDoctorDTO(doctor));
        }
        return doctorDTOS;
    }

    // FIND ALL DOCTORS
    public List<DoctorDTO> findAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOS.add(doctorMapper.toDoctorDTO(doctor));
        }
        return doctorDTOS;
    }

    // DELETE DOCTORS
    public void removeDoctorById(Integer id) {
        doctorRepository.deleteById(id);
    }
}
