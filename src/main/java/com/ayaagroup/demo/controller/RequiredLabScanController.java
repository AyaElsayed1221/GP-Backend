package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.scansRequiredDto;
import com.ayaagroup.demo.dto.testRequiredDto;
import com.ayaagroup.demo.Services.BasicInfoService;
import com.ayaagroup.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab")
@CrossOrigin(origins = "http://localhost:4200")
public class RequiredLabScanController {

    @Autowired
    private PatientService patientDao;

    @Autowired
    private BasicInfoService basicInfoService;


    @GetMapping("/scanRequired")
    public List<scansRequiredDto> getScan(@RequestParam Integer id){
        return basicInfoService.getScanRequired(id);
    }


    @GetMapping("/testRequired")
    public List<testRequiredDto> getTest(@RequestParam Integer id){
        return basicInfoService.getTestRequired(id);
    }

    @GetMapping(path = "/prescription/LabSection/RequiresTests")
    public List<testRequiredDto> findLabTestsByPrescriptionId(@RequestParam Integer id){
        return this.patientDao.findLabTestByPrescriptionId(id);
    }
}









//    @GetMapping("/{medicineId}")
//    public List<PharmacistMedicinesDto> getPharmacistMedicine(@PathVariable(name="medicineId") Integer id){
//        return medicineService.getPharmacistMedicine(id);
//    }