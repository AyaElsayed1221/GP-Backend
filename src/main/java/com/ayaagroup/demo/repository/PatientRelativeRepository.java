package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.user.patient.PatientRelative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRelativeRepository extends JpaRepository<PatientRelative, Integer> {
}
