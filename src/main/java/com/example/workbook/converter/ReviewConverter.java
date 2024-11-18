package com.example.workbook.converter;

import com.example.workbook.domain.common.Review;
import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;

public class ReviewConverter {
    public static ReviewResponseDto.AddReviewResponseDto toAddReviewRequestDto(Review review){
        return ReviewResponseDto.AddReviewResponseDto.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .score(review.getScore())
                .userId(review.getUser().getId())
                .restaurantId(review.getRestaurant().getId())
                .build();
    }

    public static Review toReview(ReviewRequestDto.AddReviewRequestDto dto){
        return Review.builder()
                .content(dto.getContent())
                .score(dto.getScore())
                .build();
    }
}
