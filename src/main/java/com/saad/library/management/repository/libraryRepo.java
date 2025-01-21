package com.saad.library.management.repository;

import com.saad.library.management.model.library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface libraryRepo extends JpaRepository<library, Long> {


}
