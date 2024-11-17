package com.example.workbook.web.dto.user;

import com.example.workbook.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        LocalDate birth;
        @NotNull
        String phone;
        @NotNull
        String email;
        @ExistCategories
        List<Long> preferCategory;
    }
}