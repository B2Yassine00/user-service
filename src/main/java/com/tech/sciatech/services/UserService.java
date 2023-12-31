package com.tech.sciatech.services;

import com.tech.sciatech.DTO.UserDetailsDTO;
import com.tech.sciatech.mysqlentities.UserDetails;
import com.tech.sciatech.mysqlrepositories.UserDetailsRepository;
import com.tech.sciatech.postgresentities.User;
import com.tech.sciatech.postgresrepositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDetailsRepository repository;
    @Autowired
    private UserRepository userRepository;

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

    public UserDetails updateUser(UserDetails userDetails){
        UserDetails user = repository.findById(userDetails.getId()).orElse(null);
        assert user != null;
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setGender(userDetails.getGender());
        user.setEmail(userDetails.getEmail());
        user.setHeight(userDetails.getHeight());
        user.setWeight(user.getWeight());
        return repository.save(user);
    }

    public String deleteUser(Integer id){
        Optional<UserDetails> user = repository.findById(id);
        Optional<User> usercred = userRepository.findById(user.get().getCredentials_id());
        userRepository.delete(usercred.get());
        repository.deleteById(id);
        return "user removed"+id;
    }

    public UserDetails getUserById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public UserDetails getUserByName(String name){
        return repository.findByLastName(name).orElse(null);
    }
}
