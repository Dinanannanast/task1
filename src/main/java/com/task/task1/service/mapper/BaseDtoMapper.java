package com.task.task1.service.mapper;

import com.github.dozermapper.core.Mapper;
import com.task.task1.model.dto.BaseDto;
import com.task.task1.model.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Service
public abstract class BaseDtoMapper<E extends BaseEntity<PK>, D extends BaseDto, PK extends Serializable> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Mapper dozerBeanMapper;

    public E toEntity(D dto, Class<E> entityClass) {
        log.debug("Converting {} to {}", dto, dto.getClass());
        return dozerBeanMapper.map(dto, entityClass);
    }

    public D toDto(E entity, Class<D> dtoClass) {
        log.debug("Converting {} to {}", entity, entity.getClass());
        return dozerBeanMapper.map(entity, dtoClass);
    }

    public List<D> toDto(List<E> entities, Class<D> dtoClass) {
        log.debug("Converting {} amount of {} type to {} type",
                entities.size(), entities.stream().findFirst().getClass(), dtoClass);
        return entities.stream()
                .map(entity -> dozerBeanMapper.map(entity, dtoClass))
                .toList();
    }

    public List<E> toEntity(List<D> dtos, Class<E> entityClass) {
        log.debug("Converting {} amount of {} type to {} type",
                dtos.size(), dtos.stream().findFirst().getClass(), entityClass);
        return dtos.stream()
                .map(dto -> dozerBeanMapper.map(dto, entityClass))
                .toList();
    }
}
