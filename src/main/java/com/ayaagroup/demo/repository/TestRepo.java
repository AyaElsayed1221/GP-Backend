package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.prescription.LabScans;
import com.ayaagroup.demo.entity.prescription.LabTests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo extends JpaRepository<LabTests,Integer> {
    List<LabTests> findAllByPreId(Integer Id);
}
