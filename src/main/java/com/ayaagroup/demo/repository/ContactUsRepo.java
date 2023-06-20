package com.ayaagroup.demo.repository;


import com.ayaagroup.demo.dto.AllContactRequestsDto;
import com.ayaagroup.demo.entity.ContactUs.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs, Integer> {
//    List<RequiredMedication> findRequiredMedicationByPrescriptionId(Integer prescriptionId);

    @Query(value = "select new com.ayaagroup.demo.dto.AllContactRequestsDto(t.TicketId, t.name) from ContactUs t")
    List<AllContactRequestsDto> getAllContactRequests();

   //  List<ContactUs> findContactUsByTicketId(Integer id);

}
