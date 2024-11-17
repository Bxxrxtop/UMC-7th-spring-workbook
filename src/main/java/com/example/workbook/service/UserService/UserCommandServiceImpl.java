package com.example.workbook.service.UserService;

import com.example.workbook.apiPayload.code.status.ErrorStatus;
import com.example.workbook.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.workbook.converter.UserConverter;
import com.example.workbook.converter.UserPreferConverter;
import com.example.workbook.domain.common.FoodCategory;
import com.example.workbook.domain.common.User;
import com.example.workbook.domain.mapping.UserPrefer;
import com.example.workbook.repository.FoodCategoryRepository;
import com.example.workbook.repository.UserRepository;
import com.example.workbook.web.dto.user.UserRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);
        userPreferList.forEach(memberPrefer -> {memberPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
