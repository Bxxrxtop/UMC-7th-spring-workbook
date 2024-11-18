package com.example.workbook.service.RestaurnatService;

import com.example.workbook.apiPayload.code.status.ErrorStatus;
import com.example.workbook.apiPayload.exception.handler.RegionHandler;
import com.example.workbook.converter.RestaurantConverter;
import com.example.workbook.domain.common.Region;
import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.repository.RegionRepository;
import com.example.workbook.repository.RestaurantRepository;
import com.example.workbook.web.dto.restaurant.RestaurantRequestDto;
import com.example.workbook.web.dto.restaurant.RestaurantResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;
    @Override
    @Transactional
    public RestaurantResponseDto.AddRestaurantDto addRestaurant(RestaurantRequestDto.AddRestaurantDto dto) {
        Restaurant restaurant = RestaurantConverter.toRestaurant(dto);
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        restaurant.setRegion(region);
        restaurantRepository.save(restaurant);

        return RestaurantConverter.addRestaurant(restaurant);
    }
}
