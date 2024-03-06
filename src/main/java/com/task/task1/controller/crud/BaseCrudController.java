package com.task.task1.controller.crud;

import com.task.task1.model.dto.BaseDto;
import com.task.task1.model.entity.BaseEntity;
import com.task.task1.service.BaseCrudService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseCrudController<E extends BaseEntity<PK>, D extends BaseDto, PK extends Serializable> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final BaseCrudService<E, D, PK> crudService;

    @GetMapping(path = "/find/{id}")
    @ResponseBody
    public ResponseEntity<D> findById(@PathVariable PK id) {
        return ResponseEntity.ok(crudService.findById(id));
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<D> findAll() {
        return crudService.findAll();
    }

    @PostMapping(path = "/save")
    @ResponseBody
    public ResponseEntity<D> save(@RequestBody @Validated D dto) {
        var saved = crudService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @PostMapping(path = "/delete")
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestBody D dto) {
        crudService.delete(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteById(@PathVariable PK id) {
        crudService.delete(id);
        return ResponseEntity.ok().build();
    }
}
