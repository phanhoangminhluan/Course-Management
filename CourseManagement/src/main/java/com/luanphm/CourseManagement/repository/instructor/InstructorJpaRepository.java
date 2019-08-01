package com.luanphm.CourseManagement.repository.instructor;

import com.luanphm.CourseManagement.entity.Course;
import com.luanphm.CourseManagement.entity.Instructor;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorJpaRepository extends MyInterfaceRepositoryJpa<Instructor, String> {

    @Query( "SELECT new Instructor (e.user.id, e.youtubeChannel, e.salary) " +
            "FROM Instructor e ")
    List<Instructor> getAll();

    @Query( "SELECT new Instructor (e.user.id, e.youtubeChannel, e.salary) " +
            "FROM Instructor e " +
            "WHERE e.id = :id")
    Instructor getById(@Param("id") String s);
}
