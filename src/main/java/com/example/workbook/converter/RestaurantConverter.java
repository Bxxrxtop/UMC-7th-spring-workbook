package com.example.workbook.converter;

import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.web.dto.restaurant.RestaurantRequestDto;
import com.example.workbook.web.dto.restaurant.RestaurantResponseDto;

public class RestaurantConverter {
    public static RestaurantResponseDto.AddRestaurantDto addRestaurant(Restaurant restaurant){
        return RestaurantResponseDto.AddRestaurantDto.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .score(restaurant.getScore())
                .region(restaurant.getRegion().getName())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDto.AddRestaurantDto dto){
        return Restaurant.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .build();
    }
}
