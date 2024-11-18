package com.example.workbook.web.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResponseDto {
        public Long reviewId;
        public String content;
        public Double score;
        public Long userId;
        public Long restaurantId;
    }
}
