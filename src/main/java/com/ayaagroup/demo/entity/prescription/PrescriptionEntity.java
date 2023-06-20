package com.ayaagroup.demo.entity.prescription;

import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.SpecialistDoctor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Integer PrescriptionId;

    @Column(name = "diagnosis_Name")
    private String diagnosisName;

    @Column(name = "Date")
    private Date date;

    @Column(name = "notes")
    private String notes;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_doctor_id", insertable = false, updatable = false)
    private SpecialistDoctor specialistDoctor;

    @JsonManagedReference
    @OneToMany(mappedBy = "requiredDrugs")
    private List<RequiredMedication> prescriptionDrugsEntities ;

    @JsonManagedReference
    @OneToMany(mappedBy = "prescriptionEntity")
    private List<LabTests> labTests;

    @JsonManagedReference
    @OneToMany(mappedBy = "prescriptionEntity")
    private List<LabScans> labScans;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization", insertable = false, updatable = false)
    private SpecialistDoctor doctorSpecialization;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
//    private PrescriptionEntity amira;

}
