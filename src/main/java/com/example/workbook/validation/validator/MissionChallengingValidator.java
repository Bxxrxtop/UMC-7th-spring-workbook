package com.example.workbook.validation.validator;

import com.example.workbook.domain.enums.MissionStatus;
import com.example.workbook.repository.UserMissionRepository;
import com.example.workbook.validation.annotation.ChallengingMissions;
import com.example.workbook.web.dto.mission.MissionRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<ChallengingMissions, MissionRequestDto.AddMissionToListDto> {
    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(ChallengingMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDto.AddMissionToListDto value, ConstraintValidatorContext context) {
        if (value == null || value.getMissionId() == null || value.getUserId() == null) {
            return true;
        }
        boolean isAlreadyChallenging = userMissionRepository
                .existsByUserIdAndMissionIdAndStatus(
                        value.getUserId(),
                        value.getMissionId(),
                        MissionStatus.CHALLENGING
                );

        if (isAlreadyChallenging) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("미션이 이미 도전중입니다.")
                    .addPropertyNode("missionId")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

}
