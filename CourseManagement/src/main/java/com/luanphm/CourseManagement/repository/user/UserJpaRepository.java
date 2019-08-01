package com.luanphm.CourseManagement.repository.user;

import com.luanphm.CourseManagement.entity.Category;
import com.luanphm.CourseManagement.entity.User;
import com.luanphm.CourseManagement.model.user.UserWithRoleDTO;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

public interface UserJpaRepository extends MyInterfaceRepositoryJpa<User, String> {

    @Query("SELECT new User(e.id, e.password, e.email, e.firstName, e.lastName, e.role.id) " +
            "FROM User e")
    List<User> getAll();

    @Query("SELECT new User(e.id, e.password, e.email, e.firstName, e.lastName, e.role.id) " +
            "FROM User e " +
            "WHERE e.id = :username")
    User getById(@Param("username") String username);

    @Query("SELECT e.categories " +
            "FROM User e " +
            "WHERE e.id = :username")
    List<Category> getCategoriesByUserId(@PathVariable("username") String username);

    @Query( "SELECT new User(e.id, e.password, e.email, e.firstName, e.lastName, e.role) " +
            "FROM User e " +
            "WHERE e.id = :username")
    User getUserWithRole(@Param("username") String username);
}
