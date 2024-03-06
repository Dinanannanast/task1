package com.task.task1.model.dto.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotBlank(message = "Second name is required")
@Size(min = 2, max = 50, message = "Second name must be between 2 and 50 characters")
public @interface ValidSecondName {
    String message() default "Second name is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}