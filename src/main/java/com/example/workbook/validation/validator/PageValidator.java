package com.example.workbook.validation.validator;

import com.example.workbook.validation.annotation.PageValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<PageValid, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("옳바르지 않은 page번호 입니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
