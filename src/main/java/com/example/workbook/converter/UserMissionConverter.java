package com.example.workbook.converter;

import com.example.workbook.domain.enums.MissionStatus;
import com.example.workbook.domain.mapping.UserMission;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;

public class UserMissionConverter {
    public static MissionResponseDto.AddMissionToListResultDto toAddUserMissionDto(UserMission userMission){
        return MissionResponseDto.AddMissionToListResultDto.builder()
                .missionId(userMission.getMission().getId())
                .userId(userMission.getUser().getId())
                .build();
    }

    public static UserMission toUserMission(){
        return UserMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }

}
