package com.task.task1.service.exception;

import com.task.task1.model.entity.BaseEntity;

import java.io.Serializable;

public class BusinessEntityNotFoundException extends RuntimeException {

    public <PK extends Serializable, E extends BaseEntity<PK>> BusinessEntityNotFoundException(
            PK id, Class<E> idClass
    ) {
        super(String.format("Entity of type %s with id: %s not found", idClass.getName(), id));
    }

}
