package com.hospital.docappoint.dto;

public record AppointmentResponseDTO(
        Integer patient_id,
        String patient_name,
        Integer doctor_id,
        String doctor_name,
        Integer day,
        Integer month,
        Integer year
) {
}
