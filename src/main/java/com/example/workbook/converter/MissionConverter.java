package com.example.workbook.converter;

import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.mapping.UserMission;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDto.MissionPreViewDto MissionPreViewDto(Mission mission) {
        return MissionResponseDto.MissionPreViewDto.builder()
                .restaurantName(mission.getRestaurant().getName())
                .missionId(mission.getId())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .price(mission.getPrice())
                .build();
    }

    public static MissionResponseDto.MissionPreViewDto MissionPreViewDto(UserMission userMission) {
        Mission mission = userMission.getMission();
        return MissionResponseDto.MissionPreViewDto.builder()
                .restaurantName(mission.getRestaurant().getName())
                .missionId(mission.getId())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .price(mission.getPrice())
                .build();
    }

    public static MissionResponseDto.MissionPreViewListDto MissionPreViewListDto(Page<Mission> missions) {
        List<MissionResponseDto.MissionPreViewDto> missionPreViewDtoList = missions.stream()
                .map(MissionConverter::MissionPreViewDto).collect(Collectors.toList());

        return MissionResponseDto.MissionPreViewListDto.builder()
                .missionList(missionPreViewDtoList)
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .listSize(missionPreViewDtoList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .build();
    }

    public static MissionResponseDto.MissionPreViewListDto UserMissionPreViewListDto(Page<UserMission> missions) {
        List<MissionResponseDto.MissionPreViewDto> missionPreViewDtoList = missions.stream()
                .map(MissionConverter::MissionPreViewDto).collect(Collectors.toList());

        return MissionResponseDto.MissionPreViewListDto.builder()
                .missionList(missionPreViewDtoList)
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .listSize(missionPreViewDtoList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .build();
    }

}
