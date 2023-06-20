package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.PatientRelativeDto;
import com.ayaagroup.demo.entity.user.patient.PatientRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRelativeRepo extends JpaRepository<PatientRelative, Integer> {
    @Query("select new com.ayaagroup.demo.dto.PatientRelativeDto(p.relationName , p.relativeType,  p.relativeEmail , p.relativePhone ) from PatientRelative p where p.patient.patientID=:id ")
    List<PatientRelativeDto> findPatientRelativeByPatientId(Integer id);

}
