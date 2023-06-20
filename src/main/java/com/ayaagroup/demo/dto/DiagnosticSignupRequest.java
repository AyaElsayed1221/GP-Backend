package com.ayaagroup.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class DiagnosticSignupRequest {
    private String firstName;

    private String middleName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    //private Set<Authority> authorities;
    private String authorityName;

    /***/
    private String specialization;

    //asdy hna a5saey wla est4ary
    private String experience;
    /***/

    private String city;

    private String street;

    private Integer apartmentNo;
}
