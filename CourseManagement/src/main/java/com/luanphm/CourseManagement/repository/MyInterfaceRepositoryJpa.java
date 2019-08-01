package com.luanphm.CourseManagement.repository;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyInterfaceRepositoryJpa<T extends MyBaseEntity, ID extends Serializable> extends CrudRepository<T, ID> {

    List<T> getAll();

    T getById(ID id);

    @Transactional
    default void add(Session session, T entity) {
        session.save(entity);
    }

    @Transactional
    default void update(Session session, T entity) {
        session.update(entity);
    }
}
