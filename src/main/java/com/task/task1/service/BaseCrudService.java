package com.task.task1.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.task.task1.model.dto.BaseDto;
import com.task.task1.model.entity.BaseEntity;
import com.task.task1.repo.BaseRepo;
import com.task.task1.service.exception.BusinessEntityNotFoundException;
import com.task.task1.service.mapper.BaseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Service
public abstract class BaseCrudService<E extends BaseEntity<PK>, D extends BaseDto, PK extends Serializable> {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final BaseRepo<E, PK> repo;
    private final BaseDtoMapper<E, D, PK> mapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    @Transactional
    public D save(D dto) {
        var entity = mapper.toEntity(dto, entityClass);
        log.debug("Saving {}", dto);
        var savedEntity = repo.save(entity);
        return mapper.toDto(savedEntity, dtoClass);
    }

    @Transactional
    public List<D> findAll() {
        List<E> entities = repo.findAll();
        log.debug("Found {} entities", entities.size());
        return mapper.toDto(entities, dtoClass);
    }

    @Transactional
    public D findById(PK id) {
        var entity = repo.findById(id).orElseThrow(() -> new BusinessEntityNotFoundException(id, entityClass));
        log.debug("Found {} by id {}", entity, id);
        return mapper.toDto(entity, dtoClass);
    }

    @Transactional
    public void delete(PK id) {
        log.debug("Deleting {} by id {}", entityClass, id);
        repo.deleteById(id);
    }

    @Transactional
    public void delete(D dto) {
        var entity = mapper.toEntity(dto, entityClass);
        log.debug("Deleting {} by id {}", entityClass, entity.getId());
        repo.delete(entity);
    }

}
