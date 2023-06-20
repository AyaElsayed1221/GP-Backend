package com.ayaagroup.demo.entity.user.patient;

import com.ayaagroup.demo.entity.prescription.LabScans;
import com.ayaagroup.demo.entity.prescription.RequiredMedication;
import com.ayaagroup.demo.entity.user.User;
import com.ayaagroup.demo.entity.user.patient.insurance.Insurance;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientID;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "diabietes")
    private Boolean Diabietes;

    @Column(name = "heart_disease")
    private Boolean heartDisease;

    @Column(name = "alcohol")
    private Boolean Alcohol;

    @Column(name = "physical_or_mental")
    private Boolean treatment;

    @Column(name = "tumors")
    private Boolean tumors;

    @JsonManagedReference
    @OneToMany(mappedBy = "patientEntity")
    private List<Insurance> insurances;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_disease",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private Set<DiseaseEntity> diseases = new HashSet<>();

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "patientDrugs")
    private List<RequiredMedication> requiredMedications;

    @JsonManagedReference
    @OneToMany(mappedBy = "patient")
    private List<PatientRelative> patientRelative;


    public Patient(User user) {
        this.user = user;
    }
}
