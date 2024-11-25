package com.example.workbook.validation.annotation;


import com.example.workbook.validation.validator.PageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageValid {
    String message() default "옳바르지 않은 page 번호 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
