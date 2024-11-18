package com.example.workbook.service.ReviewService;

import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;

public interface ReviewService {
    ReviewResponseDto.AddReviewResponseDto addReview(ReviewRequestDto.AddReviewRequestDto dto);
}
