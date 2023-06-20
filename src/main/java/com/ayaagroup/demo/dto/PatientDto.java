package com.ayaagroup.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {



    private String bloodPressure;

    private String bloodType;

    private Boolean Diabietes;

    private Boolean heartDisease;

    private Boolean Alcohol;

    private Boolean treatment;

    private Boolean tumors;
    //ignore id///////////////////////////
    @JsonIgnore
    private Integer patientId;
}
