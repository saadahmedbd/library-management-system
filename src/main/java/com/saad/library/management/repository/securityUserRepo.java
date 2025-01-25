package com.saad.library.management.repository;

import com.saad.library.management.model.security_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface securityUserRepo extends JpaRepository<security_User, Long> {
    Optional<security_User> findByUsername (String username);

}
