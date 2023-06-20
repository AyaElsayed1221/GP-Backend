package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.*;
import com.ayaagroup.demo.entity.prescription.RequiredMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepo extends JpaRepository<RequiredMedication, Integer> {

@Query("select new com.ayaagroup.demo.dto.PharmacistMedicinesDto(r.medicineId,r.medicineName, r.medicineDoses, r.Period)  from RequiredMedication r where r.requiredDrugs.PrescriptionId=:id")
   List<PharmacistMedicinesDto>  findRequiredMedicationById(Integer id);

@Query("select  new com.ayaagroup.demo.dto.medicineDto(r.medicineName, r.medicineDoses , r.Period , r.startDate)from RequiredMedication r where r.requiredDrugs.PrescriptionId=:id")
List<medicineDto> findRequiredMedicationsById(Integer id);


@Query("select  new com.ayaagroup.demo.dto.RequiredMedicationDto(r.medicineName)from RequiredMedication r where r.patientDrugs.patientID=:id")
    List<RequiredMedicationDto> findRequiredMedicationsByIdV2(Integer id);



//    @Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//            + "FROM Department d INNER JOIN d.employees e")
//    List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

}
