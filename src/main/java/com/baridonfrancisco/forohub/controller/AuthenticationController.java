package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    public void authenticationUser(@RequestBody Object object){

    }
}
