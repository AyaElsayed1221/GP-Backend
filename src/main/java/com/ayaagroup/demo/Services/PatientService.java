package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.PatientDto;
import com.ayaagroup.demo.dto.scansRequiredDto;
import com.ayaagroup.demo.dto.testRequiredDto;
import com.ayaagroup.demo.entity.prescription.*;
import com.ayaagroup.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private MedicineRepo medRepo;

    @Autowired
    private LabScanRepo lab;

    @Autowired
    private TestRepo testrepo;

    @Autowired
    private PrescriptionRepo preRepo;

    @Autowired
    private TestResultRepo testResultRepo;

    @Autowired
    private ScanResultRepo scanResultRepo;

    @Autowired
    private LabTestRepo labTestRepo;

    /*-------------------------------------------------------*/
    public PatientDto getBasicInfo(Integer id){
        PatientDto patientDto = patientRepo.findPatientById(id);
        return patientDto;
    }

//    public List<Patient> getDiseases(Integer ID){
//        return this.repo.findPatientByPatientID(ID);
//    }
//
//    public List<PatientDiseaseEntity> getPatients(Patient Id){
//        return this.test.findPatientDiseaseEntityByPatientId(Id);
//    }

    /////////////////////////////////////////////////////////////
//    public List<RequiredMedication> findAllByPrescriptionEntities(Integer Id){
//        return this.medRepo.findAllByPrescriptionId(Id);
//    }

    public List<scansRequiredDto> findLabScansByPrescriptionId(Integer Id){
        return this.lab.findLabScansById(Id);
    }

    public List<LabTests> findAllByPreId(Integer Id){
        return this.testrepo.findAllByPreId(Id);
    }

    public List<testRequiredDto> findLabTestByPrescriptionId(Integer id){
        return this.labTestRepo.findLabTestsById(id);
    }

    public TestResults saveTestResults(TestResults testResult){
        return this.testResultRepo.save(testResult);
    }

    public ScanResult saveScanResult(ScanResult scanImage){
        return this.scanResultRepo.save(scanImage);
    }



}
