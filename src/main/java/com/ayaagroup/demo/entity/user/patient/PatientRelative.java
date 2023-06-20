package com.ayaagroup.demo.entity.user.patient;

import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.SpecialistDoctor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patient-Relative")
public class PatientRelative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relative_id")
    private Integer patientID;

    @Column(name = "name")
    private String relationName;

    @Column(name = "relative type")
    private String relativeType;

    @Column(name = "email")
    private String relativeEmail;

    @Column(name = "phone")
    private String relativePhone;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patient;
}
