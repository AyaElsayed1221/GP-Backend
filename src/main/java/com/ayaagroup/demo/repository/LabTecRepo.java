package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.patient.PatientRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTecRepo extends JpaRepository<LabTechnician, Integer> {
}
