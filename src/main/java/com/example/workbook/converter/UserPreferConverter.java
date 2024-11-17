package com.example.workbook.converter;

import com.example.workbook.domain.common.FoodCategory;
import com.example.workbook.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPrefer> toUserPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
