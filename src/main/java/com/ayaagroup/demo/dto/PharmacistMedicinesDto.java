package com.ayaagroup.demo.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PharmacistMedicinesDto {
    private Integer medicineId;

    private String medicineName;

    private Integer medicineDoses;

    private Integer Period;



}
