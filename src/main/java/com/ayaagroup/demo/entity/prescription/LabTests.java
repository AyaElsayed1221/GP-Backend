package com.ayaagroup.demo.entity.prescription;

import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.WorkPlaceInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription Tests")
public class LabTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "Test name")
    private String testName;

    @Column(name = "more notes")
    private String notes;

    @Column(name = "Test result")
    private String testResult;

    @Column(name = "prescription_id")
    private Integer preId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", insertable = false, updatable = false)
    private PrescriptionEntity prescriptionEntity;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_technician_id", insertable = false, updatable = false)
    private LabTechnician labTechnician;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "labAddress_id", insertable = false, updatable = false)
    private WorkPlaceInfo labAddress;

}

