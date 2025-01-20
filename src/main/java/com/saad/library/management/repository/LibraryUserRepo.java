package com.saad.library.management.repository;

import com.saad.library.management.model.libraryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserRepo  extends JpaRepository<libraryUser, Long> {
}
