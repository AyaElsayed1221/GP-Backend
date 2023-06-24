package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.Services.PrescriptionService;
import com.ayaagroup.demo.entity.prescription.PrescriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescriptions")
@CrossOrigin(origins = "http://localhost:4200")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/{prescriptionId}")
    public PrescriptionEntity findPrescriptionEntityById(@PathVariable(name="prescriptionId")  Integer id){
        return prescriptionService.findPrescriptionEntityById(id);
    }}