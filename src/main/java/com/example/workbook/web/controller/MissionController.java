package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.service.MissionService.MissionService;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @PostMapping
    public ApiResponse<MissionResponseDto.AddMissionResponseDto> addMission(@RequestBody @Valid MissionRequestDto.AddMissionRequestDto dto){
        MissionResponseDto.AddMissionResponseDto result = missionService.addMission(dto);
        return ApiResponse.onSuccess(result);
    }
}
