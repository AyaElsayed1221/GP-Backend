package com.ayaagroup.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRelativeDto {

    private String relativeName;

    private String relationType;

    private String relativeEmail;

    private String relativePhone;
}
