package com.example.workbook.service.RestaurnatService;

import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.web.dto.restaurant.RestaurantRequestDto;
import com.example.workbook.web.dto.restaurant.RestaurantResponseDto;

public interface RestaurantService {
    RestaurantResponseDto.AddRestaurantDto addRestaurant(RestaurantRequestDto.AddRestaurantDto dto);
}
