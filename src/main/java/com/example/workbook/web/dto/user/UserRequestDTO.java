package com.example.workbook.web.dto.user;

import com.example.workbook.domain.enums.Role;
import com.example.workbook.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Integer gender;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        LocalDate birth;
        @NotNull
        String phone;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}