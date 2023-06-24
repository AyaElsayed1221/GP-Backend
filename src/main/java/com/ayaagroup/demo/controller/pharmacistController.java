package com.ayaagroup.demo.controller;


import com.ayaagroup.demo.dto.PharmacistMedicinesDto;
import com.ayaagroup.demo.Services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacist")
@CrossOrigin(origins = "http://localhost:4200")
public class pharmacistController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/{medicineId}")
    public List<PharmacistMedicinesDto> getPharmacistMedicine(@PathVariable(name="medicineId") Integer id){
        return medicineService.getPharmacistMedicine(id);
    }
}
