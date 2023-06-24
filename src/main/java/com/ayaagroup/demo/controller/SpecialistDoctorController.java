package com.ayaagroup.demo.controller;

import com.ayaagroup.demo.dto.SpecialistDoctorDto;
import com.ayaagroup.demo.Services.SpecialistDoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialistDoctorController {
    private SpecialistDoctorService specialistDoctorService;

    @GetMapping("/{doctorId}")
    public SpecialistDoctorDto getDoctorInfo(@PathVariable(name="doctorId") Integer id){
        return specialistDoctorService.getSpecialistDoctorInfo(id);
    }
}
