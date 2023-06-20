package com.ayaagroup.demo.entity.prescription;

import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.WorkPlaceInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.WeakHashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LabScans")
public class LabScans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scan_id")
    private Integer scanId;

    @Column(name = "Scan name")
    private String scanName;

    @Column(name = "more notes")
    private String notes;

    @Column(name = "Sscan result")
    private String scanResult;

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
