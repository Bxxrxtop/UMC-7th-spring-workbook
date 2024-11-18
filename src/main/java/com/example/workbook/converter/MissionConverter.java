package com.example.workbook.converter;

import com.example.workbook.domain.common.Mission;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;

public class MissionConverter {
    public static MissionResponseDto.AddMissionResponseDto toMissionResponseDto(Mission mission){
        return MissionResponseDto.AddMissionResponseDto.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .price(mission.getPrice())
                .restaurantId(mission.getRestaurant().getId())
                .build();
    }

    public static Mission toMission(MissionRequestDto.AddMissionRequestDto dto){
        return Mission.builder()
                .content(dto.getContent())
                .deadline(dto.getDeadline())
                .price(dto.getPrice())
                .build();
    }
}
