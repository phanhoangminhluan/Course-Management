package com.luanphm.CourseManagement.service.SharedService;

import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.repository.MyAbstractSession;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class MyAbstractService<T extends MyBaseEntity, ID extends Serializable, M> extends MyAbstractSession implements MyInterfaceService<ID, M> {

    protected MyInterfaceRepositoryJpa<T, ID> repository;

    protected abstract M instantiateDTO(T entity);

    protected abstract T instantiateEntity(M dto);

    @PostConstruct
    protected abstract void constructRepository();

    public List<M> getAll() {

        List<T> entites = repository.getAll();

        List<M> dtos = mapEntityToModel(entites);

        return dtos;
    }

    public M getById(ID id) {
        T entity = repository.getById(id);
        M dto = instantiateDTO(entity);
        return dto;
    }

    public void add(M dto) {
        T entity = instantiateEntity(dto);
        try {
            repository.add(getSession(), entity);
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(M dto) {
        T entity = instantiateEntity(dto);
        try {
            repository.update(getSession(), entity);
        } catch (Exception e) {
            System.out.println("=========================================================");
            throw e;
        }
    }

    public void deleteById(ID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    protected List<M> mapEntityToModel(List<T> entities) {
        List<M> dtos = new ArrayList<>();
        entities.forEach(t -> dtos.add(instantiateDTO(t)));
        return dtos;
    }

}
