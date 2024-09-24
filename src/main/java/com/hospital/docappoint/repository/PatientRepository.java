package com.hospital.docappoint.repository;

import com.hospital.docappoint.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findPatientsByFirstnameContaining (String firstname);
}
