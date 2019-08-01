package com.luanphm.CourseManagement.controller.SharedController;

import com.luanphm.CourseManagement.service.SharedService.MyInterfaceService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public abstract class MyAbstractController<ID, M> {

    protected MyInterfaceService<ID, M> service;

    @PostConstruct
    protected abstract void constructService();

    @GetMapping
    public ResponseEntity<M> getAll() {
        List<M> dtos = service.getAll();
        return new ResponseEntity(dtos, HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") ID id) {
        M dto = service.getById(id);
        return new ResponseEntity<M>(dto, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity add(@Valid @RequestBody M dto) {
        service.add(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody M dto) {
        service.update(dto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") ID id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
