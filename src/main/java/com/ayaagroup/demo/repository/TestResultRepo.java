package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.entity.prescription.TestResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepo extends JpaRepository<TestResults, Integer> {
}
