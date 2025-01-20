package com.saad.library.management.repository;

import com.saad.library.management.model.book_review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookReviewRepo extends JpaRepository<book_review, Long> {

}
