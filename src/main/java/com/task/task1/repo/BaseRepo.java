package com.task.task1.repo;

import com.task.task1.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepo<E extends BaseEntity<PK>, PK extends Serializable> extends JpaRepository<E, PK> {
}
