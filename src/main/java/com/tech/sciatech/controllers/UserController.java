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

    @PutMapping("/updateUser")
    public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails){
        return ResponseEntity.ok(service.updateUser(userDetails));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return service.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public UserDetails getUserById(@PathVariable Integer id){
        return service.getUserById(id);
    }

    @GetMapping("/user/{lastname}")
    public UserDetails getUserByLastName(@PathVariable String name){
        return service.getUserByName(name);
    }
}
