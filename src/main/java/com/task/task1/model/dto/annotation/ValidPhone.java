package com.task.task1.model.dto.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotBlank(message = "Phone number is required")
@Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number format")
public @interface ValidPhone {
    String message() default "Phone number is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
