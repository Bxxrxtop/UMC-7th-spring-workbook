package com.example.workbook.web.controller;

import com.example.workbook.apiPayload.ApiResponse;
import com.example.workbook.converter.UserConverter;
import com.example.workbook.domain.common.User;
import com.example.workbook.service.UserService.UserCommandService;
import com.example.workbook.web.dto.user.UserRequestDTO;
import com.example.workbook.web.dto.user.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

}