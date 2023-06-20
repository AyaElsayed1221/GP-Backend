package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.*;

public interface AuthenticationService {

    JwtResponse authenticate(LoginRequest loginRequest);

    void patientSignup(PatientSignupRequest patientSignupRequest);

    void labTecSignup(LabTechSignupRequest labTechSignupRequest);

    void diagnosticSignup(DiagnosticSignupRequest labTechSignupRequest);

    void pharmacistSignup(PharmacistSignUpRequest labTechSignupRequest);
}
