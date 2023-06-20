package com.ayaagroup.demo.controller;


import com.ayaagroup.demo.dto.PharmacistMedicinesDto;
import com.ayaagroup.demo.Services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pharmacist")
public class pharmacistController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/{medicineId}")
    public List<PharmacistMedicinesDto> getPharmacistMedicine(@PathVariable(name="medicineId") Integer id){
        return medicineService.getPharmacistMedicine(id);
    }
}
