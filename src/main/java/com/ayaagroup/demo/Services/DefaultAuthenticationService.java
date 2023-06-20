package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.*;
import com.ayaagroup.demo.entity.user.Authority;
import com.ayaagroup.demo.entity.user.User;
import com.ayaagroup.demo.entity.user.doctor.lab.LabTechnician;
import com.ayaagroup.demo.entity.user.patient.Patient;
import com.ayaagroup.demo.entity.user.patient.PatientRelative;
import com.ayaagroup.demo.repository.*;
import com.ayaagroup.demo.utility.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultAuthenticationService implements AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    PatientRelativeRepository patientRelativeRepository;

    @Autowired
    LabTecRepo labTecRepo;

    @Autowired
    SpecialistDoctorRepo specialistDoctorRepo;

    @Autowired
    PharmacistRepo pharmacistRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public JwtResponse authenticate(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        //hwa hna eh fayded el builder leh mba3ml4 object mn el JwtResponse we b assign gwah el JWT ??
        return JwtResponse.builder()
                .jwtToken(jwt)
                .build();
    }

    /** in postman
     "authorities":[
     {
     "authority_id":4,
     "name":"ROLE_PHARMACIST"
     }
     ]
     * **/

    @Override
    public void patientSignup(PatientSignupRequest patientSignupRequest) {

        if (userRepository.existsByUserName(patientSignupRequest.getUsername())) {
            throw new RuntimeException("User is already exist");
        }


        Set<Authority> authoritySet = new HashSet<>();
        int authorityId;

        switch (patientSignupRequest.getAuthorityName()){
            case "ROLE_ADMIN": authorityId = 1;
                break;
            case "ROLE_PATIENT": authorityId=2;
                break;
            case "ROLE_DIAGNOSTIC_DOCTOR": authorityId=3;
                break;
            case "ROLE_PHARMACIST": authorityId=4;
                break;
            case "ROLE_LAB_TECHNICAL": authorityId=5;
                break;

            default:throw new RuntimeException();
        }

        authoritySet.add(new Authority(authorityId, patientSignupRequest.getAuthorityName()));


//        Patient patient = Patient.builder()
//                .build();

        User user = User.builder()
                .firstName(patientSignupRequest.getFirstName())
                .middleName(patientSignupRequest.getMiddleName())
                .lastName(patientSignupRequest.getLastName())
                .userName(patientSignupRequest.getUsername())
                .userPass(encoder.encode(patientSignupRequest.getPassword()))
                .email(patientSignupRequest.getEmail())
                .phoneNumber(patientSignupRequest.getPhoneNumber())
                .dateOfBirth(patientSignupRequest.getDateOfBirth())
//                .authorities(signupRequest.getAuthorities())
                .authorities(authoritySet)
                .city(patientSignupRequest.getCity())
                .street(patientSignupRequest.getStreet())
                .apartmentNo(patientSignupRequest.getApartmentNo())
                .build();

        userRepository.save(user);

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setUserId(user.getUserId());
        patientRepo.save(patient);
        user.setPatient(patient);
        userRepository.save(user);
        System.out.println("patient id is: "+patient.getPatientID()+"and user id is: "+patient.getUser().getUserId());
        System.out.println("patient id of user is: "+ user.getPatient().getPatientID());



        PatientRelative patientRelative = PatientRelative.builder()
                .relationName(patientSignupRequest.getRelationName())
                .relativeType(patientSignupRequest.getRelativeType())
                .relativeEmail(patientSignupRequest.getRelativeEmail())
                .relativePhone(patientSignupRequest.getRelativePhone())
                .build();


        System.out.println(user.getUserId());
        System.out.println(patient.getUser().getUserId());
        patientRelativeRepository.save(patientRelative);

    }

    @Override
    public void labTecSignup(LabTechSignupRequest labTechSignupRequest) {

        if (userRepository.existsByUserName(labTechSignupRequest.getUsername())) {
            throw new RuntimeException("User is already exist");
        }

        Set<Authority> authoritySet = new HashSet<>();
        int authorityId =5;
        authoritySet.add(new Authority(authorityId, "ROLE_LAB_TECHNICAL"));


        User user = User.builder()
                .firstName(labTechSignupRequest.getFirstName())
                .middleName(labTechSignupRequest.getMiddleName())
                .lastName(labTechSignupRequest.getLastName())
                .userName(labTechSignupRequest.getUsername())
                .userPass(encoder.encode(labTechSignupRequest.getPassword()))
                .email(labTechSignupRequest.getEmail())
                .phoneNumber(labTechSignupRequest.getPhoneNumber())
                .dateOfBirth(labTechSignupRequest.getDateOfBirth())
//                .authorities(signupRequest.getAuthorities())
                .authorities(authoritySet)
                .city(labTechSignupRequest.getCity())
                .street(labTechSignupRequest.getStreet())
                .apartmentNo(labTechSignupRequest.getApartmentNo())
                .build();

        userRepository.save(user);

        LabTechnician labTechnician = new LabTechnician();
        labTechnician.setUser(user);
        labTechnician.setLabName(labTechSignupRequest.getLabName());
        labTechnician.setUserId(user.getUserId());
        labTecRepo.save(labTechnician);
        user.setLabTechnician(labTechnician);
        userRepository.save(user);

        System.out.println("lab tech id is: "+labTechnician.getLabTechnician_id()+"and user id is: "+labTechnician.getUser().getUserId());
        System.out.println("labtechnican id of user is: "+ user.getLabTechnician().getLabTechnician_id());
    }

    @Override
    public void diagnosticSignup(DiagnosticSignupRequest labTechSignupRequest) {

        if (userRepository.existsByUserName(labTechSignupRequest.getUsername())) {
            throw new RuntimeException("User is already exist");
        }

        Set<Authority> authoritySet = new HashSet<>();
        int authorityId =3;
        authoritySet.add(new Authority(authorityId, "ROLE_DIAGNOSTIC_DOCTOR"));

        User user = User.builder()
                .firstName(labTechSignupRequest.getFirstName())
                .middleName(labTechSignupRequest.getMiddleName())
                .lastName(labTechSignupRequest.getLastName())
                .userName(labTechSignupRequest.getUsername())
                .userPass(encoder.encode(labTechSignupRequest.getPassword()))
                .email(labTechSignupRequest.getEmail())
                .phoneNumber(labTechSignupRequest.getPhoneNumber())
                .dateOfBirth(labTechSignupRequest.getDateOfBirth())
//                .authorities(signupRequest.getAuthorities())
                .authorities(authoritySet)
                .city(labTechSignupRequest.getCity())
                .street(labTechSignupRequest.getStreet())
                .apartmentNo(labTechSignupRequest.getApartmentNo())
                .build();

        userRepository.save(user);
    }

    @Override
    public void pharmacistSignup(PharmacistSignUpRequest labTechSignupRequest) {

        if (userRepository.existsByUserName(labTechSignupRequest.getUsername())) {
            throw new RuntimeException("User is already exist");
        }

        Set<Authority> authoritySet = new HashSet<>();
        int authorityId =4;
        authoritySet.add(new Authority(authorityId, "ROLE_PHARMACIST"));

        User user = User.builder()
                .firstName(labTechSignupRequest.getFirstName())
                .middleName(labTechSignupRequest.getMiddleName())
                .lastName(labTechSignupRequest.getLastName())
                .userName(labTechSignupRequest.getUsername())
                .userPass(encoder.encode(labTechSignupRequest.getPassword()))
                .email(labTechSignupRequest.getEmail())
                .phoneNumber(labTechSignupRequest.getPhoneNumber())
                .dateOfBirth(labTechSignupRequest.getDateOfBirth())
//                .authorities(signupRequest.getAuthorities())
                .authorities(authoritySet)
                .city(labTechSignupRequest.getCity())
                .street(labTechSignupRequest.getStreet())
                .apartmentNo(labTechSignupRequest.getApartmentNo())
                .build();

        userRepository.save(user);
    }

}


