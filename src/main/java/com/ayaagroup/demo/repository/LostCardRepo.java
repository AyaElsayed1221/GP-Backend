package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.AllLostDto;
import com.ayaagroup.demo.entity.ContactUs.LostCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostCardRepo extends JpaRepository<LostCard, Integer> {

    @Query(value = "select new com.ayaagroup.demo.dto.AllLostDto(t.RequestId, t.name) from LostCard t")
    List<AllLostDto> getAllLostCards();

}
