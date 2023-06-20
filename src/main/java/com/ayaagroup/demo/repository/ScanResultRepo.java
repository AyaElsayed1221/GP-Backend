package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.prescription.ScanResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanResultRepo extends JpaRepository<ScanResult,Integer> {
}
