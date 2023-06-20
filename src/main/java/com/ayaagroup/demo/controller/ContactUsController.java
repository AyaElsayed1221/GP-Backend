package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.AllContactRequestsDto;
import com.ayaagroup.demo.dto.ContactDto;
import com.ayaagroup.demo.Services.ContactService;
import com.ayaagroup.demo.entity.ContactUs.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactUsController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contact-us")
    public ContactDto contactDto(@RequestBody ContactUs contact){
        return contactService.contactUs(contact);
    }


    @GetMapping("/contact-us-request-page")
    public ContactDto retrieveContactInfo(@RequestParam Integer requestId){
        return contactService.retrieveContactInfo(requestId);
    }

    @GetMapping("/all-contact-requests-page")
    public List<AllContactRequestsDto> getAllContactRequests(){
        return this.contactService.getAllContactRequests();
    }
}
