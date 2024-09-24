package com.hospital.docappoint.dto;

public record AppointmentDTO(
    Integer patient_id,
    Integer doctor_id,
    Integer day,
    Integer month,
    Integer year
) {
}
