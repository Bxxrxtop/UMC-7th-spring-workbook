package com.example.workbook.converter;

import com.example.workbook.domain.common.User;
import com.example.workbook.domain.enums.Gender;
import com.example.workbook.web.dto.user.UserRequestDTO;
import com.example.workbook.web.dto.user.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .name(request.getName())
                .address(request.getAddress())
                .birth(request.getBirth())
                .gender(gender)
                .email(request.getEmail())
                .phone(request.getPhone())
                .userPreferList(new ArrayList<>())
                .build();
    }
}