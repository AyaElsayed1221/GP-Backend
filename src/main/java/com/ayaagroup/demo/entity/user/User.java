package com.ayaagroup.demo.entity.user;

import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.doctor.pharmacy.Pharmacist;
import com.ayaagroup.demo.entity.user.doctor.specialistDoctor.SpecialistDoctor;
import com.ayaagroup.demo.entity.user.patient.Patient;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "user_name")})
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "user_name")
    @NotBlank
    @Size(max = 20)
    private String userName;

    @Column(name = "user_pass")
    @NotBlank
    @Size(max = 120)
    private String userPass;

    @Column(name="user_email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name = "user_date_of_birth")
    private LocalDate dateOfBirth;




    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "apartment_no")
    private Integer apartmentNo;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities = new HashSet<Authority>();;


    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Patient patient;


    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Pharmacist pharmacist;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private SpecialistDoctor specialistDoctor;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private LabTechnician labTechnician;
}
