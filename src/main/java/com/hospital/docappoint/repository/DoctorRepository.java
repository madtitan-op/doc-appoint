package com.hospital.docappoint.repository;

import com.hospital.docappoint.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findDoctorsByFirstnameContaining (String firstname);
    List<Doctor> findDoctorsBySpecialization (String specialization);
}
