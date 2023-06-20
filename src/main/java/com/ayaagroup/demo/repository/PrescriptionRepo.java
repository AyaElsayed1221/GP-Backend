package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.prescription.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<PrescriptionEntity,Integer> {

    @Query("select p from PrescriptionEntity p where p.PrescriptionId=:id")
    PrescriptionEntity findPrescriptionEntityById(Integer id);
}