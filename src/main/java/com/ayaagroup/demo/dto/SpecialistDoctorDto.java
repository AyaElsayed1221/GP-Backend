package com.ayaagroup.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistDoctorDto {
    private Integer specialistDoctorId;

    private String specialization;

    private String experience;
}
