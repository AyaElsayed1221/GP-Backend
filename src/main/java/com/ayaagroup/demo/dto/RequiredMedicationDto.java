package com.ayaagroup.demo.dto;

import com.ayaagroup.demo.entity.prescription.RequiredMedication;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequiredMedicationDto {

    private String medicineName;

    public static RequiredMedicationDto toDto (RequiredMedication entity){
        return RequiredMedicationDto.builder()
                .medicineName(entity.getMedicineName())
                .build();
    }

}
