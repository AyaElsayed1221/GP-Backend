package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.testRequiredDto;
import com.ayaagroup.demo.entity.prescription.LabTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabTestRepo extends JpaRepository<LabTests,Integer> {


    @Query("select  new com.ayaagroup.demo.dto.testRequiredDto(r.testName)from LabTests r where r.prescriptionEntity.PrescriptionId=:id")
    List<testRequiredDto> findLabTestsById(Integer id);
}
