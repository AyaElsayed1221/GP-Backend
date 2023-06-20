package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.scansRequiredDto;
import com.ayaagroup.demo.entity.prescription.LabScans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LabScanRepo extends JpaRepository<LabScans,Integer> {
//    List<LabScans> findAllByPreId(Integer Id);

    @Query("select  new com.ayaagroup.demo.dto.scansRequiredDto(r.scanName)from LabScans r where r.prescriptionEntity.PrescriptionId=:id")
    List<scansRequiredDto> findLabScansById(Integer id);
}
