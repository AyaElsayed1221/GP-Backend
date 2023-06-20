package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.EmergencyDto;
import com.ayaagroup.demo.dto.PatientDto;
import com.ayaagroup.demo.entity.user.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepo extends JpaRepository<Patient,Integer> {

    //find all basic information for patient by patientId
    @Query("select new com.ayaagroup.demo.dto.PatientDto( p.bloodPressure , p.bloodType , p.Diabietes, p.heartDisease, p.Alcohol , p.treatment, p.tumors, p.patientID) from Patient p where p.patientID=:id ")
    PatientDto findPatientById(Integer id);

    Patient findPatientByPatientID(Integer id);

public int age = 3;
    @Query("select  new com.ayaagroup.demo.dto.EmergencyDto( p.patientID ,p.bloodPressure, p.bloodType, p.Diabietes, p.heartDisease, p.Alcohol, p.treatment, p.tumors, (concat(r.firstName,' ', r.middleName ,' ', r.lastName)) ,r.dateOfBirth)from User r INNER JOIN r.patient p")
    EmergencyDto fetchEmergencyDataInnerJoin(Integer id);
}
