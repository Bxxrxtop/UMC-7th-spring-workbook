package com.example.workbook.service.ReviewService;

import com.example.workbook.domain.common.Review;
import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;
import org.springframework.data.domain.Page;

public interface ReviewService {
    ReviewResponseDto.AddReviewResponseDto addReview(ReviewRequestDto.AddReviewRequestDto dto);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Review> getUserReviewList(Long userId, Integer page);
}
