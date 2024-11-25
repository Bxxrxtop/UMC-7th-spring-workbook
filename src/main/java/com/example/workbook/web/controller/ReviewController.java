package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.converter.ReviewConverter;
import com.example.workbook.domain.common.Review;
import com.example.workbook.service.ReviewService.ReviewService;
import com.example.workbook.validation.annotation.ExistRestaurant;
import com.example.workbook.validation.annotation.PageValid;
import com.example.workbook.web.dto.review.ReviewRequestDto;
import com.example.workbook.web.dto.review.ReviewResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/restaurants/reviews")
    public ApiResponse<ReviewResponseDto.AddReviewResponseDto> addReview(@RequestBody @Valid ReviewRequestDto.AddReviewRequestDto dto){
        ReviewResponseDto.AddReviewResponseDto result = reviewService.addReview(dto);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/restaurants/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDto.ReviewPreViewListDto> getReviewList(@ExistRestaurant @PathVariable(name = "restaurantId") Long restaurantId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewPage = reviewService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }

    @GetMapping("/restaurants/reviews/{userId}")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDto.ReviewPreViewListDto> getUserReviewList(@PathVariable(name = "userId") Long userId, @PageValid @RequestParam(name = "page") Integer page){
        Page<Review> reviewPage = reviewService.getUserReviewList(userId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }
}
