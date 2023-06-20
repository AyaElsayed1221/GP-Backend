package com.ayaagroup.demo.entity.prescription;

import com.ayaagroup.demo.entity.user.patient.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Prescription Drugs")
public class RequiredMedication {

    //counter for current medicine, front
    //deciding what type of medicine will be continued
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Integer medicineId;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "doses")
    private Integer medicineDoses;

    @Column(name = "period")
    private Integer Period;

    @Column(name = "start_date")
    private Date startDate;

//    @Column(name = "prescription_id")
//    private Integer prescriptionId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", insertable = false, updatable = false)
    private PrescriptionEntity requiredDrugs;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Patient patientDrugs ;
}
