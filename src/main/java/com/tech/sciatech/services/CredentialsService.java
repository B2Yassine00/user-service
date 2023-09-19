package com.tech.sciatech.services;

import com.tech.sciatech.postgresentities.User;
import com.tech.sciatech.postgresrepositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CredentialsService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findbyUsername(String username){
        return repository.findByUsername(username);
    }
}
