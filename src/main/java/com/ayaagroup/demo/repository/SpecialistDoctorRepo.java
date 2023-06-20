package com.ayaagroup.demo.repository;

import com.ayaagroup.demo.dto.SpecialistDoctorDto;
import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.SpecialistDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistDoctorRepo  extends JpaRepository<SpecialistDoctor,Integer> {

    @Query("select new com.ayaagroup.demo.dto.SpecialistDoctorDto(d.specialistDoctorId, d.specialization, d.experience) from SpecialistDoctor d where d.specialistDoctorId=:id")
    SpecialistDoctorDto findSpecialistDoctorById(Integer id);
  //  SpecialistDoctor findSpecialistDoctorBySpecialistDoctorId(Integer id);


    SpecialistDoctorDto findSpecialistDoctorBySpecialistDoctorId(Integer id);
}
