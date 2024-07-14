package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.user.User;
import com.baridonfrancisco.forohub.security.AuthenticationService;
import com.baridonfrancisco.forohub.security.UserDataLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authManager;


    @PostMapping
    public void authenticationUser(@RequestBody @Valid UserDataLogin data){
        Authentication authToken= new UsernamePasswordAuthenticationToken(
                data.user(),data.password());
       Authentication auth= authManager.authenticate(authToken);
        System.out.println(auth);
        System.out.println("exitoso");


    }
}
