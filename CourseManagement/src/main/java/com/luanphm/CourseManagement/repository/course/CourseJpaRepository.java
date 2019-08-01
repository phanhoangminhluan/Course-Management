package com.luanphm.CourseManagement.repository.course;

import com.luanphm.CourseManagement.entity.Course;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseJpaRepository extends MyInterfaceRepositoryJpa<Course, Integer> {

    @Query( "SELECT new Course (e.id, e.name, e.instructor.id) " +
            "FROM Course e")
    List<Course> getAll();

    @Query( "SELECT new Course (e.id, e.name, e.instructor.id) " +
            "FROM Course e " +
            "WHERE e.id = :id")
    Course getById(@Param("id") Integer id);

    @Query( "SELECT new Course (e.id, e.name) " +
            "FROM Course e " +
            "WHERE e.instructor.id = :id")
    List<Course> getCoursesByInstructor(@Param("id") String id);

    @Modifying
    @Query( value = "INSERT INTO course_category(category_id, course_id) VALUES (:categoryId, :courseId)", nativeQuery = true)
    @Transactional
    void addCategoryToCourse(int categoryId, int courseId);

    @Query(value = "SELECT e.category_id FROM course_category e WHERE e.course_id = :id", nativeQuery = true)
    List<Integer> getCategoriesByCourse(@Param("id") int courseId);
}
