package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.medicineDto;
import com.ayaagroup.demo.Services.MedicineService;
import com.ayaagroup.demo.Services.PatientService;

import com.ayaagroup.demo.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/current-medicine/prescriptionId")
    public   List<medicineDto> getCurrentMedicine( Integer id){
        return medicineService.getCurrentMedicine(id);
    }

    @GetMapping("/{patientId}")
    public PatientDto getBasicInfo(@PathVariable(name="patientId") Integer id){
        return patientService.getBasicInfo(id);
    }
}
