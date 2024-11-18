package com.example.workbook.repository;

import com.example.workbook.domain.common.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
