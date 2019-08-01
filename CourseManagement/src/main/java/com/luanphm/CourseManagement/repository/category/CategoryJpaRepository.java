package com.luanphm.CourseManagement.repository.category;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryJpaRepository extends MyInterfaceRepositoryJpa<Category, Integer> {

    @Query("SELECT new Category(c.id, c.name) " +
            "FROM Category c")
    List<Category> getAll();

    @Query("SELECT new Category(c.id, c.name) " +
            "FROM Category c " +
            "WHERE c.id = :id")
    Category getById(@Param("id") Integer id);
}
