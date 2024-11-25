package com.example.workbook.converter;

import com.example.workbook.domain.common.Review;
import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDto.ReviewPreViewDto reviewPreViewDTO(Review review){
        return ReviewResponseDto.ReviewPreViewDto.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }
    public static ReviewResponseDto.ReviewPreViewListDto reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDto.ReviewPreViewDto> reviewPreViewDtoList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDto.ReviewPreViewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDtoList.size())
                .reviewList(reviewPreViewDtoList)
                .build();
    }
}
