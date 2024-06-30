package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.user.User;
import com.baridonfrancisco.forohub.domain.user.UserDTOCreate;
import com.baridonfrancisco.forohub.domain.user.UserData;
import com.baridonfrancisco.forohub.domain.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //TODO verificar que el usuario no existe antes de registrar
    @PostMapping
    public ResponseEntity<UserDTOCreate> createUser(@RequestBody @Valid UserData userData){
      var user=userService.createUser(userData);

      return ResponseEntity.status(201)
              .body(user);
    }
}
