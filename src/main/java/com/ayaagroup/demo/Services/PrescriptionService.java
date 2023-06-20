package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.entity.prescription.PrescriptionEntity;
import com.ayaagroup.demo.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepo prescriptionRepo;

    public PrescriptionEntity findPrescriptionEntityById(Integer id){
        PrescriptionEntity prescriptionEntity=prescriptionRepo.findPrescriptionEntityById(id);
        return prescriptionEntity;
    }}