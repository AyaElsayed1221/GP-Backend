package com.ayaagroup.demo.entity.user.doctor.lab;

import com.ayaagroup.demo.entity.prescription.LabScans;
import com.ayaagroup.demo.entity.prescription.LabTests;
import com.ayaagroup.demo.entity.user.User;
import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.WorkPlaceInfo;
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
@Table(name = "laboratory_doctor")
public class LabTechnician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labTechnician_id")
    private Integer labTechnician_id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "lab_name")
    private String labName;

    @JsonManagedReference
    @OneToMany(mappedBy = "labTechnicianEntity")
    private List<WorkPlaceInfo> workplace;

    @JsonManagedReference
    @OneToMany(mappedBy = "labTechnician")
    private List<LabTests> labTests;

    @JsonManagedReference
    @OneToMany(mappedBy = "labTechnician")
    private List<LabScans> labScans;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
