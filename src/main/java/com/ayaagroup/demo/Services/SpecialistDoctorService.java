package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.SpecialistDoctorDto;
import com.ayaagroup.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistDoctorService {
    @Autowired
    private SpecialistDoctorRepo specialistDoctorRepo;



    /*-------------------------------------------------------*/
//    public PatientDto getBasicInfo(Integer id){
//        PatientDto patientDto = patientRepo.findPatientById(id);
//        return patientDto;
//    }

//

    public SpecialistDoctorDto getSpecialistDoctorInfo(Integer id) {
        SpecialistDoctorDto specialistDoctorDto = specialistDoctorRepo.findSpecialistDoctorById(id);
        return specialistDoctorDto;
    }
}
