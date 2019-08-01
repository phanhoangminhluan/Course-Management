package com.luanphm.CourseManagement.entity;

import com.luanphm.CourseManagement.entity.SharedEntity.MyBaseEntity;
import com.luanphm.CourseManagement.model.course_student.CourseStudentDTO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@Entity
@Table(name = "CourseStudent")
public class CourseStudent extends MyBaseEntity<CourseStudentId> {


    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

    @Column(name = "date_enroll")
    private Date dateEnroll = new Date();

    public CourseStudent(int courseId, String studentId) {
        this.id = CourseStudentId.builder()
                    .studentId(studentId)
                    .courseId(courseId)
                .build();
    }

    public CourseStudent(CourseStudentDTO dto) {
        this.id = CourseStudentId.builder()
                    .courseId(dto.courseId())
                    .studentId(dto.studentId())
                .build();
        this.dateEnroll = dto.dateEnroll();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudent that = (CourseStudent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

