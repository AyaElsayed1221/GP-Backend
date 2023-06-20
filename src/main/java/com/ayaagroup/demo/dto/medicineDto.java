package com.ayaagroup.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class medicineDto {



    private String medicineName;

    private Integer medicineDoses;

    private Integer Period;


    private Date startDate;




}
