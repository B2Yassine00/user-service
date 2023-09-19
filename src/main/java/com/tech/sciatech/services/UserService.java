package com.tech.sciatech.services;

import com.tech.sciatech.DTO.UserDetailsDTO;
import com.tech.sciatech.mysqlentities.UserDetails;
import com.tech.sciatech.mysqlrepositories.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDetailsRepository repository;

    public UserDetails saveUser(UserDetailsDTO userDetailsDTO){
        UserDetails user = UserDetails.builder()
                .firstName(userDetailsDTO.getFirstName())
                .lastName(userDetailsDTO.getLastName())
                .age(userDetailsDTO.getAge())
                .email(userDetailsDTO.getEmail())
                .gender(userDetailsDTO.getGender())
                .height(userDetailsDTO.getHeight())
                .weight(userDetailsDTO.getWeight())
                .credentials_id(userDetailsDTO.getCredentials_id()).build();
        return repository.save(user);
    }
}
