package com.ayaagroup.demo.entity.user.doctor.specialistDoctor;

import com.ayaagroup.demo.entity.prescription.PrescriptionEntity;
import com.ayaagroup.demo.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialist-doctor")
public class SpecialistDoctor {

    //don't forget to make it unique in the db
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "specialist_doctor_id")
    private Integer specialistDoctorId;

    @Column(name = "specialization")
    private String specialization;

    //asdy hna a5saey wla est4ary
    @Column(name = "experience")
    private String experience;

    @JsonManagedReference
    @OneToMany(mappedBy = "specialistDoctor")
    private List<WorkPlaceInfo> workPlace;

    @JsonManagedReference
    @OneToOne(mappedBy = "specialistDoctor")
    private PrescriptionEntity prescriptionEntity;

    @JsonManagedReference
    @OneToOne(mappedBy = "doctorSpecialization")
    private PrescriptionEntity prescriptionSpecialization;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
