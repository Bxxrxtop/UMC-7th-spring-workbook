package com.example.workbook.web.dto.mission;

import com.example.workbook.web.dto.review.ReviewResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionToListResultDto {
        Long userId;
        Long missionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDto {
        List<MissionPreViewDto> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDto {
        String restaurantName;
        Long missionId;
        String content;
        LocalDate deadline;
        Integer price;
        LocalDate createdAt;
    }
}
