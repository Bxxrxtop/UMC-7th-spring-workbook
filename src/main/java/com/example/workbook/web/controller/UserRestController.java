package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.converter.UserConverter;
import com.example.workbook.domain.common.User;
import com.example.workbook.service.UserService.UserCommandService;
import com.example.workbook.web.dto.user.UserRequestDTO;
import com.example.workbook.web.dto.user.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }
}