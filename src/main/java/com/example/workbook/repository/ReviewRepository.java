package com.example.workbook.repository;

import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.domain.common.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
