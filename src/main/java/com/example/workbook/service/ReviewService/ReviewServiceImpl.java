package com.example.workbook.service.ReviewService;

import com.example.workbook.apiPayload.code.status.ErrorStatus;
import com.example.workbook.apiPayload.exception.handler.RestaurantHandler;
import com.example.workbook.apiPayload.exception.handler.UserHandler;
import com.example.workbook.converter.ReviewConverter;
import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.domain.common.Review;
import com.example.workbook.domain.common.User;
import com.example.workbook.repository.RestaurantRepository;
import com.example.workbook.repository.ReviewRepository;
import com.example.workbook.repository.UserRepository;
import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public ReviewResponseDto.AddReviewResponseDto addReview(ReviewRequestDto.AddReviewRequestDto dto) {
        Review review = ReviewConverter.toReview(dto);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        review.setUser(user);
        review.setRestaurant(restaurant);

        reviewRepository.save(review);

        return ReviewConverter.toAddReviewRequestDto(review);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return reviewPage;
    }
}
