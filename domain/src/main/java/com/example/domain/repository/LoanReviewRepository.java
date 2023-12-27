package com.example.domain.repository;

import com.example.domain.domain.LoanReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanReviewRepository extends JpaRepository<LoanReview, Long> {

}
