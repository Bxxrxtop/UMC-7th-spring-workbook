package com.example.workbook.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResponseDto{
        public Long missionId;
        public String content;
        public LocalDate deadline;
        public Integer price;
        public Long restaurantId;
    }
}
