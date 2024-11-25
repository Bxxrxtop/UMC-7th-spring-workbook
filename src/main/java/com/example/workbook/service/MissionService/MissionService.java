package com.example.workbook.service.MissionService;

import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.mapping.UserMission;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import org.springframework.data.domain.Page;

public interface MissionService {
    MissionResponseDto.AddMissionResponseDto addMission(MissionRequestDto.AddMissionRequestDto dto);
    MissionResponseDto.AddMissionToListResultDto addMissionToList(MissionRequestDto.AddMissionToListDto dto);
    Page<Mission> restaurantMissionList(Long restaurantId, Integer page);
    Page<UserMission> getUserMissionList(Long userId, Integer page);
    void completeMission(Long userMissionId);
}
