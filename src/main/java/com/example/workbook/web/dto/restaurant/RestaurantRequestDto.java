package com.example.workbook.web.dto.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RestaurantRequestDto {

    @Getter
    public static class AddRestaurantDto {
        @NotBlank
        public String name;
        @NotBlank
        public String address;
        @NotBlank
        public Long regionId;
    }


}
