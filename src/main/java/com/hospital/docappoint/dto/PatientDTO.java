package com.hospital.docappoint.dto;

public record PatientDTO(
        String firstname,
        String lastname,
        String gender,
        Integer age
) {
}
