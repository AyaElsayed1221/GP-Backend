package com.ayaagroup.demo.entity.prescription;

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
@Table(name = "Test-result")
public class TestResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tresult_id")
    private Integer resultId;

    @Column(name = "test_id")
    private Integer testId;

    //pdf!!!!!!!!!!!!!!
    @Column(name = "lab result")
    private String testResult;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", insertable = false, updatable = false)
    private LabTests labTests;






//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
//    private Patient patients;
//
//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctorId", insertable = false, updatable = false)
//    private Doctor doctor;
}
