package com.ayaagroup.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyDto {

    @JsonIgnore
    private Integer patientId;

    private String bloodPressure;

    private String bloodType;

    private Boolean Diabetes;

    private Boolean heartDisease;

    private Boolean Alcohol;

    private Boolean treatment;

    private Boolean tumors;

    private String patientName;


    private Integer age;
    @JsonIgnore
   private LocalDate dateOfBirth;

    public EmergencyDto(Integer patientId, String bloodPressure, String bloodType, Boolean diabetes, Boolean heartDisease, Boolean alcohol, Boolean treatment, Boolean tumors, String patientName, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.bloodPressure = bloodPressure;
        this.bloodType = bloodType;
        Diabetes = diabetes;
        this.heartDisease = heartDisease;
        Alcohol = alcohol;
        this.treatment = treatment;
        this.tumors = tumors;
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
    }
}
