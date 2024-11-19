package com.example.workbook.validation.annotation;

import com.example.workbook.validation.validator.MissionChallengingValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionChallengingValidator.class)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ChallengingMissions {
    String message() default "미션이 이미 도전중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
