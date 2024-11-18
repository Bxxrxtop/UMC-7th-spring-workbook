package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.service.RestaurnatService.RestaurantService;
import com.example.workbook.web.dto.restaurant.RestaurantRequestDto;
import com.example.workbook.web.dto.restaurant.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ApiResponse<RestaurantResponseDto.AddRestaurantDto> addRestaurant(@RequestBody RestaurantRequestDto.AddRestaurantDto dto){
        RestaurantResponseDto.AddRestaurantDto result = restaurantService.addRestaurant(dto);
        return ApiResponse.onSuccess(result);
    }
}
