package com.task.task1.model.dto.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Pattern(regexp = "^$|^[а-яА-ЯёЁa-zA-Z\\s]+$", message = "Invalid country name")
public @interface ValidCountry {
    String message() default "Invalid country name";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
