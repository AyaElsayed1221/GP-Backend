package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.Services.PatientService;
import com.ayaagroup.demo.entity.prescription.ScanResult;
import com.ayaagroup.demo.entity.prescription.TestResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UploadController {

    @Autowired
    private PatientService patientDao;

    @PostMapping(path = "/prescription/LabSection/RequiredScans/save-scans")
    public ScanResult saveScanResult(@RequestBody ScanResult scanImage){
        return this.patientDao.saveScanResult(scanImage);
    }

    @PostMapping(path = "/prescription/LabSection/RequiredTests/save-testResult")
    public TestResults saveTestResult(@RequestBody TestResults testResult) {
        return this.patientDao.saveTestResults(testResult);
    }
}
