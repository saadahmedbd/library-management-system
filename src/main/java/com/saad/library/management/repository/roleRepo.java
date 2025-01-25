package com.saad.library.management.repository;

import com.saad.library.management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface roleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
