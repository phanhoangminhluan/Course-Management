package com.luanphm.CourseManagement.repository.course_student;

import com.luanphm.CourseManagement.entity.CourseStudent;
import com.luanphm.CourseManagement.entity.CourseStudentId;
import com.luanphm.CourseManagement.repository.MyInterfaceRepositoryJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseStudentJpaRepository extends MyInterfaceRepositoryJpa<CourseStudent, CourseStudentId> {

    @Query( "SELECT new CourseStudent (e.id.courseId, e.id.studentId) " +
            "FROM CourseStudent e")
    List<CourseStudent> getAll();

    default CourseStudent getById(CourseStudentId courseStudentId) {
        return null;
    }
}
