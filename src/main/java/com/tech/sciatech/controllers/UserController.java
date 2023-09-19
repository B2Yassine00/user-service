package com.tech.sciatech.controllers;

import com.tech.sciatech.DTO.UserDetailsDTO;
import com.tech.sciatech.mysqlentities.UserDetails;
import com.tech.sciatech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/addUser")
    public ResponseEntity<UserDetails> addUser(@RequestBody UserDetailsDTO userDetailsDTO){

        return ResponseEntity.ok(service.saveUser(userDetailsDTO));
    }
}
