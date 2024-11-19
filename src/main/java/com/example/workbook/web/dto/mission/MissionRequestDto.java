package com.example.workbook.web.dto.mission;

import com.example.workbook.validation.annotation.ChallengingMissions;
import com.example.workbook.validation.annotation.ExistRestaurant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDto {
    @Getter
    public static class AddMissionRequestDto{
        @NotBlank
        public String content;
        @NotNull
        public LocalDate deadline;
        @NotNull
        public Integer price;
        @ExistRestaurant
        public Long restaurantId;
    }

    @Getter
    @ChallengingMissions
    public static class AddMissionToListDto {
        @NotNull
        public Long missionId;
        @NotNull
        public Long userId;
    }
}
