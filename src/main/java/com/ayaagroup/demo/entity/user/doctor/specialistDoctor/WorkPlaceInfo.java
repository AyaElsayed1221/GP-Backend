package com.ayaagroup.demo.entity.user.doctor.specialistDoctor;

import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.doctor.pharmacy.Pharmacist;
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
@Table(name = "WorkPlaceInfo")
public class WorkPlaceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name="place_name")
    private String placeName;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "block_no")
    private String blockNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacist_id", insertable = false, updatable = false)
    private Pharmacist pharmacistEntity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_doctor_id", insertable = false, updatable = false)
    private SpecialistDoctor specialistDoctor;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "labTechnician_id", insertable = false, updatable = false)
    private LabTechnician labTechnicianEntity;
}
