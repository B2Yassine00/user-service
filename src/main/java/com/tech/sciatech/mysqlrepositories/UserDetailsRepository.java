package com.tech.sciatech.mysqlrepositories;

import com.tech.sciatech.mysqlentities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

    Optional<UserDetails> findByFirstName(String firstName);
}
