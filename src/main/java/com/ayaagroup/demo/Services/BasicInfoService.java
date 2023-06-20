package com.ayaagroup.demo.Services;


import com.ayaagroup.demo.dto.scansRequiredDto;
import com.ayaagroup.demo.dto.testRequiredDto;

import com.ayaagroup.demo.repository.LabScanRepo;
import com.ayaagroup.demo.repository.LabTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInfoService {
//        @Autowired
//    private PatientRepo patientRepo;
//
//    @Autowired
//    private PatientDiseaseRepo patientDiseaseRepo;

        @Autowired
        private LabScanRepo labScanRepo;

        @Autowired
        private LabTestRepo labTestRepo;

    //    public List<PatientDiseaseEntity> getPatients(Patient Id){
//        return this.test.findPatientDiseaseEntityByPatientId(Id);
//    }
//public BasicInfoDto getBasicInfo(Integer id){
//    Optional<PatientDiseaseEntity> patient = this.patientDiseaseRepo.findById(id);
//    if(patient.isPresent())
//        return BasicInfoDto.toDto(patient.get());
//    else
//        return null;
//}

    //    public List<LabTests> findLabTestByPrescriptionId(Integer id){
//        return this.labTestRepo.findLabTestsByPreId(id);
//    }

//    public testRequiredDto getTest(Integer id) {
//        Optional<LabTests> test = this.labTestRepo.findLabTestsByPreId(id);
//        if (test.isPresent())
//               return testRequiredDto.toDto(test.get());
//            else
//                return null;
//
//    }
    public List<scansRequiredDto> getScanRequired(Integer id){
        List<scansRequiredDto>  scansRequiredDto = labScanRepo.findLabScansById(id);
        return scansRequiredDto;
    }



    public List<testRequiredDto> getTestRequired(Integer id){
        List<testRequiredDto>  testsRequiredDto = labTestRepo.findLabTestsById(id);
        return testsRequiredDto;
    }

    //    public List<LabScans> findLabScansByPrescriptionId(Integer Id){
//        return this.lab.findAllByPreId(Id);
//    }
//
//    public List<PharmacistMedicinesDto> getPharmacistMedicine(Integer id){
//        List<PharmacistMedicinesDto>  pharmacistMedicinesDto = medicineRepo.findRequiredMedicationById(id);
//        return pharmacistMedicinesDto;
//    }


}