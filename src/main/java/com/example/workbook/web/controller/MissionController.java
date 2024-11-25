package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.converter.MissionConverter;
import com.example.workbook.domain.common.Mission;
import com.example.workbook.domain.mapping.UserMission;
import com.example.workbook.service.MissionService.MissionService;
import com.example.workbook.validation.annotation.PageValid;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import com.example.workbook.web.dto.mission.MissionResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/toList")
    public ApiResponse<MissionResponseDto.AddMissionToListResultDto> addMissionToList(@RequestBody @Valid MissionRequestDto.AddMissionToListDto dto){
        MissionResponseDto.AddMissionToListResultDto result = missionService.addMissionToList(dto);
        return ApiResponse.onSuccess(result);
    }

    @GetMapping("/restaurants/{restaurantId}")
    @Operation(summary = "특정 식당의 미션 목록 조회 API",description = "특정 식당의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "식당의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDto.MissionPreViewListDto> getRestaurantMissionList(@PathVariable(name = "restaurantId") Long restaurantId, @PageValid @RequestParam(name = "page") Integer page){
        Page<Mission> missions = missionService.restaurantMissionList(restaurantId, page);
        return ApiResponse.onSuccess(MissionConverter.MissionPreViewListDto(missions));
    }
    @GetMapping("/users/{userId}")
    @Operation(summary = "특정 유저의 미션 목록 조회 API",description = "특정 유저의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDto.MissionPreViewListDto> getUserMissionList(@PathVariable(name = "userId") Long userId, @PageValid @RequestParam(name = "page") Integer page){
        Page<UserMission> missions = missionService.getUserMissionList(userId, page);
        return ApiResponse.onSuccess(MissionConverter.UserMissionPreViewListDto(missions));
    }
}
