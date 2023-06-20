package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.AllContactRequestsDto;
import com.ayaagroup.demo.dto.ContactDto;
import com.ayaagroup.demo.entity.ContactUs.ContactUs;
import com.ayaagroup.demo.repository.ContactUsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactUsRepo contactUsRepo;


    public ContactDto contactUs (ContactUs contact){
        return ContactDto.toDto(contactUsRepo.save(contact));
    }

    public ContactDto retrieveContactInfo(Integer requestId) {
        Optional<ContactUs> contactUs = contactUsRepo.findById(requestId);

        if (contactUs.isPresent()){
            return ContactDto.toDto(contactUs.get());
        }
        else return null;
    }

    public List<AllContactRequestsDto> getAllContactRequests(){
        return this.contactUsRepo.getAllContactRequests();
    }
}
