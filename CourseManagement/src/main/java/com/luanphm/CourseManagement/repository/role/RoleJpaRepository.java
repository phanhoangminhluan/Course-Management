package com.luanphm.CourseManagement.repository.role;

import com.luanphm.CourseManagement.entity.Role;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleJpaRepository extends MyInterfaceRepositoryJpa<Role, Integer> {

    @Query( "SELECT new Role (e.id, e.name) FROM Role e")
    List<Role> getAll();

    @Query( "SELECT new Role (e.id, e.name) FROM Role e WHERE e.id = :id")
    Role getById(@Param("id") Integer integer);
}
