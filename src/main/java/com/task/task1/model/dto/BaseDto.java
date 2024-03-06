package com.task.task1.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public abstract class BaseDto {
    private static final long serialVersionUID = 3767561412347525828L;

    private boolean isNew;
}
