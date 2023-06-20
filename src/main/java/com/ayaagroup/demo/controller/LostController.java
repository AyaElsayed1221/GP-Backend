package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.AllLostDto;
import com.ayaagroup.demo.dto.LostDto;
import com.ayaagroup.demo.Services.LostService;
import com.ayaagroup.demo.entity.ContactUs.LostCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/losts")
public class LostController {

    @Autowired
    private LostService lostService;


    @PostMapping("/lost-card-patient-view")
    public LostDto lostcard(@RequestBody LostCard lost){
        return lostService.lostCard(lost);
    }

    @GetMapping("/lost-card-request-page")
    public LostDto retrieveLostCardInfo(@RequestParam Integer requestID){
        return lostService.retrieveLostCardInfo(requestID);
    }

    @GetMapping("/all-lost-card-requests-page")
    public List<AllLostDto> getAllLostCardRequests(){
        return this.lostService.getAllLostCardRequests();
    }
}
