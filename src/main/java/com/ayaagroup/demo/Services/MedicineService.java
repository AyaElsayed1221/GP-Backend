package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.PharmacistMedicinesDto;
import com.ayaagroup.demo.dto.medicineDto;

import com.ayaagroup.demo.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;



    public List<PharmacistMedicinesDto> getPharmacistMedicine(Integer id){
        List<PharmacistMedicinesDto>  pharmacistMedicinesDto = medicineRepo.findRequiredMedicationById(id);
        return pharmacistMedicinesDto;
    }

    public List<medicineDto> getCurrentMedicine(Integer id){
        List<medicineDto> medicineDto = medicineRepo.findRequiredMedicationsById(id);
        return medicineDto;
    }

}
