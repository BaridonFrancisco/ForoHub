package com.baridonfrancisco.forohub.controller;

import com.baridonfrancisco.forohub.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //TODO verificar que el usuario no existe antes de registrar
    @PostMapping
    @Transactional
    public ResponseEntity<UserDTOCreate> createUser(@RequestBody @Valid UserData userData){
      var user=userService.createUser(userData);

      return ResponseEntity.status(201)
              .body(user);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDTOGet> retrieveUser(@PathVariable Long id){
            var user=userService.retrieveUser(id);
            return ResponseEntity.ok(user);


    }
    @GetMapping
    public ResponseEntity<Page<UserDTOGet>> findAllUsers(@PageableDefault(value = 10) Pageable pageable){
        var users=userService.findAllUser(pageable);
        return ResponseEntity.ok(users);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserDTOUpdate>updateUser(@RequestBody @Valid UserDataUpdate dataUser){
        var userUpdate=userService.updateUser(dataUser);
        return ResponseEntity.ok(userUpdate);

    }
    //TODO considerar implementar delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
