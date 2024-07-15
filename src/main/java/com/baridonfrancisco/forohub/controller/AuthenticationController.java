package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.user.User;
import com.baridonfrancisco.forohub.security.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTDTO> authenticationUser(@RequestBody @Valid UserDataLogin data){
        Authentication authToken= new UsernamePasswordAuthenticationToken(
                data.user(),data.password());
        Authentication auth= authManager.authenticate(authToken);

        if(auth.isAuthenticated()){



          User user= (User)auth.getPrincipal();
         String token=tokenService.generateToken(user).trim();

         JWTDTO jwtdto=new JWTDTO(user.getUsername(),token);
         return ResponseEntity.ok(jwtdto);

        }
        throw new RuntimeException("User not authenticated");


    }
}
