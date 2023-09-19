package com.tech.sciatech.postgresrepositories;

import com.tech.sciatech.postgresentities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    boolean existsUserByUsername(String username);

}
