package com.task.task1.model.dto.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull(message = "IIN is required")
@Pattern(regexp = "\\d{12}", message = "INN must contain exactly 12 digits")
public @interface ValidIin {
    String message() default "INN must contain exactly 12 digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
