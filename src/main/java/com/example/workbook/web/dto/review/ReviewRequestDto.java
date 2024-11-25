package com.example.workbook.web.dto.review;

import com.example.workbook.validation.annotation.ExistRestaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDto {
    @Getter
    public static class AddReviewRequestDto {
        @NotBlank
        public String content;
        @NotNull
        public Double score;
        @NotNull
        public Long userId;
        @ExistRestaurant
        public Long restaurantId;
    }


    @Getter
    public static class SelfReviewRequestDto{
        public Long userId;
    }
}
