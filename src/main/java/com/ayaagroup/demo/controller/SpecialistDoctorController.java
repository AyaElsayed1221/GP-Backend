package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.SpecialistDoctorDto;
import com.ayaagroup.demo.Services.SpecialistDoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class SpecialistDoctorController {
    private SpecialistDoctorService specialistDoctorService;

    @GetMapping("/{doctorId}")
    public SpecialistDoctorDto getDoctorInfo(@PathVariable(name="doctorId") Integer id){
        return specialistDoctorService.getSpecialistDoctorInfo(id);
    }
}
