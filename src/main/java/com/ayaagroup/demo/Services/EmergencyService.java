package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.EmergencyDto;
import com.ayaagroup.demo.dto.PatientRelativeDto;
import com.ayaagroup.demo.dto.RequiredMedicationDto;
import com.ayaagroup.demo.repository.MedicineRepo;
import com.ayaagroup.demo.repository.PatientRelativeRepo;
import com.ayaagroup.demo.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    private MedicineRepo medicineRepo;

@Autowired
    PatientRelativeRepo patientRelativeRepo;


    public List<PatientRelativeDto> getPatientRelatives(Integer id){
        List<PatientRelativeDto> patientRelativeDto = patientRelativeRepo.findPatientRelativeByPatientId(id);
        return patientRelativeDto;
    }


    public EmergencyDto getpatientWithUserId(Integer id){
        EmergencyDto emergencyDto = patientRepo.fetchEmergencyDataInnerJoin(id);
        Period age = Period.between(emergencyDto.getDateOfBirth(), LocalDate.now());
        emergencyDto.setAge(age.getYears());

        return emergencyDto;
    }

    public List<RequiredMedicationDto> getCurrentMedicineV2(Integer id){
        List<RequiredMedicationDto> medicineDto = medicineRepo.findRequiredMedicationsByIdV2(id);
        return medicineDto;
    }

    public List<Object> getAllEmergencyView(Integer id){
        List arrayList = new ArrayList();
        arrayList.add(getpatientWithUserId(id));

        arrayList.add(getCurrentMedicineV2(id));
        arrayList.add(getPatientRelatives(id));
        return arrayList;
    }

//    public List<DeptEmpDto> getDeptEmployeesInnerJoin() {
//        List<DeptEmpDto> list = employeeRepository.fetchEmpDeptDataInnerJoin();
//        list.forEach(l -> System.out.println(l));
//        return list;
//    }
}
