package com.example.workbook.service.MissionService;

import com.example.workbook.apiPayload.code.status.ErrorStatus;
import com.example.workbook.apiPayload.exception.handler.RestaurantHandler;
import com.example.workbook.converter.MissionConverter;
import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.common.Restaurant;
import com.example.workbook.repository.MissionRepository;
import com.example.workbook.repository.RestaurantRepository;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public MissionResponseDto.AddMissionResponseDto addMission(MissionRequestDto.AddMissionRequestDto dto) {
        Mission mission = MissionConverter.toMission(dto);
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        mission.setRestaurant(restaurant);

        missionRepository.save(mission);
        return MissionConverter.toMissionResponseDto(mission);
    }
}
