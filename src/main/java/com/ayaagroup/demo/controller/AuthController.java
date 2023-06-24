package com.ayaagroup.demo.controller;


import com.ayaagroup.demo.Services.AuthenticationService;
import com.ayaagroup.demo.Services.DefaultUserDetailsService;
import com.ayaagroup.demo.dto.JwtResponse;
import com.ayaagroup.demo.dto.LabTechSignupRequest;
import com.ayaagroup.demo.dto.LoginRequest;
import com.ayaagroup.demo.dto.PatientSignupRequest;
import com.ayaagroup.demo.security.user.DefaultUserDetails;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    DefaultUserDetailsService defaultUserDetailsService;

    @Value("${app.jwtSecret}")
    private String jwtSecret;
    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = authenticationService.authenticate(loginRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/patient-signup")
    public void patientSignup(@RequestBody PatientSignupRequest patientSignupRequest) {
       authenticationService.patientSignup(patientSignupRequest);
    }

    @GetMapping("/lab-tec-signup")
    public void labTecSignup(@RequestBody LabTechSignupRequest labTechSignupRequest) {
        authenticationService.labTecSignup(labTechSignupRequest);
    }

    /** get current user**/
    @GetMapping("/current-user")
    public DefaultUserDetails getCurrentUser(Principal principal){
        return ((DefaultUserDetails) this.defaultUserDetailsService.loadUserByUsername(principal.getName()));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // TODO: Implement logout logic
        System.out.println("\n\n\n"+request.getHeader("Authorization"));

        //2. In the logout endpoint, get the JWT token from the request header:
        String oldToken = request.getHeader("Authorization").substring(7);

        //3. Create a new instance of JwtParser:
        JwtParser jwtParser = Jwts.parser().setSigningKey(jwtSecret);

        //4. Parse the JWT token and get the expiration date:
        Date expirationDate = jwtParser.parseClaimsJws(oldToken).getBody().getExpiration();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DefaultUserDetails userPrincipal = (DefaultUserDetails) authentication.getPrincipal();

       // 5. Create a new instance of JwtBuilder:
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() - 1000));


        //6. Sign the JWT token with the secret key:
        String newToken = jwtBuilder.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

        //7. Set the new token in the response header:
        response.setHeader("Authorization", "Bearer " + newToken);
        System.out.println("\n\n\n"+response.getHeader("Authorization"));

        //8. Invalidate the old token by setting the expiration time to a past date:  !!!!!!
        response.setHeader("Authorization", "Bearer " + " ");

        //SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println("\n\n\n"+response.getHeader("Authorization"));

        //9. Return a response entity with a 200 OK status code:
        return ResponseEntity.ok().build();
    }

}
