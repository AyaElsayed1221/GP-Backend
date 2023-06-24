package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.Services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergency")
@CrossOrigin(origins = "http://localhost:4200")
public class EmergencyController {
    @Autowired
    private EmergencyService emergencyService;


    @GetMapping("/emergency-Section-page")
    public List<Object> getAllEmergencyView(@RequestParam Integer id) {
        return this.emergencyService.getAllEmergencyView(id);
    }

}







//    @GetMapping("/{patientId}")
//    public EmergencyDto getEmergencyView(@PathVariable(name="patientId") Integer id) {
//        return emergencyService.getpatientWithUserId(id);
//    }
//
//    @GetMapping("/all-medicins")
//    public List<RequiredMedicationDto> getAllnamesOfRequiredMedicins(@RequestParam Integer id) {
//        return this.emergencyService.getCurrentMedicineV2(id);
//    }

//    @GetMapping("/dept/employees/inner")
//    public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesInnerJoin() {
//        return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
//    }
//    @GetMapping("/{medicineId}")
//    public List<PharmacistMedicinesDto> getPharmacistMedicine(@PathVariable(name="medicineId") Integer id){
//        return medicineService.getPharmacistMedicine(id);
//    }