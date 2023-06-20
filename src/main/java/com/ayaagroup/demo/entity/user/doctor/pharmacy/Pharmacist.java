package com.ayaagroup.demo.entity.user.doctor.pharmacy;

import com.ayaagroup.demo.entity.prescription.RequiredMedication;
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
@Entity(name = "pharmacist")
@Table(name = "Pharmacist",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "pharmacist_id")})
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacist_id")
    private Integer pharmacistId;


    @JsonManagedReference
    @OneToMany(mappedBy = "pharmacistEntity")
    private List<WorkPlaceInfo> workPlace;



    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
