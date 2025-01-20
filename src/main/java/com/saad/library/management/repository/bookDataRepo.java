package com.saad.library.management.repository;

import com.saad.library.management.model.book_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookDataRepo extends JpaRepository<book_data, Long> {
}
