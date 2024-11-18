package com.example.workbook.service.MissionService;

import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;

public interface MissionService {
    MissionResponseDto.AddMissionResponseDto addMission(MissionRequestDto.AddMissionRequestDto dto);
}
